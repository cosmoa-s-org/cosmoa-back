package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.UserDTO;
import com.kumoh.cosmoa.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserDTO> findAll() {
        return userMapper.getUserList();
    }
    
    public int signUp(UserDTO userDto) {
    	return userMapper.signUp(userDto);
    }
    
    public int deleteUserByEmail(String email) {
    	return userMapper.deleteUserByEmail(email);
    }
    
    public int updateUser(UserDTO userDto) {
    	return userMapper.updateUser(userDto);
    }
}