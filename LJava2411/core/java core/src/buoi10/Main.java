package buoi10;
/*

- Chức năng thêm mới sinh viên vào lớp học, sau khi thêm sinh viên thành công, mới thực hiện gửi mail:
    + thêm sinh viên vào hệ thống : 2s
    + gửi email cho sinh viên đó, thông báo sinh viên đã được thêm vào lớp học: 2s
    => tổng = 4s

    luồng thực hiện:
    c1, tạo ra thêm 1 thread gửi mail sau khi thêm sinh viên thành công
        thread chính:
            1) thực hiện thêm sinh viên vào hệ thống: 2
            nếu thành công:
                tạo ra thread thứ 2: thực hiện gửi mail : 2s => thread ngầm
           done
   c2: tạo ra thẳng 2 thread, 1 thread thêm sinh viên, 1 thread gửi mail
        thread chính
            1) tạo ra thread 1 thêm sinh viên => nếu việc thêm sinh viên exception => không thể ngừng thread gửi mail được
            2) tạo ra thread 2 gửi mail

 */
public class Main {
}
