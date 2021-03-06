package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wipro.model.Employee;
import com.wipro.model.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepository emp;
	
	@ResponseBody
	@PostMapping(path = "/add")
	public String addEmployee(@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam String location) {
		Employee e = new Employee(id, name, email, location);
		emp.save(e);
		return "<h2>Employee added successfully</h2>";
	}
	
	@ResponseBody
	@GetMapping(path = "/displayAll")
	public List<Employee> getAllEmployees() {
		return (List<Employee>) emp.findAll();
	}
	
	@ResponseBody
	@GetMapping(path = "/display/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		return emp.findById(id);
	}
}
