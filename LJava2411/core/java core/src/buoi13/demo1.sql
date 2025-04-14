create database quanlynhansu2;
use quanlynhansu2;
create table nhan_vien(
                          id integer auto_increment primary key ,
                          ma_nhan_vien varchar(30),
                          ho_ten nvarchar(100),
                          ngay_sinh DATE,
                          dia_chi nvarchar(200),
                          chuc_vu nvarchar(50)
);

create table phong_ban(
                          id integer auto_increment primary key,
                          ma_phong_ban varchar(30),
                          ten_phong_ban nvarchar(50)
);

create table du_an(
                      id integer auto_increment primary key ,
                      ma_du_an nvarchar(30),
                      ten_du_an nvarchar(100)
);
/*
 nhan vien - phong ban (  n - 1 )
 -> trong bảng nhân viên thêm cot department_id
 đóng vai trò la khóa ngoại tham chieu tu bảng
 nhan vien -> phong ban
 */
-- tao them colum department_id
alter table nhan_vien
    add column department_id integer;
-- config khoa ngoai cho department_id
alter table nhan_vien
    add foreign key (department_id) references phong_ban(id);

/*
 phong ban - du an ( n - 1 )
tương tu như nhan vien - phong ban
 */
-- tao them colum department_id
alter table du_an
    add column department_id integer;
-- config khoa ngoai cho department_id
alter table du_an
    add foreign key (department_id) references phong_ban(id);
/*
 nhan vien - du an ( n - n )
 -) 1 nhân viên có thể làm nhiều dự án
 -) 1 dự án có the duoc lam boi nhieu nhan vien

để thể hiện được mối quan hệ n - n
 sẽ tạo thêm bảng phụ tên nhan_vien_du_an với mối quan
 hệ
 nhan_vien_du_an - nhân viên ( n - 1)
 nhan_vien_du_an - dự án ( n - 1)
bảng nhan_vien_du_an sẽ có hai cột
 nhan_vien_id: khóa ngoại tham chiếu tới bảng nhân viên
 du_an_id: khóa ngoại tham chiếu tới bảng dự án
 */
create table nhan_vien_du_an(
                                nhan_vien_id integer,
                                du_an_id integer
);
alter table nhan_vien_du_an
    add foreign key (nhan_vien_id) references nhan_vien(id);
alter table nhan_vien_du_an
    add foreign key (du_an_id) references du_an(id);