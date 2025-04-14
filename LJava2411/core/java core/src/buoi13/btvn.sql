
/*
11. Tìm phòng ban có nhiều nhân viên nhất và tổng lương của phòng ban đó
12. Tìm nhân viên có mức lương cao nhất trong mỗi phòng ban
13. Tính mức lương trung bình của từng vị trí công việc, chỉ hiển thị các vị trí có lương trung bình lớn hơn 1500
14. Lấy danh sách nhân viên và đồng nghiệp cùng phòng ban (không bao gồm chính họ)
15. Tính tổng số năm kinh nghiệm của mỗi phòng ban
16. Tìm nhân viên được tuyển dụng sớm nhất trong mỗi phòng ban, bao gồm cả tên và ngày tuyển dụng
17. Tìm phòng ban có tổng lương lớn nhất và hiển thị tên nhân viên, lương và phòng ban đó
18. Phân nhóm nhân viên theo bậc lương (ví dụ: < 1500, 1500-2000, > 2000) và tính tổng số nhân viên trong từng nhóm/-strong/-heart:>:o:-((:-h Sử dụng CASE và GROUP BY:
19. Tìm nhân viên có tổng số lương cao nhất trong tất cả các phòng ban (bao gồm cả tên phòng ban)
20. Tìm tên nhân viên có lương cao hơn mức lương trung bình của phòng ban mà họ làm việc
 */

-- 11 Tìm phòng ban có nhiều nhân viên nhất và tổng lương của phòng ban đó
/*
 + max
 + sum
 */
use quanlynhansu;
-- tim ra phong ban co nhieu nhan vien nhat
select department_id,count(*) from employees group by department_id order by count(*) desc limit 1;
-- tim phong ban co nhieu nhan vuien nhat, tong luong phong ban do
select dept.department_name,sum(emp.salary) from employees emp inner join
                                                 departments dept on emp.department_id = dept.department_id
                                                               inner join (select department_id,count(*) from employees group by department_id order by count(*) desc limit 1) term
                                                                          on term.department_id = dept.department_id group by dept.department_name ;

-- 12 Tìm nhân viên có mức lương cao nhất trong mỗi phòng ban
select emp.name,emp.salary,dept.department_name from employees emp
                                                         inner join departments dept on emp.department_id = dept.department_id
where emp.salary = (select max(salary) from employees where employees.department_id = dept.department_id);

-- 13 Tính mức lương trung bình của từng vị trí công việc, chỉ hiển thị các vị trí có lương trung bình lớn hơn 1500
select distinct e.position,avg(e.salary) avg_salary_position from employees e group by e.position having avg_salary_position > 1500;

-- 14 Lấy danh sách nhân viên và đồng nghiệp cùng phòng ban (không bao gồm chính họ)
select distinct emp.name, dept.department_name
from departments dept
         inner join employees emp
                    on dept.department_id = emp.department_id
group by emp.name, dept.department_name;

-- 15 Tính tổng số năm kinh nghiệm của mỗi phòng ban

select emp.department_id,dept.department_name,sum(datediff(curdate(),emp.hire_date)/365) as total from employees emp
                                                                                                           inner join departments dept on emp.department_id = dept.department_id group by emp.department_id, dept.department_name;

select dept.department_name,max(year(curdate()) - year(emp.hire_date)) from employees emp
                                                                                inner join departments dept on emp.department_id = dept.department_id
group by dept.department_name;
-- 16 Tìm nhân viên được tuyển dụng sớm nhất trong mỗi phòng ban, bao gồm cả tên và ngày tuyển dụng
-- tim ra phong ban va ngay tuyen dung som nhat cua phong ban do
select dept.department_name,min(emp.hire_date) from employees emp
                                                        inner join departments dept on emp.department_id = dept.department_id group by dept.department_name;

select emp.name, dept.department_name, emp.hire_date
from employees emp
         inner join departments dept on emp.department_id = dept.department_id
         inner join (select dept.department_name, min(emp.hire_date) as min_hire_date
                     from employees emp
                              inner join departments dept on emp.department_id = dept.department_id
                     group by dept.department_name) dept_min_hire_date
                    on dept.department_name = dept_min_hire_date.department_name
where dept_min_hire_date.min_hire_date = emp.hire_date;

-- 17 Tìm phòng ban có tổng lương lớn nhất và hiển thị tên nhân viên, lương và phòng ban đó
-- tim phong ban co tong luong lon nhat
select dept.department_name,max(emp.salary) max_salary from employees emp
                                                                inner join departments dept on emp.department_id = dept.department_id group by dept.department_name order by max_salary desc limit 1;

select emp.name, dept.department_name, emp.salary
from employees emp
         inner join departments dept on emp.department_id = dept.department_id
         inner join (select dept.department_name, max(emp.salary) max_salary
                     from employees emp
                              inner join departments dept on emp.department_id = dept.department_id
                     group by dept.department_name
                     order by max_salary desc
                         limit 1) dept_max_salary on dept.department_name = dept_max_salary.department_name
where emp.salary = dept_max_salary.max_salary;

-- 18 Phân nhóm nhân viên theo bậc lương (ví dụ: < 1500, 1500-2000, > 2000) và tính tổng số nhân viên trong từng
/*
 case
    when condition1 then a
    when condition2 then b
    else c
 end
 chu thich:
    condition1: điều kien kiem tra voi if 1
    a: duoc thực thi khi condition1 = true
    condition2: dieu kien kiem tra voi if 2
    b: được thực thi khi condition2 = true
    c: được thực thi khi tất cả condition1 và condition2 = false
 */
select
    case
        when emp.salary > 2000 then 'level > 2000'
        when emp.salary between 1500 and 2000 then 'level between 1500 and 2000'
        else 'level < 1500'
        end as level,
    count(*) total_emp
from employees emp group by level;

-- 19 Tìm nhân viên có tổng số lương cao nhất trong tất cả các phòng ban (bao gồm cả tên phòng ban)
-- tim luong cao nhat
select max(salary) max_salary from employees;

select emp.name,emp.salary,dept.department_name from employees emp
                                                         inner join departments dept on emp.department_id = dept.department_id
where emp.salary = (select max(salary) max_salary from employees);

-- 20 Tìm tên nhân viên có lương cao hơn mức lương trung bình của phòng ban mà họ làm việc
-- muc luong trung binh cua cac phong ban
select dept.department_name,avg(emp.salary) from employees emp
                                                     inner join departments dept on emp.department_id = dept.department_id group by dept.department_name;

select emp.name, dept.department_name, emp.salary, dept_avg_salary.avg_salary
from employees emp
         inner join departments dept on emp.department_id = dept.department_id
         inner join (select dept.department_name, avg(emp.salary) avg_salary
                     from employees emp
                              inner join departments dept on emp.department_id = dept.department_id
                     group by dept.department_name) dept_avg_salary
                    on dept.department_name = dept_avg_salary.department_name
where emp.salary > dept_avg_salary.avg_salary;

