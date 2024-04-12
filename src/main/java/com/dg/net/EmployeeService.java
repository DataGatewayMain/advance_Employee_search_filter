package com.dg.net;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> searchEmployees(String name, String jobTitle, String companyName, String companySize, String country) {
        // Implement search logic here using the repository
        return employeeRepository.findByNameAndJobTitleAndCompanyNameAndCompanySizeAndCountry(name, jobTitle, companyName, companySize, country);
    }

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
}