package buoi3.btvn;

import java.util.Scanner;

/**

 */
public class Bai3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*
        System.out.println("Nhap vao so Lan: ");
        int n = sc.nextInt();
        // Biết trước số lần lặp lại
        for (int i=0;i<n;i++){
            System.out.println("Nhap so dien la thu: " + (i + 1));
            double soDien = sc.nextDouble();
            double soTien = tinhTienDien(soDien);
            System.out.println("So tien dien la lan thu " + (i + 1) + ": " + soTien);
        }

        // Không biết trước số lần lặp lại
        // do - while
        int i = 0;
        int thoat=0;
        do {
            // thực hiện khối lệnh 1 lần đầu tiên
            System.out.println("Nhap so dien la thu: " + (i + 1));
            double soDien = sc.nextDouble();
            double soTien = tinhTienDien(soDien);
            System.out.println("So tien dien la lan thu " + (i + 1) + ": " + soTien);
            i++;
            System.out.println("Nhap vao 1 de tiep tục, 0 de thoat");
            thoat = sc.nextInt();
        }while (thoat == 1); // kiểm tra điều kiện dừng, nếu dk = true => tiếp tục lặp, ngược lại  = false  => thoát vòng lặp
        */
        // while : kiểm tra điều kiện lặp trước, nếu thỏa mãn => thực hiện khối lệnh, nếu không thỏa mãn => không thực hiện khối lệnh
        int j = 0;
        int thoatWhile = 1;
        while (thoatWhile == 1){
            System.out.println("Tiep tuc nhap so lan thu: " + ++j);
            System.out.println("Nhap vao 1 de tiep tục, 0 de thoat");
            thoatWhile = sc.nextInt();
        }


    }

    public static double tinhTienDien(double soDien){
        double soTien = 0;
        final double mucDo1First = 0;
        final double mucDo1Last = 50;
        final double bac1 = 1.678;
        final double mucDo2Last = 100;
        final double bac2 = 1.734;
        final double mucDo3Last = 200;
        final double bac3 = 2.014;
        final double mucDo4Last = 300;
        final double bac4 = 2.536;
        final double mucDo5Last = 400;
        final double bac5 = 2.834;
        final double bac6 = 2.927;
        if (soDien > mucDo1First && soDien <= mucDo1Last){
            soTien = bac1 * soDien;
        }else if (soDien <= mucDo2Last){
            soTien = mucDo1Last * bac1 + (soDien - mucDo1Last) * bac2;
        }else if (soDien <= 200){
            soTien = mucDo1Last * bac1 + mucDo1Last * bac2 + (soDien - mucDo2Last) * bac3;
        }else if (soDien <= 300){
            soTien = mucDo1Last * bac1 + mucDo1Last * bac2 + mucDo2Last * bac3 + (soDien - mucDo3Last) * bac4;
        }else if (soDien <= 400){
            soTien = mucDo1Last * bac1 + mucDo1Last * bac2 + mucDo2Last * bac3 + mucDo2Last * bac4 + (soDien - mucDo4Last) * bac5;
        }else {
            soTien = mucDo1Last * bac1 + mucDo1Last * bac2 + mucDo2Last * bac3 + mucDo2Last * bac4 + mucDo2Last * bac5 + (soDien - mucDo5Last) * bac6;
        }
        return soTien;
    }
}
