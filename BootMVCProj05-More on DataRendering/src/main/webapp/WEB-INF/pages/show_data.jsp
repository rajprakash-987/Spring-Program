<%@ page isELIgnored="false" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:red;text-align:center">Model attribute</h1>

<!-- <br><br> -->

<%-- <b>Model Attribute(simple value):: ${name},${age}</b> --%>

<%-- <br><br>
	 <b>Model Attribute(arrays and Collection)</b><br><br> 
	<%
 	String favColor[]=(String[])request.getAttribute("favColor");
 	List<String> friends=(List<String>)request.getAttribute("friends");
 	Set<Long> Phones=(Set<Long>)request.getAttribute("PhoneNumber");
 	Map<String,Object> idsMap=(Map<String,Object>)request.getAttribute("iddetails");
	%>
	<b>FavColor::<%=Arrays.toString(favColor)%></b>
	<b>Friends::<%=friends%></b>
	<b>phones::<%=Phones%></b>
	<b>idsMap::<%=idsMap%></b> --%>


<%-- 
  <c:if test="${favColor ne null}">
    <c:forEach var="color" items="${favColor}">
    	${color},
    </c:forEach>
  </c:if>
  
  <br>
  <c:if test="${friends ne null}">
    <c:forEach var="fr" items="${friends}">
    	${fr},
    </c:forEach>
  </c:if>
  
  <br>
  <c:if test="${PhoneNumber ne null}">
    <c:forEach var="ph" items="${PhoneNumber}">
    	${ph},
    </c:forEach>
  </c:if>
  
  <br>
  <c:if test="${iddetails ne null}">
    <c:forEach var="id" items="${iddetails}">
    	${id.key}=${id.value}
    </c:forEach>
  </c:if>           --%>
  
  
  <%-- 
  <b> Model attribute(Model class Attribute)</b><br><br>
  <c:if test="${!empty stdDetails}">
  	Student Details:: ${stdDetails}<br>
  	Student Details:: ${stdDetails.sno},${stdDetails.sname},${stdDetails.sadd},${stdDetails.avg},
  	
  </c:if>            --%>
  
  
  <b> Model attribute(Collection of Model class Attribute)</b><br><br>
  <c:choose>
  	<c:when test="${!empty stdList}">
  	<table border="1" bgcolor="cyan" align="center">
  	<tr><th>SNO</th><th>SNAME</th><th>SADD</th><th>AVG</th> </tr>
  	<c:forEach var="st" items="${stdList}">
  	<tr>
  	 <td>${st.sno}</td>
  	 <td>${st.sname}</td>
  	 <td>${st.sadd}</td>
  	 <td>${st.avg}</td>
  	 </tr>
  	</c:forEach>
  	</table>
  	</c:when>
  	<c:otherwise>
  		<h1 style="color:red; text-align:center">No Record Found</h1>
  	</c:otherwise>
  </c:choose>
  



