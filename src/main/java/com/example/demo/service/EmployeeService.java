package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.DepartmentEntity;
import com.example.demo.model.DeptData;
import com.example.demo.model.EmployeeData;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.EmployeeRequest;
import com.example.demo.model.LeaveData;
import com.example.demo.model.LeaveEntity;
import com.example.demo.model.RestResponse;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRepository;
import com.example.demo.web.EmployeeController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.speedment.jpastreamer.application.JPAStreamer;
 
@Service
public class EmployeeService {
	
	 Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	 
	 private final JPAStreamer streamer;

	   public EmployeeService(JPAStreamer streamer) {
	      this.streamer = streamer;
	   }
     
    @Autowired
    EmployeeRepository employeeRepository;
    
   
     
    public String getAllEmployees()
    {
    	ObjectMapper objectMapper = new ObjectMapper();
    	String json = "";
    	logger.info("EmployeeService : getAllEmployees - Start");
    	List<RestResponse> respList = new ArrayList<RestResponse>();
        List<EmployeeEntity> employeeList = streamer.stream(EmployeeEntity.class) 
        		.collect(Collectors.toList());   
       
        logger.info("EmployeeService : getAllEmployees - End");
        if(employeeList.size() > 0) {
        	buildResponse(employeeList,respList);
        	 try {
    			 json = objectMapper.writeValueAsString(respList);
    		} catch (JsonProcessingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        } 
        return json;
    }
    
  


	private void buildResponse(List<EmployeeEntity> employeeList, List<RestResponse> respList) {
    	RestResponse response = null;
    	EmployeeData employeeData = null;
    	
    	for (EmployeeEntity emp : employeeList) {
    		response = new RestResponse();
    		employeeData = new EmployeeData();
    		employeeData.setName(emp.getFirstName() + ' ' + emp.getLastName());
    		employeeData.setEmail(emp.getEmail());
    		List<LeaveData> leaveList = new ArrayList<LeaveData>();
    		List<DeptData> deptList = new ArrayList<DeptData>();
    		 for (Iterator<LeaveEntity> it = emp.getLeaveList().iterator(); 
    				 it.hasNext(); )
    		 {
    			 LeaveEntity ent = it.next();
    			 LeaveData leave = new LeaveData();
    			 leave.setLeaveType(ent.getLeaveType());
    			 leave.setLeaveStatus(ent.getStatus());
    			 leaveList.add(leave);
    		 }
    		 
    		 for (Iterator<DepartmentEntity> it = emp.getDeptList().iterator(); 
    				 it.hasNext(); )
    		 {
    			 DepartmentEntity enti = it.next();
    			 DeptData deptd = new DeptData();
    			 deptd.setDeptHead(enti.getDeptHead());
    			 deptd.setDeptName(enti.getDeptName());
    			 deptList.add(deptd);
    		 }
    		 
    		 employeeData.setDeptMapped(deptList);
    		 employeeData.setLeaveDetails(leaveList);
    		 response.setEmployee(employeeData);
    		respList.add(response);
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