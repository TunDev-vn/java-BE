package buoi4;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        int soDong = 3;
        int soCot = 2;

        String[][] array = new String[3][2];
        for (int i = 0; i < soDong; i++) {
            for (int j = 0; j < soCot; j++) {
                array[i][j] = new Scanner(System.in).nextLine();
            }
        }

        for (int i = 0; i < soDong; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();  // Chuyển dòng sau mỗi hàng
        }
    }
}
