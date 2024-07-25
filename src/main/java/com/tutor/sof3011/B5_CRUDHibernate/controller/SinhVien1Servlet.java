package com.tutor.sof3011.B5_CRUDHibernate.controller;

import com.tutor.sof3011.B5_CRUDHibernate.entity.SinhVien2;
import com.tutor.sof3011.B5_CRUDHibernate.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "SinhVien1Servlet", value = {
        "/sinh-vien1/hien-thi", //get
        "/sinh-vien1/remove",   //get
        "/sinh-vien1/update",   //post
        "/sinh-vien1/add",      //post
        "/sinh-vien1/detail",   //get
        "/sinh-vien1/view-add", //get
        "/sinh-vien1/view-update",  //get
})
public class SinhVien1Servlet extends HttpServlet {

    private SinhVienRepository repo = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // load du lieu len table
            this.hienThiDuLieu(request, response);
        } else if (uri.contains("remove")) {
            // xoa
            this.delete(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detail(request, response);
        } else if (uri.contains("view-add")) {
            // hien thi form add
            this.viewAdd(request, response);
        } else {
            // hiem thi form update
            this.viewUpdate(request, response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi5/form-add.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        SinhVien2 sv = repo.getOne(id); // lay ra doi tuong can xoa
        request.setAttribute("sv1", sv);
        request.getRequestDispatcher("/buoi5/form-detail.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id1"));
        SinhVien2 sv = repo.getOne(id); // lay ra doi tuong can xoa
        repo.delete(sv); // xoa doi tuong dang lay
        response.sendRedirect("/sinh-vien1/hien-thi");
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lists", repo.getAll());
        request.getRequestDispatcher("/buoi5/hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            // add
            this.add(request, response);
        } else {
            ///update
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    @SneakyThrows
    private void add(HttpServletRequest request, HttpServletResponse response) {
        SinhVien2 sv = new SinhVien2();
        BeanUtils.populate(sv, request.getParameterMap());
        repo.add(sv);
        response.sendRedirect("/sinh-vien1/hien-thi");
    }
}
