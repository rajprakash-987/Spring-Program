
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red;text-align:center">Dancer Registretion Page</h1>

<frm:form   modelAttribute="dncr">
<table align="center" bgcolor="cyan">
 <tr>
 <td>Dancer ID</td>
 <td> <frm:input type="text" path="did"/></td>
 </tr>
 <tr>
 <td>Dancer Name</td>
 <td> <frm:input type="text" path="name"/></td>
 </tr>
 <tr>
 <td>Dancer adress</td>
 <td> <frm:input type="text" path="addrs"/></td>
 </tr>
 <tr>
 <td>Dancer Dance form</td>
 <td> <frm:input type="text" path="danceForm"/></td>
 </tr>
 <tr>
 <td>Dancer Fee</td>
 <td> <input type="text" name="fee"></td>
 </tr>
 <tr>
 <td> <input type="submit" name="send"></td>
 <td> <input type="Reset" name="cancel"></td>
 </tr>



</table>

</frm:form>