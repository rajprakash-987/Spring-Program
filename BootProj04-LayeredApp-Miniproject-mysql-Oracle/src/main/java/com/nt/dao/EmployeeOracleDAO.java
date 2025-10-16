package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeOracleDAO implements IEmployeeDAO {
	private static final String Get_EMP_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?)";
	private static final String INSERT_EMPLOYEE="INSERT INTO EMP (EMPNO,ENAME,JOB,SAL,DEPTNO)VALUES(EMPNO_SEQ1.NEXTVAL,?,?,?,?)";
	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list =null;
		try(
				Connection con=ds.getConnection(); //GET POOLED CONNECTION
				PreparedStatement ps=con.prepareStatement(Get_EMP_BY_DESGS); //CREATE PREPARESTATEMENT OBJ HAVING THE PRE COMPILED SQL QUERY
				
				){
			//SET VALUES TO QUERY PARAM
			ps.setString(1, desg1);ps.setString(2, desg2);ps.setString(3, desg3);
			
		
			try(//execute the query
					ResultSet rs=ps.executeQuery();){
				
				//process the resultSet obj
				list=new ArrayList();  // initialize the list
				while(rs.next()) {
					//copy each record into java bean class object
					Employee emp=new Employee();
					emp.setEmpno (rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSal(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
					//add each java bean class object to list collection
					list.add(emp);
				}//while loop
			} //try 2
					
			
		}//try 1
		catch(SQLException se) {
			System.out.println("some DB problem wait for some time");
			throw se;
		}
		catch(Exception e) {
			System.out.println("some unkown problem wait for some time");
			throw e;
		}
		return list;
	}

	@Override
	public int insertEmployee(Employee emp)throws Exception {
		int result=0;
		try(
				Connection con=ds.getConnection(); //GET POOLED CONNECTION
				PreparedStatement ps=con.prepareStatement(INSERT_EMPLOYEE); //CREATE PREPARESTATEMENT OBJ HAVING THE PRE COMPILED SQL QUERY
				
				){
			//set values to query param
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setDouble(3, emp.getSal());
			ps.setInt(4, emp.getDeptno());
			
			//execute the sql query
		    result = ps.executeUpdate();
			
		}	
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}//end of method

}//end of class
