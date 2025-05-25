package com.employeemgmt.empMgmtSystem.advise;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Data


public class ApiResponse<T> {


    private boolean success;
    private int totalCount;
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

    public ApiResponse(){

        this.timeStamp= LocalDateTime.now();

    }
    public ApiResponse(T data) {
        this.timeStamp= LocalDateTime.now();
        this.success=true;
        this.totalCount= calculateSize(data);
        this.data=data;
    }
    public ApiResponse(ApiError error){
        this.timeStamp= LocalDateTime.now();
        this.success=false;
        this.error=error;
    }

    private int calculateSize(T data){
        if(data instanceof java.util.Collection)
            return (((Collection<?>) data).size());
        else if(data!=null)
            return 1;
        else
            return 0;
    }

}
