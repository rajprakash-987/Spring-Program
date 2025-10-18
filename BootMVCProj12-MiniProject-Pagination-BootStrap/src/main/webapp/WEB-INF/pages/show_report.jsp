<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">  

 <div class="container">
 <h1 style="color:red;text-align:center">Page No:: ${pageData.getPageable().getPageNumber()+1} /${pageData.totalPages - 1} record are</h1>
<c:choose>
 <c:when test="${!empty pageData}">
  <table align="center" border="1" bgcolor="yellow" class="table table-dark table-hover">
    <tr bgcolor="cyan">
     <th>empno</th>
     <th>ename</th>
     <th>job</th>
     <th>salary</th>
     <th>deptno</th>
     <th>Oprations</th>
    </tr>
   <c:forEach var="emp" items="${pageData.getContent()}">
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
  <br><br>
  <center>
  <c:if test="${!pageData.isFirst()}">
  <a href="report?page=0">first</a>&nbsp;&nbsp;
  </c:if>
  
    <c:if test="${!pageData.isLast()}">
  <a href="report?page=${pageData.getPageable().getPageNumber()+1}">Next</a>
  </c:if>
  
  <c:forEach var="i" begin="0" step="1" end="${pageData.totalPages - 1}">

  		<a href="report?page=${i}">${i+1}</a> &nbsp;&nbsp;
  </c:forEach>
   <c:if test="${!pageData.isFirst()}">
  <a href="report?page=${pageData.getPageable().getPageNumber()-1}">Previous</a>
  </c:if>
  
   <c:if test="${!pageData.isLast()}">
  &nbsp;&nbsp;<a href="report?page=${pageData.totalPages - 1}">Last</a>
  </c:if>

  </center>
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
</div>