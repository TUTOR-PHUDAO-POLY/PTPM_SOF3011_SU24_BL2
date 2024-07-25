<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<a href="/sinh-vien/view-add">Add</a>
<h1>LIST DANH SACH</h1>
<table border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Ten</th>
        <th>Tuoi</th>
        <th>Dia chi</th>
        <th>Gioi tinh</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lists}" var="sv" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${sv.id}</td>
            <td>${sv.ten}</td>
            <td>${sv.tuoi}</td>
            <td>${sv.diaChi}</td>
            <td>${sv.gioiTinh}</td>
            <td>
                <a href="/sinh-vien1/remove?id1=${sv.id}">Remove</a>
                <a href="/sinh-vien1/view-update?id=${sv.id}">Update</a>
                <a href="/sinh-vien1/detail?id=${sv.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>