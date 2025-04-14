package buoi10.btvn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        int type = 0;
        do {
            menu();
            type = getType();
            try {
                switch (type){
                    case 1:
                        studentManager.add();
                        break;
                    case 2:
                        studentManager.remove();
                        break;
                    case 3:
                        studentManager.showAll();
                        break;
                    case 4:
                        studentManager.findByName();
                        break;
                    case 5:
                        studentManager.sortByPoint();
                        break;
                    case 6:
                        studentManager.checkExist();
                        break;
                    case 7:
                        System.out.println("bye bye");
                        break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                type = 1;
            }
        }while (type != 7);
    }
    public static void menu(){
        System.out.println("================ MENU ================");
        System.out.println("1. Add student to list.");
        System.out.println("2. Remove student from list.");
        System.out.println("3. Print student list.");
        System.out.println("4. Search student by name.");
        System.out.println("5. Sort list student by test score.");
        System.out.println("6. Check student exist by ID.");
        System.out.println("7. Exit!!!");
        System.out.println("======================================");
    }

    public static int getType(){
        try {
            int type = new Scanner(System.in).nextInt();
            return type;
        }catch (Exception e){
            System.out.println("Lỗi bạn đã nhập ký tự không phải số");
            return 1;
        }
    }
}
