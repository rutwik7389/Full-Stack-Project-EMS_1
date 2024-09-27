/*package com.waytosuccess.controller;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.waytosuccess.entity.Employee;
import com.waytosuccess.repository.EmployeeRepoditory;

@RestController
public class EmployeeController {

    @Autowired  // Correct the annotation here
    private EmployeeRepoditory employeeRepoditory;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepoditory.findAll();
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
    	return employeeRepoditory.save(employee);
    }
    
    
}*/
package com.waytosuccess.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.waytosuccess.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.waytosuccess.entity.Employee;
import com.waytosuccess.repository.EmployeeRepoditory;


@RestController
@CrossOrigin(origins = "http://localhost:4200")  // Allow Angular requests
public class EmployeeController {

    @Autowired
    private EmployeeRepoditory employeeRepoditory;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepoditory.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        System.out.println("Received Employee Data: " + employee); // For debugging
        return employeeRepoditory.save(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeRepoditory.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employeeDetails){
    	
    	 Employee employee = employeeRepoditory.findById(id)
    	            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
    	
    	 employee.setFirstName(employeeDetails.getFirstName());
    	 employee.setLastName(employeeDetails.getLastName());
    	 employee.setSalary(employeeDetails.getSalary());
    	 employeeRepoditory.save(employee);
    	 return ResponseEntity.ok(employee);
    	 
    	 
    }
    
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> DeleteEmployee(@PathVariable int id){
    	Employee employee = employeeRepoditory.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
    	employeeRepoditory.delete(employee);
    	Map<String, Boolean>response=new HashMap<String,Boolean>();
    	response.put("Deleted",Boolean.TRUE);
    	return ResponseEntity.ok(response);
    }
    
    
}
