<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="">Add Student</a></button>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <%--    Vong lap - for
    for(Doi tuong : mang danh sach){

    }
    items : ten mang
    var : doi tuong
    Nhung bien goi tu phia servlet : PHAI CO ${}
    --%>
    <c:forEach items="${a1}" var="sv" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${sv.mssv}</td>
            <td>${sv.ten}</td>
            <td>${sv.diaChi}</td>
            <td>${sv.tuoi}</td>
            <td>${sv.gioiTinh}</td>
            <td></td>
        </tr>
    </c:forEach>
    <tbody>
    </tbody>
</table>
</body>
</html>
