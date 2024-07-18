<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/01/2023
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/sinh-vien/update?masv=${sv1.mssv}" method="post">
    MSSV: <input type="text" name="mssv" value="${sv1.mssv}" />
    <br/>
    Tên: <input type="text" name="ten" value="${sv1.ten}" />
    <br/>
    Tuổi: <input type="text" name="tuoi" value="${sv1.tuoi}" />
    <br/>
    Địa chỉ: <input type="text" name="diaChi" value="${sv1.diaChi}" />
    <br/>
    Giới tính:
    <input type="radio" name="gioiTinh" ${sv1.gioiTinh == true ? "checked" : ""} value="true"/>Nam
    <input type="radio" name="gioiTinh" ${sv1.gioiTinh == false ? "checked" : ""} value="false"/>Nữ
    <br/>
    <button>Update</button>
</form>

</body>
</html>
