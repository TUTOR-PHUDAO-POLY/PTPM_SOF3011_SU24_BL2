package com.tutor.sof3011.B1_OverviewJavaWeb.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

// value => dai dien cho duong dan.
// Duong dan: Bat dau /hien-thi-danh-sach
// Duong Dan la duy nhat
// value co the chua nhieu duong
@WebServlet(name = "LoginServlet", value = {
        // Liet ke cac duong dan neu can
        "/login",
        "/ket-qua"
})
public class LoginServlet extends HttpServlet {
    // Co 4 method (HTTP Methods): GET, POST, PUT, DELETE
    // J4 & J5: Chi lam viec vs 2 method la GET & POST
    // GET: Hien thi/ Lay ra
    // POST : XU LY FORM
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyen ra trang login
        // Co 2 cach chuyen trang :
        // C1:getRequestDispatcher
        // Truyen gia tri tu servlet -> jsp
        // Truyen 2 tham so:
        // Tham so 1: Ten bien ma jsp se su dung
        // Tham so 2: Gia tri ma JSP layv
        request.setAttribute("a1","P312");
        request.getRequestDispatcher("/buoi1/form-dang-nhap.jsp").forward(request,response);
        // C2: sendRedirect
//        response.sendRedirect("/buoi1/demo/a.jsp");
        // C2 => chi thuan => chuyen trang => Khong mang gia tri muon truyen  di
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri tu jsp ve servlet
        // Lay thong qua thuoc tinh name cua o input
        String u = request.getParameter("u1");
        String p = request.getParameter("cdm");
        // B2: Day du lieu servlet -> jsp
        request.setAttribute("a1",u);
        request.setAttribute("a2",p);
        // B3: Chuyen trang
        request.getRequestDispatcher("/buoi1/ket-qua.jsp").forward(request,response);

    }
}
