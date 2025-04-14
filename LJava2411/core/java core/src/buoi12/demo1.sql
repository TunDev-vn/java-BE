create database hethongquanly;

use hethongquanly;
create table students
(
    id         integer primary key auto_increment,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    birth_date DATE,
    email      VARCHAR(100)
);

create table courses
(
    id                 integer primary key auto_increment,
    course_name        VARCHAR(100),
    course_description TEXT
);

create table enrollments
(
    id              integer primary key auto_increment,
    student_id      INT,
    course_id       INT,
    enrollment_date DATE,
    first_name      int not null
);


insert into students
(first_name, last_name, birth_date, email)
VALUES ('khiet', 'thanh', '2003-05-28', 'khiet@gmail.com'),
       ('khiet', 'thanh', '2003-05-28', 'khiet@gmail.com'),
       ('khiet', 'thanh', '2003-05-28', 'khiet@gmail.com'),
       ('khiet', 'thanh', '2003-05-28', 'khiet@gmail.com'),
       ('khiet', 'thanh', '2003-05-28', 'khiet@gmail.com');

select * from students;

insert into courses
(course_name, course_description)
values ('001', 'lopjava'),
       ('002', 'lopC++'),
       ('003', 'lopC#');

select *
from courses;

/*
 group by
 */
select count(*),last_name from students group by last_name;
/*
 having:
 đếm số lượng student theo last_name, mà số lượng student có cùng last > 1;
 */
select count(*),last_name from students group by last_name having count(*) > 1;


/*
 inner join

 */

CREATE TABLE employees (
                           employee_id INT PRIMARY KEY,
                           first_name VARCHAR(50),
                           last_name VARCHAR(50),
                           department_id INT,
                           salary DECIMAL(10, 2)
);
CREATE TABLE departments (
                             department_id INT PRIMARY KEY,
                             department_name VARCHAR(50)
);

INSERT INTO employees (employee_id, first_name, last_name, department_id, salary)
VALUES
    (1, 'John', 'Doe', 1, 60000.00),
    (2, 'Jane', 'Smith', 2, 75000.00),
    (3, 'Alice', 'Johnson', 1, 80000.00),
    (4, 'Bob', 'Brown', 3, 55000.00),
    (5, 'Charlie', 'Davis', 2, 72000.00);
INSERT INTO departments (department_id, department_name)
VALUES
    (1, 'HR'),
    (2, 'Engineering'),
    (3, 'Sales');

alter table employees add foreign key (department_id) references departments(department_id);

-- kết hop du lieu tu bang employees va department, chi lay ra
-- các employee có thuộc về department
select emp.employee_id,emp.first_name,dept.department_name from employees emp -- kết hợp hai bảng
                                                                    inner join departments dept
                                                                               on emp.department_id = dept.department_id -- chỉ lấy ra các bản ghi ở bảng employee và department có cùng department_id
;

INSERT INTO employees (employee_id, first_name, last_name, salary)
VALUES
    (6, 'John', 'Doe',60000.00);
INSERT INTO employees (employee_id, first_name, last_name,department_id, salary)
VALUES
    (7, 'John3', 'Doe',2,60000.00);
INSERT INTO departments (department_id, department_name)
VALUES
    (4, 'Web');

select * from departments;
select * from employees;

/*
 left join
 lấy toàn bộ dữ liệu table A
 chỉ lấy dữ liệu thỏa mãn cảu table b
 */
select * from employees;
select * from employees left join departments
                                  on employees.department_id = departments.department_id;
/*
 c1: chức năng tìm kiếm nhân viên, hiển thị tông tin last_name
 của nhân viên, và phòng ban của nhân viên, nếu nhân viên
 không có phòng ban, hiển thị null

c2: chức năng tìm kiếm nhân viên, hiển thị tông tin last_name
 của nhân viên, và phòng ban của nhân viên, chỉ lấy
 ra các nhân viên có phòng ban
 */
-- c1:
select emp.last_name,dept.department_name
from employees emp left join departments dept
                             on emp.department_id = dept.department_id;

select emp.last_name,dept.department_name
from employees emp inner join
     departments dept on emp.department_id = dept.department_id;
/*
 right join:
    table A, table B
    luôn lấy toàn bộ dữ liệu của table B, chỉ lấy các dữ liệu thỏa mãn của table A
 */
select * from employees emp right join departments dept
                                       on emp.department_id = dept.department_id;
/*
 self join
 kết hợp dữ liệu với chính nó, qua khóa ngoại lồng
 */
create table category(
                         id int primary key auto_increment,
                         name nvarchar(50),
                         parent_id int -- khóa ngoại tham chiếu trực tiếp tới id của chính bảng categroy, lưu lai id của category cha
);

alter table category add foreign key (parent_id) references category(id);

insert into category -- thêm hai category cha, to nhất
(name, parent_id) values
                      ('Nữ',null),
                      ('Trẻ Sơ Sinh',null),
                      ('Nam',null),
                      ('Trẻ Em',null);
insert into category -- các category con của Nữ
(name, parent_id) values
                      ('Đồ mặc ngoài',1),
                      ('Quần',1),
                      ('Chân váy và đầm',1);
insert into category -- các category con của Trẻ sơ sinh
(name, parent_id) values
                      ('Em bé (0-1 tuổi)',2),
                      ('Em bé (6-5 tuổi)',2);

-- chỉ hiển thị được các category cha khi vừa vào màn home
select name from category where parent_id is null ;
-- chỉ lay ra các category của nữ -> có parent = nữ
select child.name from category child
                           inner join category parent on child.parent_id = parent.id
where parent.name = 'Nữ';
-- chỉ lấy ra các category của tre so sinh ?
select child.name from category child
                           inner join category parent on child.parent_id = parent.id
where parent.name = 'Trẻ Sơ Sinh';

-- lưu các dữ liệu lớp con Chân váy và đầm level 2, vãy id = 5
select * from category;
insert into category --
(name, parent_id) values
                      ('Chân Váy',5),
                      ('Đầm & Jumpsuit',5),
                      ('Tất Cả CHÂN VÁY & ĐẦM',5);

-- lưu các dữ liệu lớp con Trẻ sơ sinh level 2, vãy id = 2
select * from category;
insert into category --
(name, parent_id) values
                      ('Đồ Liền Mảnh',2),
                      ('Bodysuit',2),
                      ('Áo Thun In Họa Tiết',2);
-- lấy ra các con của categroy Chân váy và đầm
select child.name from category child inner join
                       category parent on child.parent_id = parent.id
where parent.name = 'Chân váy và đầm';

-- full join
/*
 full join:
    kết hợp dữ liệu của cả hai bảng với nhau,
    trong mysql không hỗ trợ trực tiếp, cần thực
    hiện thông quan union

 union:
    kết hợp dữ liệu của hai bảng với nhau, với điều
    kiện tất cả các cột của hai bảng phải giống nhau
    cả tên, kiểu dữ liệu
 */

select department_id from employees
union
select department_id from departments;

select * from employees emp
                  left join departments dept
                            on emp.department_id = dept.department_id
union
select * from employees emp
                  right join departments dept
                             on emp.department_id = dept.department_id;

/*
 cross join
    + tổng hợp tat cả dữ liệu của bảng A
    vơi tất cả dữ liệu của bảng B theo dạng tích decat
 */
select * from employees emp
                  cross join departments dept on emp.department_id =
                                dept.department_id;

-- sub query
/*
 trong câu query sẽ thực hiện 1 câu query khác trước, và lấy kết quả của câu query đó thể thực hiện
 đưa ra kết quả cuối cùng
 */
-- lấy ra các con của categroy Chân váy và đầm sử dụng join
select child.name from category child inner join
                       category parent on child.parent_id = parent.id
where parent.name = 'Chân váy và đầm';
-- lấy ra các con của categroy Chân váy và đầm sử dụng sub query
select child.name from category child
where child.parent_id = (select id from category where category.name = 'Chân váy và đầm')

