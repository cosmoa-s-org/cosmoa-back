package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDTO> getUserList();
    List<UserDTO> getUser1();
    int signUp(UserDTO userDto);
    int deleteUserByEmail(String email);
    int updateUser(UserDTO userDto);
}
