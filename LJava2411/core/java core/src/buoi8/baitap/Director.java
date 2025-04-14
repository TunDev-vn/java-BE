package buoi8.baitap;

import java.util.Scanner;

public class Director extends Employee{

    private Double coPhan;

    public Director() {
        super();
        super.setLuongMotNgay(300d);
    }

    @Override
    public void nhapThongTin() {
        System.out.println("Nhập thông tin giám đốc: ");
        System.out.println("Nhập thông tin cổ phần( theo %, không được quá 100%): ");
        boolean khongHopLe = true;
        do {
            this.coPhan = new Scanner(System.in).nextDouble();
            if (this.coPhan > 0 && this.coPhan <= 100){
                khongHopLe = false;
            }else {
                System.out.println("Bạn nhập thông tin cổ phần không đúng, đề nghị nhập lại");
            }
        }while (khongHopLe);
        super.nhapThongTin();
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Thông tin giám đốc: ");
        super.hienThiThongTin();
        System.out.println("Cổ phần: " + this.coPhan);
    }

    @Override
    public double cachTinhLuongThang() {
        System.out.println("giám đốc: ");
        return super.getLuongMotNgay() * super.getSoNgayLamViec();
    }

    public Double getCoPhan() {
        return coPhan;
    }

    public void setCoPhan(Double coPhan) {
        this.coPhan = coPhan;
    }
}
