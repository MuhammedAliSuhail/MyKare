package com.example.Registration.ResponseDTO;

import com.example.Registration.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userResponseDto {

    private String Name;


    private Gender Gender;


    private String Gmail;

    private String Password;
}
