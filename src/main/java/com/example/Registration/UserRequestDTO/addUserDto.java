package com.example.Registration.UserRequestDTO;


import com.example.Registration.Enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class addUserDto {

    private String Name;


    private Gender Gender;


    private String Gmail;

    private String Password;
}
