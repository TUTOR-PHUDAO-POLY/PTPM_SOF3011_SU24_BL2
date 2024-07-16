package com.tutor.sof3011.B2_CRUDListFixCung.controller;

import com.tutor.sof3011.B2_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// format: Ctrl Alt L
// xoa import thua: Ctrl Alt O
// Man hinh sinh vien -> chua tat ca cac duong dan
@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/view-add", // GET
        "/sinh-vien/add", // POST
        "/sinh-vien/search", // GET
        "/sinh-vien/detail", // GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/update",// POST
        "/sinh-vien/remove",// GET
})
public class SinhVienServlet extends HttpServlet {

    private SinhVienService service = new SinhVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // chua 6 uri
        // B1: Lay uri dang co tren duong dan
        String uri = request.getRequestURI(); // /sinh-vien/hien-thi
        // B2: kiem tra uri day la gi
        if (uri.contains("hien-thi")) {
            // get-all => hien thị tất cả
            this.hienThiDanhSach(request, response);
        } else if (uri.contains("view-add")) {
            // hiển thị giao diện view-add
            this.viewAdd(request, response);
        } else if (uri.contains("search")) {
            // search
            this.search(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detail(request, response);
        } else if (uri.contains("view-update")) {
            // view- update
            this.viewUpdate(request, response);
        } else {
            // remove
            this.remove(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 2 cai
        String uri = request.getRequestURI(); // /sinh-vien/hien-thi
        if (uri.contains("add")) {
            // add
            this.add(request, response);
        } else {
            // update
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDanhSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code o trong nay
        request.setAttribute("a1",service.getListSinhVien());
        request.getRequestDispatcher("/buoi2/sinhviens.jsp").forward(request,response);
    }
}

