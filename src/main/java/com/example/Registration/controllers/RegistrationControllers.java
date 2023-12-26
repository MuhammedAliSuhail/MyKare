package com.example.Registration.controllers;


import com.example.Registration.Entites.Users;
import com.example.Registration.Exceptions.IoExceptionCustom;
import com.example.Registration.Exceptions.ValidationException;
import com.example.Registration.Responses.GenerateGlobalResponse;
import com.example.Registration.UserRequestDTO.addUserDto;
import com.example.Registration.services.RegistrationServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Registration")
@Slf4j
public class RegistrationControllers {

  @Autowired
    GenerateGlobalResponse generateGlobalResponse;
    @Autowired
    RegistrationServices registrationServices;
    @PostMapping("/userRegistration")
    public ResponseEntity userRegistration(@RequestBody addUserDto addUserDto){
      try {
        return new ResponseEntity(generateGlobalResponse
                .generateGlobalResponse(registrationServices.userRegistration(addUserDto), "2", "200", "user  registraed successfully"), HttpStatus.OK);
      } catch (ValidationException vx){
          log.info("categoryController->categoryService->ValidationException");
          log.info(vx.getMessage());
          log.info(vx.toString());
          log.info(vx.getErrorResponse().getResponseIndicator());
          return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,vx.getErrorResponse().getResponseIndicator(),
                  vx.getErrorResponse().getStatusCode(),vx.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (IoExceptionCustom ex){
          log.info("categoryController->categoryService->IoException");
          log.info(ex.getMessage());
          log.info(ex.toString());
          log.info(ex.getErrorResponse().getResponseIndicator());
          return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(null,ex.getErrorResponse().getResponseIndicator(),
                  ex.getErrorResponse().getStatusCode(),ex.getErrorResponse().getResponseMessage()),HttpStatus.OK);
        }catch (Exception e){
          e.printStackTrace();
          return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(
                  null, "constants.getRESPONSE_INDICATOR_ERROR_0()", "constants.getSUCCESSFULL_RESPONSE_CODE_200()",
                  "propertiesUtil.getApplicationMessages().getProperty"), HttpStatus.OK);
        }
    }


}
