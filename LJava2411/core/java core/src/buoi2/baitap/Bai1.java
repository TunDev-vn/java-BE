package buoi2.baitap;

import java.util.Scanner;

/**
     Bài 1: Nhập vào số giờ làm việc của nhân viên
         Viết chương tình tính lương của nhân viên dựa trên số giờ làm việc,
          lương theo giờ là 50.000 VND. Nêu số giờ làm việc > 40 giờ tính
         thêm 1.5 lần cho những giờ làm việc thêm
    Bài 2:
        nhập vào a,b và giải phương trình bậc 1 có dạng
        ax + b = 0
    Bài 3:
        nhập vào a,b,c giải phương trình bậc 2 có dạng
        ax2 + bx + c= 0;
    if a = 0
        if b = 0
            if c = 0
    if a != 0
 */
public class Bai1 {
    public static void main(String[] args) {
        final double luongTheoGio = 50000;
        final double soGioTieuChuan = 40;
        final double heSo = 1.5;
        System.out.println("Nhap vao so gio lam viec: ");
        double soGioLamViec = new Scanner(System.in).nextDouble();

        double luong = 0;
        if (soGioLamViec > soGioTieuChuan){
            luong = (soGioLamViec - soGioTieuChuan) * (luongTheoGio * heSo) + soGioTieuChuan * luongTheoGio;
        }else {
            luong = soGioLamViec * luongTheoGio;
        }
        System.out.println("Luong: " + luong);


    }
}
