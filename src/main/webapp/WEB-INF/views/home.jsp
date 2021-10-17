<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User's system details</title>
</head>
<body>
<h1> This application display's information about your Browser, Operating System, IP Address and TimeZone</h1>
<b>Operating System:</b> ${clientOs } <br>
<b> IP Address:</b> ${clientIp } <br>
<b> Browser: </b> ${clientBrowser } <br>
<b> TimeZone: </b> ${getTimeZone } <br>

<%-- <c:forEach var="temp" items="${getTimeZone }">

<li>${temp }</li>

 </c:forEach>--%>
</body>
</html>