package buoi4.btvn;

/**
 Bài 3)
 Đề bài: Kiểm tra và phân loại số trong một dãy
 Mô tả bài toán: Viết chương trình thực hiện các yêu cầu sau trên một dãy số nguyên dương nhập vào từ người dùng:
 1. Kiểm tra xem số đó có phải là số hoàn hảo hay không.
 2. Kiểm tra xem số đó có phải là số Armstrong hay không.
 3. Kiểm tra xem số đó có phải là số đối xứng hay không.
 4. Tính tổng các chữ số của mỗi số trong dãy.
 Yêu cầu chi tiết:
 1. Nhập vào một dãy số nguyên dương n1,n2…nk từ người dùng.
 2. Với mỗi số trong dãy:
 o In ra thông báo số đó là số hoàn hảo hay không.
 o In ra thông báo số đó là số Armstrong hay không.
 o In ra thông báo số đó là số đối xứng hay không.
 o Tính tổng các chữ số và in kết quả.
 Input:
 · Một dãy số nguyên dương n1,n2,n3…,nk
 · Ví dụ: 153 6 121 10 9474
 Output:
 · Kiểm tra cho mỗi số trong dãy:
 o Kiểm tra số hoàn hảo.
 o Kiểm tra số Armstrong.
 o Kiểm tra số đối xứng.
 o Tổng các chữ số của số đó

 - hoàn hảo:
    + tổng các ước của số đó sẽ bằng chính nó, không tính bản thân số đó
    + ước củ 1 số n là k khi n % k = 0
    ý tưởng:
        duyet từ 1 -> n
            -> kiểm tra nếu n % i == 0
                => cổng tổng các số i
        nếu tổng các số i = n
            => đó là số hoàn hảo
 - Armstrong:
    + nếu 1 số n gọi là số Armstrong khi tổng các lũy thừa của mỗi số trong n (lũy thừa
    sẽ bằng tổng các chữ số của n) bằng chính n
    => đó là số Armstrong
    n có k số => tống các chữ số của n với lũy thừa k = n => đó là số Armstrong
 vd: n = 153, k = 3;
    tong = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 => Armstrong

 - So doi xung:
    khi đảo ngược thứ tự đứng của các chữ số  rồi vẫn bằng số ban đầu
    121 = 121
 */
public class Bai3 {
    public static boolean kiemTraSoDoiXung(int n){
        int soN = n;
        int soDoiXung = 0;
        int soTam = 0;
        while (soN != 0){
            soTam = soN % 10;
            soDoiXung = soDoiXung * 10 + soTam;
            soN = soN / 10;
        }
        // kiem tra
        if (soDoiXung == n){
            return true;
        }
        return false;
    }
    public static boolean kiemTraSoArmstrong(int n){
        int soN = n;
        // lấy các chu so cua n gọi la k
        int soCacChuSo = 0;
        while (soN != 0){
            soN = soN / 10;
            soCacChuSo++;
        }
        System.out.println("so cac chu so: " + soCacChuSo);

        soN = n;
        // tinh tong cac chu so với lũy thừa k
        int chuSo = 0;
        int tong = 0;
        while (soN != 0){
            chuSo = soN % 10;
            tong += Math.pow(chuSo,soCacChuSo);
            soN = soN / 10;
        }
        // so sánh với n
        if (tong == n){
            return true;
        }
        return false;
    }

    public static boolean kiemTraSoHoanHao(int n){
        int tongTam = 0;
        for (int i = 1; i < n ; i++) {
            // tìm ước của n
            if (n % i == 0){
                // i chính là ước của n
                tongTam += i;
            }
        }
        // so sánh tổng và n
        if (tongTam == n){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(kiemTraSoHoanHao(10));
        System.out.println(kiemTraSoArmstrong(153));
        System.out.println(kiemTraSoArmstrong(6));

        System.out.println(kiemTraSoDoiXung(121));
        System.out.println(kiemTraSoDoiXung(123));
    }
}
