package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.EmployeeRequest;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.web.EmployeeController;
 
@Service
public class EmployeeService {
	
	 Logger logger = LoggerFactory.getLogger(EmployeeService.class);
     
    @Autowired
    EmployeeRepository employeeRepository;
     
    public List<EmployeeEntity> getAllEmployees()
    {
    	logger.info("EmployeeService : getAllEmployees - Start");
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        logger.info("EmployeeService : getAllEmployees - End");
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
        
    }
     
    public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException
    {
    	logger.info("EmployeeService : getEmployeeById - Start");
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        logger.info("EmployeeService : getEmployeeById - End");
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public EmployeeEntity createOrUpdateEmployee(EmployeeRequest request) throws RecordNotFoundException
    {
        EmployeeEntity entity = new EmployeeEntity();
    	entity.setEmail(request.getEmail());
    	entity.setFirstName(request.getFirstName());
    	entity.setLastName(request.getLastName());
        entity = employeeRepository.save(entity);  
        return entity;
        	
        
    }
     
}