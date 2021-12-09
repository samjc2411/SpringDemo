package com.example.demo.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.EmployeeRequest;
import com.example.demo.service.EmployeeService;
 
@RestController
@RequestMapping("/employees")
public class EmployeeController
{
	
	 Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	
    @Autowired
    EmployeeService employeeService;
    
    /**
     * This method returns all employees
     * @return
     */
 
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
    	logger.info("getAllEmployees Controller - Start");
        List<EmployeeEntity> list = employeeService.getAllEmployees();
        logger.info("getAllEmployees Controller - End");
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    /**
     * This method returns employees by Id
     * @param id
     * @return
     * @throws RecordNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
                                                  throws RecordNotFoundException {
    	logger.info("getEmployeeById Controller - Start");
        EmployeeEntity entity = employeeService.getEmployeeById(id);
        logger.info("getEmployeeById Controller - End");
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    /**
     * This Method Creates employees 
     * @param employee
     * @return
     * @throws RecordNotFoundException
     */
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeRequest employee)
                                                    throws RecordNotFoundException {
    	logger.info("createOrUpdateEmployee Controller - Start");
        EmployeeEntity updated = employeeService.createOrUpdateEmployee(employee);
        logger.info("createOrUpdateEmployee Controller - End");
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
 
}