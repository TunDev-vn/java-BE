package buoi4.btvn.ljava2502;

/*
Bài 1: Tính tổng S(n) = 1^3 + 2^3 + 3^3 + ... + n^3
Mô tả:
Nhập n từ bàn phím (n dương, bắt nhập lại nếu n âm) và tính tổng dãy S(n).
Test Case:
1.	Input:
n = 3 Output:
S(3) = 1^3 + 2^3 + 3^3 = 1 + 8 + 27 = 36
2.	Input:
n = 5 Output:
S(5) = 1^3 + 2^3 + 3^3 + 4^3 + 5^3 = 1 + 8 + 27 + 64 + 125 = 225

 */
public class Bai1 {

    public static void main(String[] args) {
        int n = 3;
        int tong = 0;
        for (int i = 1; i <= n; i++) {
            tong += (int) Math.pow(i, 3);
        }
        System.out.println(tong);
    }
}
