package buoi4.btvn.ljava2502;

/*
Bài 5: Đổi sang số nhị phân của một số nguyên dương n
Mô tả:
Nhập vào số nguyên dương n và in ra số nhị phân của nó.
Test Case:
1.	Input:
n = 8
Output:
8 -> 1000
2.	Input:
n = 7
Output:
7 -> 111
3.	Input:
n = 9
Output:
9 -> 1001
4.	Input:
n = 16
Output:
16 -> 10000

cách đổi số hệ 10 => số nhị phân
1) chia n cho 2 và lấy lại phần dư ex: 9 / 2 = 4 dư 1
2) lấy phần nguyên chia tiếp cho 2 tiếp tục lấy phần dư: 4 / 2 = 2 dư 0 cho đến khi phần nguyên / 2 = 0
3) đảo ngược dãy phần dư => đó là số nhị phân
ex:
9 / 2 = 4 dư 1
4 / 2 = 2 dư 0
2 / 2 = 1 dư 0
1 / 2 = 0 dư 1
=> 1001 là số nhị phân
 */
public class Bai5 {

    public static void main(String[] args) {
        int n = 16;
        String ketQua = "";
        while (n != 0){
            int soDu = n % 2 ;
            ketQua = soDu + ketQua;
            n = n /2;
        }
        System.out.println(ketQua);
    }
}
