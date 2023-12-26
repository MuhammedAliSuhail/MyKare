package com.example.Registration.Transformers;

import com.example.Registration.Entites.Users;
import com.example.Registration.UserRequestDTO.addUserDto;

public class addUserToUser {

    public static Users addUserToUser(addUserDto addUserDto){
        Users users= Users.builder().name(addUserDto.getName()).gmail(addUserDto.getGmail())
                .gender(addUserDto.getGender()).password(addUserDto.getPassword()).build();

        return users;
    }
}
