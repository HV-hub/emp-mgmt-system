    package com.employeemgmt.empMgmtSystem.controllers;


    import com.employeemgmt.empMgmtSystem.DTOs.EmployeeDTO;
    import com.employeemgmt.empMgmtSystem.entities.EmployeeEntity;
    import com.employeemgmt.empMgmtSystem.exceptions.ResourceNotFoundException;
    import com.employeemgmt.empMgmtSystem.services.EmployeeService;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.HttpStatusCode;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.NoSuchElementException;

    @RestController
    public class EmployeeController {

        @Autowired
        private EmployeeService employeeService;

        @GetMapping("/employees")
        public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
           //return ResponseEntity.ok(employeeService.getEmployees());
            List<EmployeeDTO> listOfEmployees= employeeService.getEmployees();
           if(listOfEmployees==null || listOfEmployees.isEmpty())
               throw new ResourceNotFoundException("");   //method below annotated with @exceptionhandler will be called
            return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
        }

        @GetMapping("employees/{id}")
        public ResponseEntity<EmployeeDTO> getEmployeesbyId(@PathVariable Integer id){
            return ResponseEntity.ok(employeeService.getEmployeesbyId(id));
        }

        @PostMapping("/employees")
        public ResponseEntity<EmployeeDTO> saveEmployees(@RequestBody @Valid EmployeeDTO e){
            return new ResponseEntity<>(employeeService.saveEmployees(e),HttpStatusCode.valueOf(201));
        }

        @DeleteMapping("employees/{id}")
        public void deleteEmployeebyId(@PathVariable Integer id){
            employeeService.deleteEmployeebyId(id);
        }

//        //handles exception anywhere in code, never breaks the code and gives a very clean one line message
//        @ExceptionHandler(NoSuchElementException.class)
//        public ResponseEntity<String> exceptionHandlerMethod(NoSuchElementException exception){
//            return new ResponseEntity<>("Employees Not found",HttpStatus.NOT_FOUND);
//        }
    }
