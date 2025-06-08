package com.employeemgmt.empMgmtSystem.advise;


import com.employeemgmt.empMgmtSystem.exceptions.ResourceNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> resourceNotFoundExceptionHandlerMethod(ResourceNotFoundException exception){
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message("Resource Not Found").build();
        return buildApiErrorResponse(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> allExceptionMethod(Exception exception) {
        ApiError apiError = ApiError.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message("Internal server error").build();
        return buildApiErrorResponse(apiError);
    }


    //we are returning api response which has the customized global response format
    //for all sort of requests, by doing this we are populating the error field of api response class
    //which will populate the error field in postman's resposne not the data field
    private ResponseEntity<ApiResponse<?>> buildApiErrorResponse(ApiError error){
        return new ResponseEntity<>(new ApiResponse<>(error), HttpStatus.NOT_FOUND);
    }
}
