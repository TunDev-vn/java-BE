package buoi7.btvn.bai1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ManagerAnimal managerAnimal = new ManagerAnimal(0);
        System.out.println("Nhập vào chức năng: ");
        int type = 0;
        do {
            System.out.println("1: Thêm động vật");
            System.out.println("2: Hiển thị thông tin");
            System.out.println("3: Tìm động vật theo tên, không phân biệt hoa thường");
            System.out.println("4: Xóa động vật theo tên, không phân biệt hoa thường");
            System.out.println("5: Thoát");
            type = new Scanner(System.in).nextInt();
            switch (type){
                case 1:
                    managerAnimal.addAnimal();
                    break;
                case 2:
                    managerAnimal.showAllAnimal();
                    break;
                case 3:
                    managerAnimal.search();
                    break;
                case 4:
                    managerAnimal.delete();
                    break;
                case 5:
                    System.out.println("Thoát!");
                    break;
                default:
                    System.out.println("Nhập sai định dạng, đề nghị nhập lại");
                    type = 1;
            }
        }while (type < 5);

    }
}
