package com.employeemgmt.empMgmtSystem.advise;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {

    private String message;
    private HttpStatus status;
}
