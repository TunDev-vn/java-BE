package buoi3.baitap;

import buoi3.Person;

import java.util.Scanner;

/**
 C: 2 loại bến
    + biến tham trị
        khi truyền 1 biến tham trị vào 1 hàm
        nó sẽ copy giá trị của biến đấy và hàm sẽ thao tác với
        giá trị copy của biến đấy
        => nếu thay đổi giá trị của biến đó =>
        biến gốc không bị thay đổi giá trị
    + biến tham chiếu
         khi truyền 1 biến tham chiếu vào 1 hàm
         nó sẽ truyền thẳng địa chỉ ô nhớ của biến đó vào hàm
         => nếu hàm thay đổi giá trị của biến đó =>
         biến gốc sẽ bị thay đổi giá trị
 Java: Khi truyền 1 biến vào trong 1 hàm, dủ là biến object
 hoặc biết nguyên thủy cũng sẽ chỉ truyền vào biến tham trị
 không truyền vào biến tham chiếu

 hàm đệ quy:
    gọi là chính hàm đó, nhưng phải có điều kiện dừng, nếu không có điều kiện dừng
    hàm sẽ trở thành vòng lặp vô hạn
 */
public class Bai1 {

    public static void main(String[] args) {
        int n = getN();
//      int soDaoNguoc = bai2(n);
//        System.out.println(soDaoNguoc);
        int giaThua = bai3Dequy(n);
        System.out.println(giaThua);
    }

    /**
     bài 3) nhập vào n, tính giai thừa của n
     n! = n * (n-1) * (n-2) * ... * 1
     */
    public static int bai3(int n){
        int giaiThua = 1;
        for (int i=n;i > 0; i--){
            giaiThua *= i;
        }
        return giaiThua;
    }

    public static int bai3Dequy(int n){
        System.out.println(n);
        if (n == 0 || n == 1){
            return 1;
        }
        return n * bai3Dequy(n - 1);
    }

    public static int bai2(int n){
        // n = 123
        // 123 % 10 = 3 du 12, 12 % 10 = 2, 1 % 10 0
        n = 456;
        int soDaoNguoc = 0;
        while (n != 0){
            int soDuoi = n % 10;
            soDaoNguoc = soDaoNguoc * 10 + soDuoi;
            n = n / 10;
        }
        return soDaoNguoc;
    }
    public void bai1(int n){
        long tong = 0;
        for (int i = 1; i <= n; i++) {
            tong += (long) Math.pow(i,3);
        }
        System.out.println("Tong S(n) = 1^3 + 2^3 + 3^3 + … + n^3 la: " + tong);
    }
    public static int getN(){
        Scanner sc = new Scanner(System.in);
        int n=0;
        do {
            System.out.println("Nhap vao n: ");
            n = sc.nextInt();
        }while (n <= 0);
        return n;
    }
}
