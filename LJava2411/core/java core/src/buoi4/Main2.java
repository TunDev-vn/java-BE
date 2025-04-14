package buoi4;

/**
 String:
    + là 1 class đặc biệt được cung cấp
        sẳn bởi jdk, chuyên xử lý về chuỗi ký tự
    + bất biến, không thể thay đổi
 - có hai kiểu sai báo:
    + khai báo theo kiểu nguyên thủy
        string sẽ được lưu trong String pool, và
        không tồn tại hai string giống nhau trong
        string pool
    + khai báo theo kiểu đối tượng
        string sẽ nằm trong object String trong
        heap
 - So sánh String
    + sử dụng ==
        - nếu là đối tượng:
            so sánh địa chỉ ô nhớ của object trong heap
        - nếu kiểu nguyên thủy:
            so sánh giá trị của hai biến trong stack

    + sử dụng equal
        chỉ áp dụng cho các biến đối tượng
        sẽ sử dụng để so sánh value của hai biến
    => lên sử dụng equal để so sánh hai String

 - Coi 1 chuỗi text trong String như là 1 mảng
    các ký tự

 */
public class Main2 {
    public static void main(String[] args) {
        String text = "hello";
        String text2 = "hello";
        String text4 = "hello";

        String text3 = new String("hello");

        System.out.println(text == text4); // t
        System.out.println(text.equals(text2)); // t
        System.out.println(text.equals(text3)); // t
        System.out.println(text == text3); // f

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello").append(" world");
        System.out.println(stringBuilder.toString()); // hello world

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello");
        /*
        char[]
        Tại sao StringBuilder và StringBuffer có thể tạo ra được cac String có thể thay đổi ?
        đồng bộ:
            các câu lệnh và quá trình xử ly của 1 chương trình sẽ diễn ra tuần tự, từ trên xuống dưới
            theo 1 luồng nhất định, cac câu lệnh chỉ chạy trên 1 luồng chính và phải chờ giải phóng tài
            nguyên mới được sử dụng
        StringBuffer:
           hoạt động theo cơ chế đồng bộ, luồng an toàn
        StringBuilder:
            hoạt động theo cơ chế bất đồng bộ, luồng không an toán
         */


    }
}
