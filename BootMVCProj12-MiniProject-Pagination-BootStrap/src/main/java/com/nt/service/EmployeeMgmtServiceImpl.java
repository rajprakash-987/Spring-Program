package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository emprepo;

	@Override
	public Page<Employee> showAllEmployeeByPagination(Pageable pageable) {
		  Page<Employee> page=emprepo.findAll(pageable);
		  return page;
	}
	
	@Override
	public String registerEmployee(Employee emp) {
		//use service
		int idVal=emprepo.save(emp).getEmpno();
		return "Employee is registered with the id value:"+idVal;
	}
	
	@Override
	public Employee fetchEmployeebyiD(int id) {
		return emprepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
	}
	@Override
	public String editEmployee(Employee emp) {
		Optional<Employee> opt=emprepo.findById(emp.getEmpno());
		if(opt.isPresent()) {
			emprepo.save(emp);
			return emp.getEmpno()+"employee is updated";
		}
		return emp.getEmpno()+"Employee is not found for updation";
	}
	@Override
	public String deleteEmployeeById(int id) {
		Optional<Employee> opt=emprepo.findById(id);
		if(opt.isPresent()) {
			emprepo.deleteById(id);
			return id+"employee is deleted";
		}
		return id+"employee is not found for deletion";
	}

}
