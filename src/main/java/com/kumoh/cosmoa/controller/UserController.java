package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.dto.UserDTO;
import com.kumoh.cosmoa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<?> getUserList() {
        List<UserDTO> dtos = userService.findAll();
        ResponseDTO<List<UserDTO>> response = ResponseDTO.<List<UserDTO>>builder().data(dtos).build();
     
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping("/isExistEmail/{email}")
    public ResponseEntity<?> isExistEmail(@PathVariable String email) {
    	try {
    		UserDTO dto = userService.findUserByEmail(email);
    		if(dto!=null)
    		{
    			return ResponseEntity.ok().body(ResponseDTO.builder().data("이미 존재하는 이메일 입니다.").build());
    		}
    		else
    		{
    			return ResponseEntity.ok().body(ResponseDTO.builder().data("사용 할 수 있는 이메일 입니다.").build());
    		}    		
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
    	}
    		
    }
    
    @PostMapping("")
    public ResponseEntity<?> signUp(@RequestBody UserDTO userDto) {
    	try {
    		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    		userDto.setPassword(encoder.encode(userDto.getPassword()));
    		int result = userService.signUp(userDto);
    		if(result==1)
    		{
    			return ResponseEntity.ok().body(ResponseDTO.builder().data("유저 등록 성공").build());
    		}
    		else
    		{
    			return ResponseEntity.ok().body(ResponseDTO.builder().data("유저 등록 실패").build());
    		}    		
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
    	}
    }
    
    @PutMapping("/{email}")
    public ResponseEntity<?> updateUser(@PathVariable String email, UserDTO userDto) {
    	try {
    		userDto.setEmail(email);
    		int result = userService.updateUser(userDto);
    		if(result==1)
    		{
    			return ResponseEntity.ok().body(ResponseDTO.builder().data("유저 정보 수정 성공").build());
    		}
    		else
    		{
    			return ResponseEntity.ok().body(ResponseDTO.builder().data("유저 정보 수정 실패").build());
    		}	
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
    	}
    }
    
    
    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteUserByEmail(@PathVariable String email) {
    	try {
    		int result = userService.deleteUserByEmail(email);
    		
    		if(result==1)
    		{
    			return ResponseEntity.ok().body(ResponseDTO.builder().data(email + " 유저 삭제 완료").build());
    		}
    		else
    		{
    			return ResponseEntity.ok().body(ResponseDTO.builder().data("유저 삭제 실패").build());
    		}
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
    	}
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO dto){
		log.info("user dto : {}", dto != null);
    	try {

    		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    		UserDTO originalUser = userService.findUserByEmail(dto.getEmail());
    		if(encoder.matches(dto.getPassword(), originalUser.getPassword()))
    		{
    			return ResponseEntity.ok().body(ResponseDTO.builder().data(originalUser).build());
    		}
    		else return ResponseEntity.ok().body(ResponseDTO.builder().error(("비밀번호 불일치")).build());
    		
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
    	}
    }
    
    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/user/login";
      }
}
