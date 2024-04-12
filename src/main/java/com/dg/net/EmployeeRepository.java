package com.dg.net;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByNameAndJobTitleAndCompanyNameAndCompanySizeAndCountry(String name, String jobTitle,
			String companyName, String companySize, String country);
    // Define custom search methods if needed
}
