<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:blue;text-align:center">Search Data Dynamically</h1>
<frm:form action="search" modelAttribute="emp">
<table align="center" bgcolor="grey">
<tr>
	<td>emp ename::</td>
	<td><frm:input path="ename"/></td>
</tr><tr>
	<td>emp job::</td>
	<td><frm:input path="job"/></td>
</tr>
<tr>
	<td>emp salary::</td>
	<td><frm:input path="sal"/></td>
</tr>
<tr>
	<td>emp dept no::</td>
	<td><frm:select path="deptno">
			<frm:option value="">--Select dept--</frm:option>
			<frm:option value="10">10</frm:option>
			<frm:option value="20">20</frm:option>
			<frm:option value="30">30</frm:option>
		</frm:select>	
	</td>
</tr>
<tr>
	<td><input type="submit" value="search with data"></td>
	<td><input type="reset" value="cancel"></td>
</tr>
</table>
</frm:form>


 <hr><hr>
 <br><br>
 <h1 style="color:blue;text-align:center">Report Data</h1>
<c:choose>
 <c:when test="${!empty empList}">
  <table align="center" border="1" bgcolor="yellow">
    <tr bgcolor="cyan">
     <th>empno</th>
     <th>ename</th>
     <th>job</th>
     <th>salary</th>
     <th>deptno</th>
     <th>Oprations</th>
    </tr>
   <c:forEach var="emp" items="${empList}">
    <tr>
      <td>${emp.empno}</td>
      <td>${emp.ename}</td>
      <td>${emp.job}</td>
      <td>${emp.sal}</td>
      <td>${emp.deptno}</td>
      <td><a href="edit?no=${emp.empno}"><img alt="ho" src="images/edits.png" width="30px" height="30px"></a>
      &nbsp;&nbsp;<a onclick="return confirm('Are you sure to delete??')" href="delete?no=${emp.empno}"><img alt="ho" src="images/delete.jpg" width="40px" height="30px"></a></td>
    </tr> 
   </c:forEach> 
 
  </table>
 
 </c:when>
   <c:otherwise>
     <h1 style="color:red;text-align:center">No data found</h1>
   
   </c:otherwise>
</c:choose>
<br><br>
<h1 style="color:red;text-align:center">${resultmsg}</h1>




<br><br>

<center><a href="register">AddEmployee<img src="images/add.png" width="50px" height="40px"></a>
<br><br>


<center><a href="./">home<img src="images/home.jpg" width="50px" height="40px"></a>
