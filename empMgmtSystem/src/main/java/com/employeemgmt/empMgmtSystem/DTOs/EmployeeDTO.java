package com.employeemgmt.empMgmtSystem.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3, max= 10, message ="Number of characters should be more than 3 and less than 18")
    private  String name;

    @Max(value = 80, message = "Age should not be more than 80")
    @Min(value=18, message = "Age should be more than 18")
    private Integer age;

    @PastOrPresent
    private LocalDate dateOfJoining;

    @Email
    private String email;

    @Positive
    private Integer Salary;

}

