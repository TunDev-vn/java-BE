package buoi4.btvn;

import java.util.Scanner;

/**
 bài 2)

 Đổi sang số nhị phân của 1 số nguyên dương n
 Ví dụ nhập sao số dương 8 in ra màn hình số nhị phân của nó là 1000
 7 -> 111
 9 -> 1001
 16 -> 10000
 7 % 2 = 1 | 7 / 2 = 3
 3 % 2 = 1 | 3 / 2 = 1
 1 % 2 = 1 | 1 / 2 = 0
 */
public class Bai2 {
    public static void main(String[] args) {

        System.out.println("Nhap vao so he 10: ");
        int n = new Scanner(System.in).nextInt();
        String ketQua = "";
        int bienTam = 0;
        while (n != 0){
            bienTam = n % 2;
            ketQua = bienTam + ketQua;
            n = n / 2;
        }
        System.out.println("So nhi phan la: " + ketQua);
    }
}
