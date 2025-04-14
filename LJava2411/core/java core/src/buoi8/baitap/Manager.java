package buoi8.baitap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class Manager extends Employee{

    // Khởi tạo mặc định cho list
    private List<Staff> danhSachNhanVien = new ArrayList<>();

    public Manager(){
        super();
        super.setLuongMotNgay(200d);
    }

    @Override
    public double cachTinhLuongThang() {
        System.out.println("Quản lý: ");
        return super.getLuongMotNgay() * super.getSoNgayLamViec() + (100 * danhSachNhanVien.size());
    }

    @Override
    public void nhapThongTin() {
        System.out.println("Nhập thông tin quản lý: ");
        super.nhapThongTin();
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Hiển thị thông tin quản lý: ");
        super.hienThiThongTin();
        if(this.danhSachNhanVien != null && !this.danhSachNhanVien.isEmpty()){
            System.out.println("Danh sách mã nhân viên của quản lý: ");
            for (Staff staff:danhSachNhanVien) {
                System.out.printf(staff.getMaMV() + " ");
            }
            System.out.println();
        }
    }

    public List<Staff> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(List<Staff> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }
}
