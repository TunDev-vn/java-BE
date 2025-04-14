package buoi4.btvn.ljava2502;

/*
Bài 3: Tính giai thừa của n (n!)
Mô tả:
Nhập vào số nguyên dương n, tính giai thừa của n.
Test Case:
1.	Input:
n = 5
Output:
5! = 5 * 4 * 3 * 2 * 1 = 120
2.	Input:
n = 7
Output:
7! = 7 * 6 * 5 * 4 * 3 * 2 * 1 = 5040

 */
public class Bai3 {

    public static void main(String[] args) {

        int n = 5;
        int ketQua1 = tinhGiaThua1(n);
        System.out.println(ketQua1);
        int ketQua2 = tinhGiaThua2(n);
        System.out.println(ketQua2);
    }

    public static int tinhGiaThua1(int n){
        int ketQua = 1;
        for(int i = n; i > 0; i--){
            ketQua *= i;
        }
        return ketQua;
    }

    public static int tinhGiaThua2(int n){
        if (n == 0){
            return 1;
        }
        return n * tinhGiaThua2(n - 1);
    }
}
