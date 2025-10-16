package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;
@Service("empService")
public class EmployeeServiceImpl implements IEmployeeManagementService {
	@Autowired
//	@Qualifier("empMySQLDAO")
//	@Qualifier("empOraDAO")
	@Qualifier("dbdao")
	
	private IEmployeeDAO dao;

	@Override
	public List<Employee> fetchEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
		
		//conver desg to upper case latter
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		
		//use dao
		List<Employee> list=dao.getEmpsByDesgs(desg1, desg2, desg3);
		//sort the object in list collection
		list.sort((t1,t2)->t1.getEmpno().compareTo(t2.getEmpno()));
		//calculATE GROSS SAL AND NET SAL
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSal()+(emp.getSal()*0.5));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2));
		});
		return list;
		
		
	}

	@Override
	public String registerEmployee(Employee emp) throws Exception {
		//use DAO
		int result=dao.insertEmployee(emp);
		
		return result==0?"Employee not Registerd":"Employee is registerd";
	}

}
