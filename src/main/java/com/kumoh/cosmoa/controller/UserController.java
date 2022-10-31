package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.dto.UserDTO;
import com.kumoh.cosmoa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
