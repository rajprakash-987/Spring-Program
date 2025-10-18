package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> showAllEmployee();
	public String registerEmployee(Employee emp);
	public Employee fetchEmployeebyiD(int id);
	public String editEmployee(Employee emp);
	public String deleteEmployeeById(int id);
	public List<Employee> showEmployeeReportWithDynamicSearch(Employee emp);

}
