package com.tutor.sof3011.B2_CRUDListFixCung.controller;

import com.tutor.sof3011.B2_CRUDListFixCung.entity.SinhVien;
import com.tutor.sof3011.B2_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

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

    @SneakyThrows
    private void update(HttpServletRequest request, HttpServletResponse response) {
        String mssv = request.getParameter("masv");
        SinhVien sv = new SinhVien();
        int index = 0;
        for (SinhVien sv1 : service.getListSinhVien()) {
            if (sv1.getMssv().equalsIgnoreCase(mssv)) {
                sv = sv1;
                break; // Dung vong la khi tim thay
            }
            index++;
        }
        BeanUtils.populate(sv, request.getParameterMap());
        service.update(index, sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    @SneakyThrows
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // C1: Lay bt
        // B1: Lay nhung thu vua nhap tu jsp -> servlet
        // getParamters
//        String mssv = request.getParameter("mssv1");
//        String ten = request.getParameter("ten");
//        String tuoi = request.getParameter("tuoi");
//        String diaChi = request.getParameter("diaChi");
//        String gioiTinh = request.getParameter("gioiTinh");
//        // B2: Khoi tao 1 doi tuong
//        SinhVien sv = SinhVien.builder()
//                .mssv(mssv)
//                .ten(ten)
//                .tuoi(Integer.valueOf(tuoi))
//                .gioiTinh(Boolean.valueOf(gioiTinh))
//                .diaChi(diaChi)
//                .build();
//        // B3: Goi ham add trong service
//        service.add(sv);
//        // B4: Quay ve trang hien thi
//        response.sendRedirect("/sinh-vien/hien-thi");
        // C2: BeanUtils
        SinhVien sv = new SinhVien();
        BeanUtils.populate(sv, request.getParameterMap());
        service.add(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String vitriString = request.getParameter("vitri");
        int index = Integer.parseInt(vitriString);
        service.remove(index);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vitriString = request.getParameter("vitri");
        int index = Integer.parseInt(vitriString);
        SinhVien sv = service.detail(index);
        request.setAttribute("sv1", sv);
        request.getRequestDispatcher("/buoi2/update-sinh-vien.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vitriString = request.getParameter("vitri");
        int index = Integer.parseInt(vitriString);
        SinhVien sv = service.detail(index);
        request.setAttribute("sv", sv);
        request.getRequestDispatcher("/buoi2/detail-sinh-vien.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/buoi2/add-sinh-vien.jsp");
    }

    private void hienThiDanhSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code o trong nay
        request.setAttribute("a1", service.getListSinhVien());
        request.getRequestDispatcher("/buoi2/sinhviens.jsp").forward(request, response);
    }
}

