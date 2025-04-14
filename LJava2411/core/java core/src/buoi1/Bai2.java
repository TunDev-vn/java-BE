package buoi1;

import java.util.Scanner;

public class Bai2 {

    /**
    Debug:
        Kỹ năng theo giõi và quan sát chương trình
     chạy trên từng dòng code, và kiếm soát dữ liệu
     trên từng dò khi chương trình chạy qua
     */
    public static void main(String[] args) {

        System.out.printf("Nhap vao hai so va tinh: ");
        int a = new Scanner(System.in).nextInt();
//        System.out.println("Day la de bug, code da chay qua day");
        int b = new Scanner(System.in).nextInt();
        System.out.println("Tong: " + (a + b));
        System.out.println("tich: " + (a*b));
        System.out.println("Thuong: "+ (a/b));
        System.out.println("Chia lay du: " + (a % b));

    }
}
