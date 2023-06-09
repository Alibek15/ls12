<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>JSP - Hello World</title>
    <%@include file="templates/bootstrap.jsp"%>
</head>

<body>
<div class="container-fluid">
    <%@include file="templates/navbar.jsp"%>
</div>
<%
       String userEmail = (String) session.getAttribute("userEmail");
       if(userEmail != null){


%>
<h1><%=userEmail%></h1>
<%}%>
</body>
</html>