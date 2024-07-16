package com.tutor.sof3011.B2_CRUDListFixCung.service;

import com.tutor.sof3011.B2_CRUDListFixCung.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    // Liet ke cac ham can thiet
    // GetAll
    // Them , Sua Xoa, Search...

    // C1: List -> static
    // C2: List -> vao contructor cua doi tuong service

    private List<SinhVien>listSinhVien = new ArrayList<>();

    public SinhVienService() {
        // fake data o trong contructor
        // thu tu contructor all tham so -> phu thuoc vao thuc tu khi minh khai bao bien
        // su dung lombox
        listSinhVien.add(new SinhVien("HE130461","Nguyen van a","Ha noi",10,true));
        listSinhVien.add(new SinhVien("HE130462","Nguyen van b","Ha noi1",11,false));
        listSinhVien.add(new SinhVien("HE130463","Nguyen van c","Ha noi2",12,true));
        listSinhVien.add(new SinhVien("HE130464","Nguyen van d","Ha noi3",13,false));
        listSinhVien.add(new SinhVien("HE130465","Nguyen van e","Ha noi4",15,true));
    }

    public List<SinhVien> getListSinhVien() {
        return listSinhVien;
    }
}
