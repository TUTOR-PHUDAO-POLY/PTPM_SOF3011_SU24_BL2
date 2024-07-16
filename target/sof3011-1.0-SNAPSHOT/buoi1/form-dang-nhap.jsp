<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 13/7/24
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ket-qua" method="POST">
    <div class="form-group">
        <label for="email">Email address:</label>
        <input type="text" class="form-control" id="email" name="u1">
    </div>
    <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" id="pwd" name="cdm">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
    ${a1}
</form>
</body>
</html>
