<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.01.2023
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
  <%@include file="templates/bootstrap.jsp"%>
</head>
<body>
<%@include file="templates/navbar.jsp"%>
<div class="container mt-5">
  <div class="row">
    <div class="col-sm-6">
     <%

         if(request.getParameter("error")!=null &&
                 request.getParameter("error").equals("1")){


     %>
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>ERROR!</strong> User with this email doesn't exist.
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <%} else if(request.getParameter("error")!=null &&
              request.getParameter("error").equals("2")){



      %>
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <strong>ERROR!</strong> Invalid email or password.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <%
            }%>
      <form method="post" action="/login">
        <div class="form-group">
          <label class="control-label">
            Email
          </label>
          <input class="form-control" type="email" name="email" placeholder="Email" value="<%= request.getParameter("email")!=null ? request.getParameter("email"): " "%>">

        </div>
        <div class="form-group">
          <label class="control-label">
            Password
          </label>
          <input class="form-control" type="password" name="password" placeholder="Password">

        </div>
          <div class="form-group mt-2">
              <button type="submit" class="btn btn-success">Log In</button>

          </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
