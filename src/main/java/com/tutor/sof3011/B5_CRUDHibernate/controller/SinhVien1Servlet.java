package com.tutor.sof3011.B5_CRUDHibernate.controller;

import com.tutor.sof3011.B5_CRUDHibernate.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SinhVien1Servlet", value = {
        "/sinh-vien1/hien-thi"

})
public class SinhVien1Servlet extends HttpServlet {

    private SinhVienRepository repo = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            // load du lieu len table
            this.hienThiDuLieu(request, response);
        }
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lists",repo.getAll());
        request.getRequestDispatcher("/buoi5/hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
