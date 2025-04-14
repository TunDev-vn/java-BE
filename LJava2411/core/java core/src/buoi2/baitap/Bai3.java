package buoi2.baitap;

import java.util.Scanner;

public class Bai3 {

    public static void main(String[] args) {

        System.out.println("Giai phuong trinh bac 2: ax2 + bx + c= 0");
        System.out.println("Nhap vao a: ");
        double a = new Scanner(System.in).nextDouble();
        System.out.println("Nhap vao b: ");
        double b = new Scanner(System.in).nextDouble();
        System.out.println("Nhap vao c: ");
        double c = new Scanner(System.in).nextDouble();
        if (a == 0){
            if (b == 0){
                if (c == 0){
                    System.out.println("Phuong trinh vo so nghiem");
                }else {
                    System.out.println("Phuong trinh vo nghiem");
                }
            }else {
                System.out.println("Nghiem cua phuong trinh la: " + (-c / b));
            }
        }else {
            double delta = (b * b) - (4 * a * c);
            if (delta < 0){
                System.out.println("Phuong trinh vo nghiem");
            }else if (delta == 0){
                System.out.println("Nghiem phuong trinh la: " + (- b / (2 * a)));
            }else {
                System.out.println("Phuong trinh co 2 nghiem phan biet: ");
                double x1 = (-b + Math.sqrt(delta)) / 2*a;
                double x2 = (-b - Math.sqrt(delta)) / 2*a;
                System.out.println("x1: " + x1);
                System.out.println("x2: " + x2);
            }
        }

    }
}
