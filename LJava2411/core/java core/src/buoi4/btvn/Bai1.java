package buoi4.btvn;

/**

 Cần có tổng 200.000đ từ 3 loại giấy bạc 1000đ, 2000đ, và 5000đ.
 Lập chương tình để tìm tất cả các phương án có thể sử dụng các mệnh giá trên để tạo ra tổng 200.000đ

 */
public class Bai1 {

    public static void main(String[] args) {
//        int tong = 200000;
        int tong = 20000;
        int tien1 = 1000;
        int tien2 = 2000;
        int tien3 = 5000;

        int tongSoTo1 = tong / tien1;
        int tongSoTo2 = tong / tien1;
        int tongSoTo3 = tong / tien1;

//        timSoTo1(tongSoTo1, tongSoTo2, tongSoTo3, tien1, tien2, tien3, tong);
        timSoTo2(tongSoTo1, tongSoTo2, tongSoTo3, tien1, tien2, tien3, tong);

    }

    private static void timSoTo1(int tongSoTo1, int tongSoTo2, int tongSoTo3, int tien1, int tien2, int tien3, int tong) {
        for (int i = 1; i <= tongSoTo1; i++) {
            int soToTien1 = i;
            for (int j = 1; j < tongSoTo2; j++) {
                int soToTien2 = j;
                for (int k = 1; k < tongSoTo3; k++) {
                    int soToTien3 = k;

                    int tongTien1 = soToTien1 * tien1;
                    int tongTien2 = soToTien2 * tien2;
                    int tongTien3 = soToTien3 * tien3;

                    int tongTam = tongTien1 + tongTien2 + tongTien3;
                    if (tongTam == tong){
                        System.out.println("Can " + soToTien1 + " tien " + tien1 + ", " + soToTien2 + " tien " + tien2 + ", " + soToTien3 + " tien " + tien3);
                    }
                }
            }
        }
    }

    private static void timSoTo2(int tongSoTo1, int tongSoTo2, int tongSoTo3, int tien1, int tien2, int tien3, int tong) {
        int soToTien1 = 0;
        int soToTien2 = 0;
        int soToTien3 = 0;
        int tongTien1 = 0;
        int tongTien2 = 0;
        int tongTien3 = 0;
        int tongTam = 0;
        for (int i = 1; i <= tongSoTo1; i++) {
            soToTien1 = i;
            for (int j = 1; j < tongSoTo2; j++) {
                soToTien2 = j;
                for (int k = 1; k < tongSoTo3; k++) {
                    soToTien3 = k;

                    tongTien1 = soToTien1 * tien1;
                    tongTien2 = soToTien2 * tien2;
                    tongTien3 = soToTien3 * tien3;

                    tongTam = tongTien1 + tongTien2 + tongTien3;
                    if (tongTam == tong){
                        System.out.println("Can " + soToTien1 + " tien " + tien1 + ", " + soToTien2 + " tien " + tien2 + ", " + soToTien3 + " tien " + tien3);
                    }
                }
            }
        }
    }
}
