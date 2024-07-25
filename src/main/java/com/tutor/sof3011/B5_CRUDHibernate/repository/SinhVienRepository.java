package com.tutor.sof3011.B5_CRUDHibernate.repository;

import com.tutor.sof3011.B5_CRUDHibernate.entity.SinhVien2;
import com.tutor.sof3011.B5_CRUDHibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {
    // CRUD
    // j3 => moi ham khi ket noi vs CSDL => Deu mo connect
    // J4=> Session <=> Connection (J3)
    // Chi mo 1 lan duy nhat
    private Session s;

    public SinhVienRepository() {
        // Mo session(connection) 1 lan duy nhat trong contructor
        s = HibernateUtil.getFACTORY().openSession();
    }

    // GET ALL
//    SELECT * FROm sinh_vien
    public List<SinhVien2>getAll(){
        // FROM table => HQL (truy van tren thuc the )
        return s.createQuery("FROM SinhVien2").list();
    }

    // Tim theo khoa chinh (Find By ID)
    // SELECT * From table where id = ?
    public SinhVien2 getOne(Long id){
        return s.find(SinhVien2.class,id);
    }

    // add -> insert
    public void add(SinhVien2 sv){
        try{
            s.getTransaction().begin();
            // add doi tuong sv/gv/dv... (entity) -> thuc the
            s.persist(sv);
            // commit => day du lieu add di
            s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            // rollback => ve trang thai ban dau
            s.getTransaction().rollback();;
        }
    }

    // update -> update
    public void update(SinhVien2 sv){
        try{
            s.getTransaction().begin();
            // update doi tuong sv/gv/dv... (entity) -> thuc the
            s.merge(sv);
            // commit => day du lieu add di
            s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            // rollback => ve trang thai ban dau
            s.getTransaction().rollback();;
        }
    }

    // delete -> delete
    public void delete(SinhVien2 sv){
        try{
            s.getTransaction().begin();
            // delete doi tuong sv/gv/dv... (entity) -> thuc the
            s.delete(sv);
            // commit => day du lieu add di
            s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            // rollback => ve trang thai ban dau
            s.getTransaction().rollback();;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SinhVienRepository().getAll());
    }
}
