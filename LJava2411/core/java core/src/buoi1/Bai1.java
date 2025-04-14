package buoi1;

import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        // Tạo ra 1 đối tượng scanner bằng từ khóa new
        Scanner scanner = new Scanner(System.in);
        // dùng đối tượng scanner cho tất cả các lần nhập vào
        System.out.println("Nhập vào thông tin cá nhân: ");
        String hoTen = scanner.nextLine();
        System.out.println("Ngay sinh: ");
        int ngaySinh = scanner.nextInt();
        System.out.println("Nhap thang sinh: ");
        int thang = scanner.nextInt();
        System.out.println("Nam sinh: ");
        int nam = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap que quan: ");
        String que = scanner.nextLine();
        System.out.println("Truong: ");
        String truong = scanner.nextLine();
        System.out.println("Xin chào "+ hoTen + " đến từ " + que +
                ", sinh ngày " + ngaySinh +  "/" + thang + "/" + nam + ", học tại\n" +
                " trường " + truong);


    }
}
