
create DATABASE quanlynhansu;
use quanlynhansu;
CREATE TABLE departments (
                             department_id INT PRIMARY KEY,
                             department_name VARCHAR(100) NOT NULL,
                             location VARCHAR(100) NOT NULL
);

INSERT INTO departments (department_id, department_name, location)
VALUES
    (1, 'IT', 'Hà Nội'),
    (2, 'HR', 'TP. Hồ Chí Minh'),
    (3, 'Finance', 'Đà Nẵng');

CREATE TABLE employees (
                           employee_id INT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           position VARCHAR(50) NOT NULL,
                           salary DECIMAL(10, 2) NOT NULL,
                           department_id INT,
                           hire_date DATE NOT NULL,
                           FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

INSERT INTO employees (employee_id, name, position, salary, department_id, hire_date)
VALUES
    (1, 'Nguyễn Văn A', 'Developer', 1500, 1, '2020-05-01'),
    (2, 'Trần Thị B', 'Tester', 1200, 1, '2021-03-15'),
    (3, 'Lê Văn C', 'Developer', 1500, 2, '2019-08-10'),
    (4, 'Nguyễn Thị D', 'Project Manager', 2500, 2, '2020-01-20'),
    (5, 'Phạm Văn E', 'Tester', 1300, 3, '2021-07-12'),
    (6, 'Hoàng Thị F', 'Developer', 1400, 3, '2022-09-01'),
    (7, 'Đặng Văn G', 'Developer', 1500, 1, '2022-05-20'),
    (8, 'Nguyễn Văn H', 'Developer', 2000, 2, '2018-12-15');


/*
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

--  12. Tìm nhân viên có mức lương cao nhất trong mỗi phòng ban
/*
 - tìm danh sách nhân viên có phòng ban , tên nhân viên, lương, phòng ban
 - nhóm lại theo mã phòng ban
 - lấy max lương
 */
SELECT dept.department_name dept_name, MAX(salary) max_salary
FROM employees emp
         INNER JOIN departments dept ON emp.department_id = dept.department_id
GROUP BY dept.department_name;

select emp.name,dept.department_name,emp.salary from employees emp
                                                         inner join departments dept on emp.department_id = dept.department_id
                                                         inner join (SELECT dept.department_name dept_name, MAX(salary) max_salary
                                                                     FROM employees emp
                                                                              INNER JOIN departments dept ON emp.department_id = dept.department_id
                                                                     GROUP BY dept.department_name) dept_max_salary on emp.salary = dept_max_salary.max_salary and dept.department_name = dept_max_salary.dept_name;

-- 13 Tính mức lương trung bình của từng vị trí công việc, chỉ hiển thị các vị trí có lương trung bình lớn hơn 1500
/*
 - agv
 - having
 - group by position
 */
select position,avg(emp.salary) from employees emp
group by position having avg(emp.salary) > 1500;

-- 14 Lấy danh sách nhân viên và đồng nghiệp cùng phòng ban (không bao gồm chính họ)
/*
 - đồng nghiep
 */


SELECT e1.name AS employee, e2.name AS colleague, d.department_name
FROM employees e1
         INNER JOIN employees e2 ON e1.department_id = e2.department_id AND e1.employee_id != e2.employee_id
         INNER JOIN departments d ON e1.department_id = d.department_id
ORDER BY e1.name;

select emp.name, emp2.name,d.department_name from employees emp
                                                      inner join employees emp2 on emp.department_id = emp2.department_id and emp.employee_id != emp2.employee_id
inner join departments d on emp.department_id = d.department_id;

-- 15 Tính tổng số năm kinh nghiệm của mỗi phòng ban
/*
 group by
 + tìm danh sách nhân vien cua các phong ban
 + tìm max hire_date den now
 */
select dept.department_name,max(year(curdate()) - year(emp.hire_date)) from employees emp
                                                                                inner join departments dept on emp.department_id = dept.department_id
group by dept.department_name;

-- 6. Tìm nhân viên được tuyển dụng sớm nhất trong mỗi phòng ban, bao gồm cả tên và ngày tuyển dụng
/*
 som nhat: min(hire_date)
 */
select dept.department_name,min(emp.hire_date)from employees emp
                                                       inner join departments dept on emp.department_id = dept.department_id
group by dept.department_name;

select emp.hire_date, emp.name, term.department_name
from employees emp
         inner join departments d on emp.department_id = d.department_id
         inner join (select min(emp.hire_date) hire_date, dept.department_name
                     from employees emp
                              inner join departments dept on emp.department_id = dept.department_id
                     group by dept.department_name) term
                    on d.department_name = term.department_name and emp.hire_date = term.hire_date;

-- 7  Tìm phòng ban có tổng lương lớn nhất và hiển thị tên nhân viên, lương và phòng ban đó
/*
 sum
 */
select d.department_id,sum(emp.salary) total_salary from employees emp
                                                             inner join departments d on emp.department_id = d.department_id
group by d.department_id order by total_salary desc limit 1;

select emp.name,emp.salary,d2.department_name
from employees emp
         inner join departments d2 on emp.department_id = d2.department_id
where emp.department_id = (select d.department_id
                           from employees emp
                                    inner join departments d on emp.department_id = d.department_id
                           group by d.department_id
                           order by sum(emp.salary) desc
    limit 1);

-- 7 Phân nhóm nhân viên theo bậc lương (ví dụ: < 1500, 1500-2000, > 2000) và tính tổng số nhân viên trong từng nhóm
/*
syntax
case
    when condition
    then login_if_true
    else logic_if_false
end
 */
select
    case
        when emp.salary > 2000 then 'level_1'
        when emp.salary between 1500 and 2000 then 'level_2'
        else 'level_3'
        end as level,
    count(*) total_emp
from employees emp group by level;

-- 9 Tìm nhân viên có tổng số lương cao nhất trong tất cả các phòng ban (bao gồm cả tên phòng ban)
select max(employees.salary) max_salary from employees;

select emp.name,emp.salary,d.department_name from employees emp
                                                      inner join departments d on emp.department_id = d.department_id
where emp.salary = (select max(employees.salary) max_salary from employees);

SELECT e.name, SUM(e.salary) AS total_salary, d.department_name
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id
GROUP BY e.name, d.department_name
ORDER BY total_salary DESC
    LIMIT 1;

-- 10 Tìm tên nhân viên có lương cao hơn mức lương trung bình của phòng ban mà họ làm việc
select d.department_id,avg(emp.salary) avg_salary from employees emp
                                                           inner join departments d on emp.department_id = d.department_id
group by d.department_id;

select emp.salary,emp.name,emp.department_id
from employees emp
         inner join
     (select d.department_id, avg(emp.salary) avg_salary
      from employees emp
               inner join departments d on emp.department_id = d.department_id
      group by d.department_id) term on emp.department_id = term.department_id
where emp.salary > term.avg_salary;