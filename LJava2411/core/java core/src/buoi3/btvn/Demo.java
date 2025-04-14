package buoi3.btvn;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số điện : ");
        double soDien = sc.nextDouble();
        final double mucDo1First = 0;
        final double mucDo1Last = 50;
        final double bac1 = 1.678;
        final double mucDo2First = 51;
        final double mucDo2Last = 100;
        final double bac2 = 1.734;
        final double mucDo3First = 101;
        final double mucDo3Last = 200;
        final double bac3 = 2.014;
        final double mucDo4First = 201;
        final double mucDo4Last = 300;
        final double bac4 = 2.536;
        final double mucDo5First = 301;
        final double mucDo5Last = 400;
        final double bac5 = 2.834;
        final double mucDo6First = 401;
        final double bac6 = 2.927;
//        double[] bac = new double[]{bac1, bac2, bac3, bac4, bac5, bac6};
        final int soBac = 6;
        final double soTienTu_0_50 = 1000;
        final double soTienTuLonHon50 = 1200;
        double tienDien = 0;
        if (soDien >= mucDo1First && soDien <= mucDo1Last) {
            tienDien = bac1 * soDien * soTienTu_0_50;
        } else if (soDien >= mucDo2First && soDien <= mucDo2Last) {
            tienDien = bac1 * mucDo1Last * soTienTu_0_50 + (soDien - mucDo1Last) * bac2 * soTienTuLonHon50;
        } else if (soDien >= mucDo3First) {
//            for (int i = 0; i < soBac; i++) {
//                if (i == 0) {
//                    tienDien += bac[i] * mucDo1Last * soTienTu_0_50;
//                    soDien -= mucDo1Last;
//                } else if (soDien <= mucDo1Last) {
//                    tienDien += bac[i] * soDien * soTienTuLonHon50;
//                    break;
//                } else if (i > 0 && i < soBac) {
//                    tienDien += bac[i] * mucDo1Last * soTienTuLonHon50;
//                    soDien -= mucDo1Last;
//                }
//            }
        }
        System.out.println("Số tiền điện là : " + tienDien);
    }
}
