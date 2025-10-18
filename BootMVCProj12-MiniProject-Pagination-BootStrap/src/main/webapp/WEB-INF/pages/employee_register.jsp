<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %> 

<h1 style="color:red;text-align:center">Form Registration page</h1> 
<frm:form modelAttribute="emp">
  <table align="center" bgcolor="cyan">
  <tr>
  	<td>Name</td>
  	<td><frm:input path="ename"/></td>
  </tr>
  <tr>
  	<td>Job</td>
  	<td><frm:input path="job"/></td>
  </tr>
  <tr>
  	<td>salary</td>
  	<td><frm:input path="sal"/></td>
  </tr>
  <tr>
  	<td>Dept no</td>
  	<td><frm:select path="deptno">
  			<frm:option value="10">10</frm:option>
  			<frm:option value="20">20</frm:option>
  			<frm:option value="30">30</frm:option>
  		</frm:select>
  	</td>		
  </tr>
  <tr>
   <td><input type="submit" value="register"></td>
   <td><input type="reset" value="cancel"></td>
  </tr>
  </table>
</frm:form>   
