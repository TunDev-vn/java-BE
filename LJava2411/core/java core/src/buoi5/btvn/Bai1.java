package buoi5.btvn;

/**
 Bài 1
 Cho chuỗi:
 Ngôn ngữ lập trình Java ban đầu được phát triển bởi Sun Microsystems do James Gosling khởi xướng và phát hành vào năm 1995. Phiên bản mới nhất của Java Standard Edition là Java SE 8. Với sự tiến bộ của Java và sự phổ biến rộng rãi của nó, nhiều cấu hình đã được xây dựng để phù hợp với nhiều loại nền tảng khác nhau. Ví dụ: J2EE cho các ứng dụng doanh nghiệp, J2ME cho các ứng dụng di động.
 a) Đếm số lượng từng từ trong đoạn trên (không phân biệt hoa thường):
 Ví dụ ta có chuỗi “Tôi học lập trình, học lập trình rất hay”
 Kết quả từ
 Tôi : 1 từ
 Học : 2 từ
 Lập: 2 từ
 Trình: 2 từ
 Rất: 1 từ
 Hay: 1 từ
 b. Viết hoa chữ đầu trong mỗi từ
 c. Xóa các nguyên âm trong câu
 */
public class Bai1 {

    public static void main(String[] args) {
        String str = "Tôi học. lập trình, Học; lập trình: rất hay";
        String str2 = "Ngôn ngữ lập trình Java ban đầu được phát triển bởi Sun Microsystems do James Gosling khởi xướng và phát hành vào năm 1995. Phiên bản mới nhất của Java Standard Edition là Java SE 8. Với sự tiến bộ của Java và sự phổ biến rộng rãi của nó, nhiều cấu hình đã được xây dựng để phù hợp với nhiều loại nền tảng khác nhau. Ví dụ: J2EE cho các ứng dụng doanh nghiệp, J2ME cho các ứng dụng di động.";
        demSoLuongTu(str2);
    }

    public static void demSoLuongTu(String str){
        // cat chuoi
        String[] arrStr = str.split(" ");
        // chuan hoa chuoi
        xoaKyTuDacBiet(arrStr);

        // tao ra mảng hai chiều chứa kết quả
        int soDong = arrStr.length;
        int soCot = 2;
        int soLuongDongThuTe = 0;
        String[][] mangKetQua = new String[soDong][soCot];
        // dem so lan xuat hien
        for (int i = 0; i < arrStr.length; i++) {
            boolean boQuaKyTu = false;
            String kyTuKiemTra = arrStr[i];

            // kiểm tra tất cả các ký tự từ index = 0 cho tới index = i
            for (int j = 0; j < i; j++) {
                // nếu có ký tự nào trùng với từ cần kiểm tra
                if (kyTuKiemTra.equalsIgnoreCase(arrStr[j])){
                    // bo qua từ đó = true
                    boQuaKyTu = true;
                    break;
                }
            }
            // bỏ qua ký tự nếu ký tự đã được kiem tra
            if (boQuaKyTu){
                continue;
            }
            // đếm số lần xuất hiện của từ
            int count = 0;
            for (int j = i; j < arrStr.length; j++) {
                if (kyTuKiemTra.equalsIgnoreCase(arrStr[j])){
                    count++;
                }
            }
            // đưa từ đó và số lần xuất hiện vào mảng hai chiều kết quả
            mangKetQua[soLuongDongThuTe][0] = kyTuKiemTra;
            mangKetQua[soLuongDongThuTe][1] = String.valueOf(count);
            soLuongDongThuTe++;
        }
        // hiển thị kết quả
        hienThiMangHaiChieu(mangKetQua,soLuongDongThuTe);
    }
    public static void hienThiMangHaiChieu(String[][] arr,int soDongThuTe){
        for (int i = 0; i <soDongThuTe ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String data = arr[i][j];
                if (j == 0){
                    data = data.substring(0,1).toUpperCase() + data.substring(1);
                    System.out.printf(data + " : ");
                    continue;
                }
                System.out.printf(arr[i][j] + " từ");
            }
            System.out.println("");
        }
    }
    public static void xoaKyTuDacBiet(String[] arrStr){
        for (int i = 0; i < arrStr.length; i++) {
            String str = arrStr[i].replace(".","").replace(";","").replace(":","").replace(",","").trim();
            arrStr[i] = str;
        }
    }
}
