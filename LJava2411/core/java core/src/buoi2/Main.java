package buoi2;

/**

 - Biến:
    - là 1 vị trí trong vùng nhớ máy tính, được su dụng để lưu trữ dữ liệu, mỗi
    vị trí này sẽ có tên, địa chỉ, kieu dữ liệu
    - khi khai báo 1 biến trong java tức là đang yêu cầu JVM cấp phát 1 vùng
    nhớ để lưu giá trị của biến đó
    - biến có thể được thay đổi giá trị
 - Các loại biến
    + nguyên thủy:
        int, long, double, float, ....

    + biến tham chiếu: được tạo ra từ class đã được xây dự sẵn từ thư
        viện hoặc được xây dựng trong quá trình pht triển
       vd: Object, Integer, String, Array...
 - các kiểu biến
    local: chỉ được sử dụng trong nội bộ hàm, khoi lệnh, chỉ được khởi tạo khi ham, khối lệnh đó
            được thực thi, sau đó sẽ được giải phóng khi hàm thực thi xong
    instance: thường là thuộc tính của class, được khai báo ngay dưới tên class, có kèm phạm vi truy cập
            có thể truy cập dựa vào phạm vi truy cập, được khởi tao ô nhớ khi sử dụng từ khóa new để
            khai báo object từ class, sẽ bị hủy khi object từ class bị hủy
    static: là 1 biến đặc biệt thuộc về class, chỉ được sử dụng thông qua tên class, có phụ thuộc
            vào pham vi truy cập.
            biến dùng cho cho tất cả các đối tượng được sinh ra từ class
            được khởi tạo đầu tiên, và không cần khởi tạo đối tượng

 */
public class Main {

    // thuộc tính, biến toàn cục,
    private int tuoi;
    private String ten;
    private float namSinh;
    public String diaChi;
    public static void main(String[] args) {
        // biến nguyên thủy
        int x = 10;
        int y = 15;
        int tong = congHaiSo(x,y);
        System.out.println("Thanh cong :" + tong);
        // khai bao literal
        String text = "hello";
        String text2 = "hello";
//        text = "a";

        // Khai bao bang tu khoa new
        String text3 = new String("hello");

        System.out.println(text == text3); // true | false
        System.out.println(text.equals(text3)); // true | false
        Person p1 = new Person();
        p1.ten = "kien";
        Person p2 = new Person();
        p2.ten = "kien";
        System.out.println(p1.equals(p2));




    }

    public static int congHaiSo(int x,int y){
        int tong = x + y;
        return tong;
    }
}
