package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository emprepo;

	@Override
	public List<Employee> showAllEmployee() {
		List<Employee> list=StreamSupport.stream(emprepo.findAll().spliterator(), false).toList();
//		return list.stream().sorted().toList();  //perform natural sorting
		return list.stream().sorted((emp1,emp2)->emp1.getEname().compareTo(emp2.getEname())).toList();  //sorting based on ename
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
	
@Override
	public List<Employee> showEmployeeReportWithDynamicSearch(Employee emp) {
		//replace emptry string with null value
		if(emp.getEname().equalsIgnoreCase("")|| emp.getEname().length()==0)
			emp.setEname(null);
		if(emp.getJob().equalsIgnoreCase("")|| emp.getJob().length()==0)
			emp.setJob(null);
		//prepare example obj having Employee object
		Example example=Example.of(emp);
		//use repo
		List<Employee> list=emprepo.findAll(example);
		return list;
	}

}
