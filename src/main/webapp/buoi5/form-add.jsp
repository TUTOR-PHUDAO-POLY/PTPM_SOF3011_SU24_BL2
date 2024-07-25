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
    <form action="/sinh-vien1/add" method="post">
<%--        <p>MSSV: <input type="text" name="mssv"></p>--%>
        <p>Ten: <input type="text" name="ten"></p>
        <p>Tuoi: <input name="tuoi"></p>
        <p>Dia chi: <input name="diaChi"></p>
        <p>Gioi tinh:
            <input type="radio" value="true" name="gioiTinh">Nam
            <input type="radio" value="false" name="gioiTinh">Nu
        </p>
        <button type="submit">Add</button>
    </form>
</body>
</html>