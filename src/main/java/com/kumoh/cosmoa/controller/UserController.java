package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.dto.UserDTO;
import com.kumoh.cosmoa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
    
    @PostMapping("")
    public ResponseEntity<?> signUp(UserDTO userDto) throws Exception{
    	int result = userService.signUp(userDto);
    	
    	return ResponseEntity.ok().body(result);
    }
    
    @PutMapping("/{email}")
    public ResponseEntity<?> updateUser(@PathVariable String email, UserDTO userDto) throws Exception{
    	userDto.setEmail(email);
    	int result = userService.updateUser(userDto);
    	
    	return ResponseEntity.ok().body(result);
    }
    
    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteUserByEmail(@PathVariable String email) throws Exception{
    	int result = userService.deleteUserByEmail(email);
    	
    	return ResponseEntity.ok().body(result);
    }
}
