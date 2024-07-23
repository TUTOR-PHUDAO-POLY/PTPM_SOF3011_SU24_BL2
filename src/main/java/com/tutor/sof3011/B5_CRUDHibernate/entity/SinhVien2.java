package com.tutor.sof3011.B5_CRUDHibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // danh dau class(object) => la 1 thuc the - Dung chinh thuc the nay de truy van HQL
@Table(name = "sinh_vien")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SinhVien2 {
    // J3: Truy van truc tiep SQL
    // J4:
    //C1: Truy van truc tiep SQL (native query)
    //C2: Truy van tren thuc the (entity) - truy van tren class
    // => HQL (Hibernate Query Language)
    // Dung thuc the <=> table
    // ORM(Object Relationship Mapping):
    // => Mapping 1 bang <=> 1 Object(class)
    // 1 table : khoa chinh, khoa ngoai, dieu kien rang buoc...
    // class(Object): khoa chinh, khoa ngoai (neu co) + cac dieu kien rang buoc neu co

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ten java trung vs ten trong sql => co the bo qua thuoc name cua column
    @Column
    private String ten;

    @Column
    private Integer tuoi;

    // Luu y: cam dat ten java theo o gach duoi => chet for..each => loi 500
    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

}
