package buoi4;

import java.util.Scanner;

/**

 Mảng:
    + lưu các phần tử có cùng kiểu
    + nằm trên các vùng nhớ liền kề nhau
    + số lượng phần tử là cố định khi khai báo
    + thao tác với mảng thông chỉ số index

 Cách xử lý với mảng:
    + Sử dụng các vòng lặp để xử lý lần lượt các phần tử của mảng dựa vào chiều dài của mảng


 */
public class Main {
    public static void main(String[] args) {
        // khai bao mang
        int[] mangCacSoNguyen = new int[10];
        String mangCacKyTu[] = new String[10];
        double[] mangCacSoTuNhien = {1.2,1.3,1.4};

        // truy cap cac phan tu trong mang

        System.out.println("Do dai cua mang: " + mangCacKyTu.length);
        // them phan tu vao mang qua index
        mangCacKyTu[0] = "A";
        mangCacKyTu[1] = "B";
        mangCacKyTu[2] = "C";
        mangCacKyTu[3] = "D";
        // lay cac phan tu ra
        // lay phan tu co index = 1 và 3
        System.out.println(mangCacKyTu[1]);
        System.out.println(mangCacKyTu[3]);
//        System.out.println(mangCacKyTu[20]);
        // duyệt tất cả các phần tử của mảng
        for (int index = 0; index < mangCacKyTu.length; index++) {
            String duLieuMang = mangCacKyTu[index];
            System.out.print(" " + duLieuMang);
        }
        // Nhập cac số vào trong mảng
        Scanner scanner = new Scanner(System.in);
        String duLieuMang = "";
        for (int i = 0; i < mangCacKyTu.length; i++) {
            // thu thập dữ liệu người dùng nhập
            System.out.println("Nhap vao phan tu co index : " + i);
            duLieuMang = scanner.nextLine();
            // gán dữ liệu vào mảng
            mangCacKyTu[i] = duLieuMang;
        }
        hienThi(mangCacKyTu);
    }

    public static void hienThi(String[] mangCacKyTu){
        for (int index = 0; index < mangCacKyTu.length; index++) {
            String duLieuMang = mangCacKyTu[index];
            System.out.print(" " + duLieuMang);
        }
    }
}
