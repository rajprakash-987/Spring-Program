package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	public Page<Employee> showAllEmployeeByPagination(Pageable pageable);
	public String registerEmployee(Employee emp);
	public Employee fetchEmployeebyiD(int id);
	public String editEmployee(Employee emp);
	public String deleteEmployeeById(int id);

}
