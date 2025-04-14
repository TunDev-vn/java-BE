package buoi5;

import java.util.Scanner;

/**

 - Mối quan hệ giữa class và object
    + object được tạo ra từ class
    + class là một bản thiết kế để tạo ra các object

    + object:
        + thuộc tính
        + hành vi

 */
public class Main {

    public static void main(String[] args) {
        /*
         new Animal(): yêu cầu heap cấp phát ô
         nhớ để lưu trữ đối tượng animal được
         tham chiều từ biến conMeo tại stack
         new Animal(): constructor sử dụng
         đ khởi tạo đối tượng animal
         */
        Animal conMeo = new Animal();
        // sử dụng . để truy cập vào các method của object
        conMeo.setTen("Tom");
        conMeo.setGioiTinh("Đực");
        conMeo.setTuoi(1);
        conMeo.setSoChan(4);

        conMeo.an();
        conMeo.diLai();

        // tạo ra con voi
        Animal conVoi = new Animal();
        conVoi.setGioiTinh("Cai");
        conVoi.setTuoi(2);
        conVoi.setSoChan(4);
        conVoi.setTen("Chu voi bản đôn");

        conVoi.diLai();
        conVoi.an();
        // Tạo ra danh sách các con vật
        Animal[] danhSachConVat = new Animal[6];
        for (int i = 0; i < 6; i++) {
            Animal animal = new Animal();
            System.out.println("Nhap vao ten: ");
            String ten = new Scanner(System.in).nextLine();
            animal.setTen(ten);
            danhSachConVat[i] = animal;
        }


    }
}
