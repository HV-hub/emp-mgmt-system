package com.employeemgmt.empMgmtSystem.services;

import com.employeemgmt.empMgmtSystem.DTOs.EmployeeDTO;
import com.employeemgmt.empMgmtSystem.entities.EmployeeEntity;
import com.employeemgmt.empMgmtSystem.exceptions.ResourceNotFoundException;
import com.employeemgmt.empMgmtSystem.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<EmployeeDTO> getEmployees(){
        List<EmployeeEntity> employees= employeeRepository.findAll();
        return employees.stream()
                .map(employee->
                        modelMapper.map(employee, EmployeeDTO.class)).
                collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeesbyId(Integer id){
        boolean isExist = employeeExistsbyId(id);
        if(!isExist)
            throw new ResourceNotFoundException("");

        EmployeeEntity employeeEntity= employeeRepository.findById(id).orElse(null);
                return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO saveEmployees(EmployeeDTO e){
        EmployeeEntity entity = modelMapper.map(e,EmployeeEntity.class);
        EmployeeEntity employeeEntity= employeeRepository.save(entity);
       // return modelMapper.map(employeeEntity, EmployeeDTO.class);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public void deleteEmployeebyId(Integer id){
        boolean isExist = employeeExistsbyId(id);
        if(!isExist)
            throw new ResourceNotFoundException("");
          employeeRepository.deleteById(id);

    }

    public boolean employeeExistsbyId(int employeeId){
        return employeeRepository.existsById(employeeId);
    }
}
