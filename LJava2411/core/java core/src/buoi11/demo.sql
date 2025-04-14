-- câu lệnh tạo cơ sở dữ liệu, tạo cơ sở dữ liệu quanlyhocsinh
create database quanlyhocsinh;
-- câu lệnh xóa database, câu lệnh nguy hiểm
drop database quanlyhocsinh;
use quanlyhocsinh; -- chỉ định cho database biết muốn chạy câu lệnh trên database quanlyhocsinh
-- tạo bảng học sinh, để lưu trữ các thông tin của học sinh
create table student ( -- định nghĩa tên bảng, tạo bảng
                         id integer primary key auto_increment, -- tạo ra các cột với cấu trúc (ten_cot kiểu_dữ_liệu), auto_increment id tự động tăng
                         full_name nvarchar(50), -- nvarchar lưu tên tiếng việt
                         date_of_birth date, -- date lưu trữ kiểu dữ liệu date
                         code varchar(50), -- varchar, lưu các ký tự không chứa dấu utf-8,
                         deleted bit, -- lưu trữ giá trị true, false của boolean
                         last_modify_time datetime, -- datetime: dữ liệu dạng ngày tháng có giờ
                         description longtext, -- lưu trữ thông tin 4,294,967,295 characters
    -- avatar blob, -- lưu trữ dạng file
                         point float -- lưu trữ số lẻ
);
-- khóa chính, giúp xác định tính duy nhất độc lập dữ liệu trong bảng, vì hai bảng ghi trong cùng 1 table không được trùng khóa chính với nhau
-- câu lệnh thêm dữ liệu vào bảng
insert into -- câu lệnh thêm dữ liệu
    student -- tên table muốn thêm
(full_name, date_of_birth, code, deleted, description, point) -- các cột muốn thêm dữ liệu
    value -- từ khóa chỉ định đây là các value của cột
    ('Nguyễn Văn Tuấn','2021-01-01','S001',0,'Sinh viên quê tại HN',7.5);
insert into -- câu lệnh thêm dữ liệu
    student -- tên table muốn thêm
(full_name, date_of_birth, code, deleted, description, point) -- các cột muốn thêm dữ liệu
    value -- từ khóa chỉ định đây là các value của cột
    ('Nguyễn Văn Kiên','2021-01-01','S001',0,'Sinh viên quê tại HN',7.5);
insert into -- câu lệnh thêm dữ liệu
    student -- tên table muốn thêm
(full_name, date_of_birth, code, deleted, description, point) -- các cột muốn thêm dữ liệu
    value -- từ khóa chỉ định đây là các value của cột
    ('Lê Thiên Tuấn','2021-01-01','S001',0,'Sinh viên quê tại HN',8.5);
-- hiển thị toàn bộ dữ liệu trong bảng
select * from student;
-- câu lệnh chỉnh sửa table, thêm cột id làm khóa chính

/*
 bài tập 1
 1) tạo table lớp học với các thông tin
    1) id là khóa chính,
    2) code lưu mã lớp học
    3) ngày mở lớp
    4) deleted lưu trư, false lưu trạng thái lơps bị xóa chưa
    5) description mô tả về lớp học, long text
 2) insert 1 bản ghi dữ liệu cho table bảng lớp học,
 với các lớp học về các ngôn ngữ lập trình
 */
-- tạo table class
create table class(
                      id integer primary key auto_increment, -- cột id là khóa chính, kiểu dữ liệu int, giá trị tự động tăng
                      code varchar(50),
                      date_start date,
                      deleted bit,
                      description longtext
);
insert into class(code, date_start, deleted, description)
values  -- cho phép thêm nhiều row ứng với các cột đã khai báo
        ('C001','2023-01-01',false,'Lập trình Java'),
        ('C002','2023-01-02',false,'Lập trình C'),
        ('C003','2023-01-03',false,'Lập trình Python'),
        ('C004','2023-01-04',false,'Lập trình Javascript');

select * from class;
-- câu lệnh chỉnh sửa kiểu dữ liệu của cột
alter table class
    modify date_start datetime;

-- khóa ngoại
/*
 student(sinh viên) và class(lớp học) có mối quan hệ như thế nào trong trường
 vd:
    1 sinh viên có thể học 1 hay nhiều lớp học
    1 lớp học có thể có 1 hay nhiều sinh viên
 => 1 sinh viên có thể được học nhiều lớp học
    1 lớp học có thể có nhiều sinh viên
 câu hỏi ?
    làm thế nào để thể hiện được mối quan hệ giữa các sinh viên, lớp học trong dữ
    liệu của database
 => khi đấy ngta sử dụng khóa ngoại để xác định mối quan hệ giữa các table và các bản ghi
    giữ liệu của hai table trong database
 */
select * from student;
select * from class;
/*
 xử lý từng mối quan hệ:
    1 sinh viên có thể được học nhiều lớp học:
        1 student - n class
    1 lớp học có thể có nhiều sinh viên
        1 class - n student
    => đây là mối quan hệ n - n
    để thể hiện mối quan hệ n - n này trong database sẽ sử dụng 1 bảng trung gian
    chứa khóa ngoại của của cả hai bảng trong mối quan hệ n-n
 vd: tạo table student_class với các cột
        id_class :
            + đóng vai trò là khóa ngoại tham chiếu tới cột id của bảng class
        id_student :
            +đóng vai trò là khóa ngoại tham chiếu tới cột id của bảng student
    lưu ý:
        + khóa ngoại phải cùng kiểu dữ liệu dữ liệu với cột nó tham chiếu tới
        + dữ liệu của khóa ngoại phải được tồn tại trong danh sách cột tham chiếu tới
 */
create table student_class (
                               id_class integer,
                               id_student integer
);

alter table student_class -- sửa table student_class
    add foreign key (id_class) -- chỉ định cột id_class trở thành khóa ngoại
        references class(id); -- tham chiếu tới bảng class cột id
alter table student_class
    add foreign key (id_student)
        references student(id);
/*
 làm sao để thể hiện được học sinh Nguyễn Văn Tuấn và Nguyễn Văn Kiên cùng học lớp Lập trình Java có mã C001
    cách làm:
    thêm 1 bản bản ghi trong bảng student_class để thể hiện mối quan hệ
    Nguyễn Văn Tuấn học lớp Lập trình Java
    -> id_student = id của sinh viên Nguyễn Văn Tuấn = 1
        id_class = id của lớp học Lập trình Java = 1
    thêm 1 bản bản ghi trong bảng student_class để thể hiện mối quan hệ
    Nguyễn Văn Kiên học lớp Lập trình Java
    -> id_student = id của sinh viên Nguyễn Văn Kiên = 2
        id_class = id của lớp học Lập trình Java = 1
 */
insert into student_class(id_class, id_student)
values
    (1,1),
    (1,2);
-- lấy tất cả dữ liệu trong bảng student
select * from student;
/*
 * : lấy ra dữ liệu tất cả colum, nếu muốn chỉ định colum muốn lấy
 -> chỉ định sau select : select full_name,code from student;
 */
select full_name,code from student;
/*
 where : được sử dụng để tạo ra các điều kiện lọc dữ liệu từ bảng, sử dụng các toán tử để lọc
 - giá trị của cột được so sánh gọi là A
 - giá trị đưa vào để so sánh gọi là B
    = : A = B
    like : A like B (tìm kiếm gần đúng)
    > : A > b
    < : A < B
    >= : A >= B
    <= : A <= B
 */
-- tìm kiếm sinh viên có code = S001
select * from student where code = 'S001';
-- tìm kiếm sinh viên có họ văn
select * from student where full_name like '%Văn%';
/*
 câu lệnh like nếu
    - không có % => tìm kiếm tương tụ dấu =
    - nếu có %
        + nếu % nằm phía trước => bỏ qua toàn bộ ký tự trước %
        + nếu % nằm phía sau => bỏ qua toàn bộ ký tự sau %
 */
-- tìm student có điểm > 1 và code = 'S001'
select * from student where point > 1 and code = 'S001';
-- tìm student có điểm > 1 hoặc code = 'S001'
select * from student where point > 1 or code = 'S001';
-- lấy ra tất cả các student, không check điều kiện gì nhưng giới hạn chỉ 1 bản ghi đầu tiên
select * from student limit 1;