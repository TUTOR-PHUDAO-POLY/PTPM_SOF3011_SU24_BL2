package com.tutor.sof3011.B2_CRUDListFixCung.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @: Annotation
@AllArgsConstructor // contructor all tham so
@NoArgsConstructor // contructor k tham so
@Getter
@Setter
@Builder // contructor tuy y tham so
@ToString
public class SinhVien {

    private String mssv;

    private String ten;

    private String diaChi;

    private Integer tuoi;

    private Boolean gioiTinh;

}
