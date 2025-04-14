package buoi6;

/**
 - Đa hình:
    cùng 1 hành động, nhưng được thể hiện bằng các hình
    thái khác nhau
    vd:
        cùng là hành động tạo ra tiếng kêu nhưng khi object
        là lion sẽ kêu: Lion is roaring.
        khi là: Elephant sẽ kêu Elephant is trumpeting.
        khi là: Monkey sẽ kêu Monkey is chattering.
    => đó chính là tính đa hình trong java

 - Các thời điểm đa hình:
    + compile time: là thời điểm chương trình biên dịch từ
        file .java -> file .class, tức là thời điểm compile
        chương trình
        để đạt được tính đa hình tại thời điểm này chúng
        ta sử dụng overload method

    + runtime: là thời điểm máy ảo jvm chạy các file byte code,
            hay nói cách khác là chương trình java đang chạy từng
            dòng lệnh 1.
         để đạt được tính đa hình tại thời điểm này chúng
         ta sử dụng overriding method

 overload method:
    - sảy ra khi hai hoặc nhiều method cung chung xuất hiện
    trong cùng 1 class với các đặc tính sau
        + trùng tên (bắt buộc)
        + trùng tham số truyền vào nhưng khác kiểu dữ liệu
            trả về
        + khác kiểu dữ liệu trả về nhưng cùng kiểu dữ liệu tham
        số truyền vào
        + cùng kiểu dữ liệu trả về cùng số lượng tham số truyền vào
        nhưng trong danh sách tham s truyền vào có các kiểu dữ
        liệu khác nhau

 override method:
    - Sảy ra tại hai class có mối quan hệ kế thừa
    - khi class con tồn tại 1 method giống y hệ class cha
        + giống tên, kiểu dữ liệu trả về, tham số truyền vào
 => method tại class con chính là override method

 Bài tập 3: Áp dụng tính kế thừa, trừu tượng, và đa hình Đề bài:
 Phát triển chương trình quản lý động vật trong sở thú từ bài tập 2:
 1. Thêm một phương thức action() trong lớp trừu tượng Animal.
 • Phương thức này sẽ được ghi đè ở từng lớp con để mô tả hành động đặc trưng của mỗi loại động vật:
 • Lion: in ra “The lion is hunting.”
 • Elephant: in ra “The elephant is spraying water.”
 • Monkey: in ra “The monkey is climbing trees.”
 2. Thêm phương thức showInfo() để hiện thị thông tin chi tiết của mỗi con vật gồm tên, tuổi
 3. Tạo class ManagerAnimal cho phép thực hiện các yêu cầu:
    a) có 1 danh sách các động vậy Lion,Elephant,Monkey, cho phép người dùng nhập vào n, chính là
    tổng số lượng các động vật mà sở thú quản lý
    b) nhập vào danh sách các động vật củ sở thú và cho phép người dùng lựa chọn
        1) nhập vào Lion
        2) nhập vào Elephant
        3) nhập vào Monkey
        4) Dừng nhập vào
    chú ý: nhập vào là bao gồm cả các thông tin tên, tuổi
    c) Hiển thị danh sách tất cả các động vật trong sở thú
    d) Thêm 1 con vật nếu danh sách đầy, phải mở rộng danh sách, mặc định mở rộng 10 phần tử
    e) Cho phép nhập tên con vật, hiển thị thông tin con vật nếu có, không phân biệt hoa thường
    f) Cho phép xóa con vật theo tên

 */
public class Main2 {
}
