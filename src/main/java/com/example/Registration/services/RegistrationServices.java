package com.example.Registration.services;


import com.example.Registration.Entites.Users;
import com.example.Registration.Exceptions.IoExceptionCustom;
import com.example.Registration.Exceptions.ValidationException;
import com.example.Registration.ResponseDTO.userResponseDto;
import com.example.Registration.Transformers.UserTouserResponseDto;
import com.example.Registration.Transformers.addUserToUser;
import com.example.Registration.UserRequestDTO.addUserDto;
import com.example.Registration.repositorys.UsersRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RegistrationServices {


    @Autowired
    UsersRepo usersRepo;

    public userResponseDto userRegistration(addUserDto addUserDto) throws Exception {
        Optional<Users> user = Optional.ofNullable(usersRepo.findByGmail(addUserDto.getGmail()));

        try {
            if (!user.isPresent()) {
                Users newUser = addUserToUser.addUserToUser(addUserDto);
                userResponseDto responseDto = UserTouserResponseDto.UserTouserResponseDto(newUser);
                usersRepo.save(newUser);
                log.info("user registration success");
                return responseDto;
            } else {
                log.warn(addUserDto.getGmail() + "is already present");
                throw new ValidationException("400", "is gmail is already present", "1");
            }
        } catch (ValidationException vx) {
            throw vx;
        } catch (Exception e) {
            throw e;
        }


    }
    public userResponseDto  userValidation(String gmail,String password){
        Optional<Users> user= Optional.ofNullable(usersRepo.findByGmail(gmail));
try{
    if(user.isPresent()){
        if(password!=user.get().getPassword()){
            throw new IoExceptionCustom("400","password is incorrect","1");
        }
        userResponseDto responseDto=UserTouserResponseDto.UserTouserResponseDto(user.get());
        return responseDto;

    }else{
        throw new ValidationException("400","gmail id not present","1");

    }
}catch (IoExceptionCustom ex){
 throw ex;
}catch (ValidationException vx){
    throw vx;
}catch (Exception e){
    throw e;
}
    }


    public List<userResponseDto>  allusers(){

        List<Users> users=usersRepo.findAll();
        List<userResponseDto> ans=new ArrayList<>();
        for(Users u:users){
            userResponseDto responseDto=UserTouserResponseDto.UserTouserResponseDto(u);
            ans.add(responseDto);
        }

        return ans;
    }


    public userResponseDto userDelete(String gmail){
        Optional<Users> users= Optional.ofNullable(usersRepo.findByGmail(gmail));

        try{
            if(!users.isPresent()){
                throw new IoExceptionCustom("200","gmail id is not present","0");
            }

            usersRepo.deleteById(users.get().getUser_id());

            return  UserTouserResponseDto.UserTouserResponseDto(users.get());
        }catch (IoExceptionCustom Ix){
            throw Ix;
        }catch (Exception e){
            throw e;
        }


    }


}
