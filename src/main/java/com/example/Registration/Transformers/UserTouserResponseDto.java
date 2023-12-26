package com.example.Registration.Transformers;

import com.example.Registration.Entites.Users;
import com.example.Registration.ResponseDTO.userResponseDto;

public class UserTouserResponseDto {

    public static userResponseDto UserTouserResponseDto(Users users){

        userResponseDto responseDto= userResponseDto.builder().Name(users.getName())
                .Gmail(users.getGmail()).Gender(users.getGender()).build();
        return responseDto;
    }
}
