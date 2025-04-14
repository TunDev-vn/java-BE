package buoi2.baitap;

import java.util.Scanner;

public class Bai2 {

    public static void main(String[] args) {
        System.out.println("Giai phuong trinh bac 1: ax + b = 0");
        System.out.println("Nhap vao a: ");
        double a = new Scanner(System.in).nextDouble();
        System.out.println("Nhap vao b: ");
        double b = new Scanner(System.in).nextDouble();
        final int zero = 0;
        if (a == zero){
            if (b == zero){
                System.out.println("Phuong trinh vo so nghiem");
            }else {
                System.out.println("Phuong trinh vo nghiem");
            }
        }else {
            System.out.println("Nghiem cua phuong trinh la: " + (-b / a));
        }

    }
}
