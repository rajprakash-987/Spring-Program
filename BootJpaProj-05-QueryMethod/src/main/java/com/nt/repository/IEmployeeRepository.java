package com.nt.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
//	@Query("from Employee")
//	@Query("from Employee emp")
//	@Query("from com.nt.entity.Employee as emp")
	
	/*@Query("select emp from com.nt.entity.Employee as emp")                  
	public List<Employee> showAllEmployees();
	
	@Query("from Employee where sal>=?1 and  sal<=?2")                          
	public List<Employee> showEmpsBySalaryRange(double start,double end);
	
	@Query("from Employee where sal>=:min and  sal<=:max")
	public List<Employee> fetchEmpsBySalaryRange(@Param("min")double start,@Param("max")double end);
	
	@Query("from Employee where sal>=:min and  sal<=:max")
	public List<Employee> loadEmpsBySalaryRange(double min,double max);  */
	
	
	/*@Query("from Employee where job in (:desg1,:desg2,:desg3)")                        //Entity Query
	public List<Employee> showEmpByDesgs(String desg1,String desg2,String desg3);
	
	@Query("select empno,ename,job from Employee where job in (:desg1,:desg2,:desg3)")  //Scallar query getting specific column values
	public List<Object[]> showEmpDataByDesg(String desg1,String desg2,String desg3);
	
	@Query("select ename from Employee where ename like :initChars")                     //scalar query getting specific single col value
	public List<String> showEmpNameByNameChars(String initChars);*/
	
	/*@Query("from Employee where ename=:name")                                            //single record entity query
	public Employee fetchEmpByName(String name);
	
	@Query("select empno,ename,job from Employee where ename=:name")                    //single record scalar query giving multiple values
	public Object fetchEmpDataByName(String name);
	
	@Query("select sal from Employee where ename=:name")                           //single record scalar query giving single values
	public Double fetchEmpSalaryByName(String name);*/
	
	/*@Query("select count(distinct ename) from Employee")
	public long showEmpsCount();
	
	@Query("select count(*),max(sal),min(sal),avg(sal),sum(sal) from Employee")
	public Object showAgregateData();*/
	
	//==========================Non select operation======================//
	
	/*@Transactional
	@Modifying
	@Query("update Employee set sal=sal+(sal*:percentage/100.0) where job=:desg")
	public int hikeSalaryByDesg(String desg,float percentage);*/
	
	/*@Transactional
	@Modifying
	@Query("delete Employee where sal>=:start and sal<=:end")
	public int removeEmpsBySalaryRange(double start,double end);*/
	
	
	@Query(value="SELECT SYSDATE FROM DUAL",nativeQuery=true)
	public LocalDateTime showSystemDate();

}
