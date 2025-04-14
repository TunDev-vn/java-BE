package buoi4.btvn.ljava2502;

/*
Bài 4: Tìm tất cả các phương án có thể để có tổng 200.000đ từ 3 loại giấy bạc 1000đ, 2000đ, và 5000đ
Mô tả:
Lập chương trình để tìm tất cả các phương án có thể có tổng 200.000đ với các mệnh giá giấy bạc là 1000đ, 2000đ, và 5000đ.
Test Case:
1.	Input:
Tổng = 200.000đ, mệnh giá = 1000đ, 2000đ, 5000đ
Output:
(x1, x2, x3) là số lượng giấy bạc 1000đ, 2000đ, và 5000đ sao cho:
x1 * 1000 + x2 * 2000 + x3 * 5000 = 200000
Ví dụ một số kết quả:
(x1 = 160, x2 = 20, x3 = 4)
(x1 = 100, x2 = 50, x3 = 10)
(x1 = 0, x2 = 100, x3 = 30)
________________________________________

 */
public class Bai4 {

    public static void main(String[] args) {
        int tong = 200000;
        int menhGia1 = 1000;
        int menhGia2 = 2000;
        int menhGia3 = 5000;

        int tongSoToTien1 = tong / menhGia1;
        int tongSoToTien2 = tong / menhGia2;
        int tongSoToTien3 = tong / menhGia3;

        for (int i = 1; i <= tongSoToTien1; i++) {
            int soToTien1 = i;
            for (int j = 1; j <= tongSoToTien2; j++) {
                int soToTien2 = j;
                for (int k = 1; k <= tongSoToTien3; k++) {
                    int soToTien3 = k;

                    int tongTien1 = soToTien1 * menhGia1;
                    int tongTien2 = soToTien2 * menhGia2;
                    int tongTien3 = soToTien3 * menhGia3;
                    int tong3Loai = tongTien1 + tongTien2 + tongTien3;
                    if (tong3Loai == tong){
                        System.out.println(String.format("x1 = %d, x2 = %d, x3 = %d",soToTien1,soToTien2,soToTien3));
                    }
                }
            }
        }


    }
}
