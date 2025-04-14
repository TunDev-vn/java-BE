package buoi4.bt;

import java.util.Scanner;

/**
 bai 1:
 cho nguoi dung nhap vao n so tu nhien
 + n do người dùng nhập
 + sau đó cho phép người dùng nhập vào n số tự nhiên
 yếu cầu:
 1) Hiển thị các số người dùng nhập vào
 2) Tính tổng các số trong mảng
 3) Tìm số lớn nhất và nhỏ nhất trong mảng
 4) Sắp xếp các phần tử theo thú tự từ nhỏ đến lớn
 */
public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so phan tu: ");
        int n = scanner.nextInt();
        int[] mang = new int[n];
        nhapMang(mang, scanner);
        tinhTongCacSo(mang);
        timSoLonNhatNhoNhat(mang);
        sapXep(mang);
    }

    public static void sapXep(int[] mang){
        for (int i = 0; i < mang.length; i++) {
            for (int j = i + 1; j < mang.length; j++) {
                if (mang[i] > mang[j]){
                    int tam = mang[i];
                    mang[i] = mang[j];
                    mang[j] = tam;
                }
            }
        }
        hienThi(mang);
    }
    public static void hienThi(int[] mang){
        System.out.println("danh sach: ");
        for (int i = 0; i < mang.length; i++) {
            System.out.printf(" " + mang[i]);
        }
    }
    public static void timSoLonNhatNhoNhat(int[] mang){
        int soLonNhat = 0;
        int soNhoNhat = Integer.MAX_VALUE;
        for (int i = 0; i < mang.length; i++) {
            if (mang[i] > soNhoNhat){
                soLonNhat = mang[i];
            }
            if (mang[i] < soNhoNhat){
                soNhoNhat = mang[i];
            }
        }
        System.out.println("So lon nhat: " + soLonNhat);
        System.out.println("So nho nhat: " + soNhoNhat);

    }
    public static void tinhTongCacSo(int[] mang){
        int tong = 0;
        for (int i = 0; i < mang.length; i++) {
            tong += mang[i];
        }
        System.out.println("Tong cac so trong mang: " + tong);
    }

    private static void nhapMang(int[] mang, Scanner scanner) {
        int duLieu = 0;
        for (int i = 0; i < mang.length; i++) {
            System.out.println("Nhap vao so thu: " + (i + 1));
            duLieu = scanner.nextInt();
            mang[i] = duLieu;
        }
        hienThi(mang);
    }
}
