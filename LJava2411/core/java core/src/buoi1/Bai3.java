package buoi1;

import java.util.Scanner;

public class Bai3 {

    public static void main(String[] args) {
        System.out.println("Nhap vao hai canh: ");
        System.out.println("Nhap chieu rong: ");
        int chieuRong = new Scanner(System.in).nextInt();
        System.out.println("Nhap chieu dai: ");
        int chieuDai = new Scanner(System.in).nextInt();
        System.out.println("Dien tich: " + (chieuRong * chieuDai));
    }
}
