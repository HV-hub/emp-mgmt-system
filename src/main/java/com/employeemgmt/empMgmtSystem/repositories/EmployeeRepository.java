package com.employeemgmt.empMgmtSystem.repositories;


import com.employeemgmt.empMgmtSystem.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
