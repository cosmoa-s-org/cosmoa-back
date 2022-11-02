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
    
    public List<UserDTO> findUser1() {
    	return userMapper.getUser1();
    }
    
    public int signUp(UserDTO userdto) {
    	return userMapper.signUp(userdto);
    }
    
    public int deleteUserByEmail(String email) {
    	return userMapper.deleteUserByEmail(email);
    }
    
    public int updateUser(UserDTO userdto) {
    	return userMapper.updateUser(userdto);
    }
}