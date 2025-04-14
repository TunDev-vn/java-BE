package buoi8.baitap;

import java.util.Scanner;

public abstract class Employee {

    /*
    Double,Integer,Long,Boolean
        + chứa được giá trị null vì nó là kiểu
            dữ liệu đối tượng
        + khởi tạo đối tượng trong heap như 1 đối
            tượng bình thường
    double,long,boolean,int...
        + không chứa được giá trị null
        + chỉ lưu giá trị trong stack
     */
    private String maMV;
    private String hoTen;
    private String sdt;
    private Integer soNgayLamViec;
    private Double luongMotNgay;

    public void nhapThongTin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin MaNV: ");
        this.maMV = scanner.nextLine();
        System.out.println("Nhap thong tin HoTen: ");
        this.hoTen = scanner.nextLine();
        System.out.println("Nhap thong tin SDT: ");
        this.sdt = scanner.nextLine();
        this.nhapSoNgayLamViec();
    }

    public void hienThiThongTin(){
        System.out.println("MaNV : " + maMV);
        System.out.println("HoTen : " + hoTen);
        System.out.println("SDT : " + sdt);
        System.out.println("SoNgayLamViec : " + soNgayLamViec);
        System.out.println("LuongMotNgay : " + luongMotNgay);
    }


    public abstract double cachTinhLuongThang();

    public void nhapSoNgayLamViec() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        do {
            try {
                System.out.print("Nhập thông tin Số Ngày Làm Việc: ");
                this.soNgayLamViec = scanner.nextInt();
                validInput = true; // Đúng kiểu và giá trị hợp lệ, thoát khỏi vòng lặp
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu! Vui lòng nhập một số nguyên hợp lệ.");
                scanner.nextLine(); // Đọc và bỏ qua dòng lỗi để tránh vòng lặp vô hạn
            }
        } while (!validInput);
    }
    public String getMaMV() {
        return maMV;
    }

    public void setMaMV(String maMV) {
        this.maMV = maMV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(Integer soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public Double getLuongMotNgay() {
        return luongMotNgay;
    }

    public void setLuongMotNgay(Double luongMotNgay) {
        this.luongMotNgay = luongMotNgay;
    }
}
