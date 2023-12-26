package com.example.Registration.Responses;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GlobalResponse  {
    private Object response = new Object();
    private String responseIndicator;
    private String statusCode;
    private String responseMessage;
}
