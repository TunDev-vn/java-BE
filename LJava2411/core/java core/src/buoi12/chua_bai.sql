
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

SELECT  distinct  e1.name AS employee1, e1.salary
FROM employees e1
         INNER JOIN employees e2
                    ON e1.salary = e2.salary AND e1.employee_id != e2.employee_id;

SELECT e.name, e.salary, d.department_name
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id
         inner join (
    SELECT MAX(salary) as salary, department_id
    FROM employees
    GROUP BY department_id
) term on term.department_id = d.department_id and e.salary = term.salary;

-- 14
select emp.name,emp_colleague.name,dept.department_name from employees emp
                                                                 inner join departments dept on emp.department_id = dept.department_id
                                                                 inner join employees emp_colleague on emp_colleague.department_id = dept.department_id and emp_colleague.employee_id != emp.employee_id;

-- 15 DATEDIFF tính số năm giữa 2 ngày
SELECT d.department_name, SUM(YEAR(CURDATE()) - YEAR(e.hire_date)) AS total_experience
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name;

-- index, partition
-- param condition
/*
1. GROUP BY:
Tính tổng lương của mỗi phòng ban:
2. HAVING:
Lọc các phòng ban có tổng lương lớn hơn 3000:
3. DISTINCT:
Lấy danh sách vị trí công việc duy nhất:
4. LIMIT & OFFSET:
Lấy 3 nhân viên đầu tiên, bỏ qua 2 nhân viên đầu tiên:
5. LIKE:
Tìm nhân viên có tên chứa “Nguyễn”:
6. SUM và AVG:
Tính tổng và trung bình lương của toàn bộ nhân viên:
7. INNER JOIN:
Lấy danh sách nhân viên và tên phòng ban của họ:
8. LEFT JOIN:
Lấy danh sách tất cả phòng ban và nhân viên của phòng ban đó (nếu có):
9. RIGHT JOIN:
Lấy danh sách tất cả nhân viên và thông tin phòng ban của họ (nếu có):
10. SELF JOIN:
Tìm các nhân viên có cùng mức lương
*/
-- c1
select d.department_name,sum(emp.salary) from employees emp
                                                  inner join departments d on emp.department_id = d.department_id
group by emp.department_id;
-- c2: Lọc các phòng ban có tổng lương lớn hơn 3000:
select d.department_name,sum(emp.salary) total_salary from employees emp
                                                               inner join departments d on emp.department_id = d.department_id
group by emp.department_id having total_salary > 3000;
-- c3: Lấy danh sách vị trí công việc duy nhất:
select distinct employees.position from employees;
-- c4 Lấy 3 nhân viên đầu tiên, bỏ qua 2 nhân viên đầu tiên,
/*
 offset: bắt đầu tu index nao
 limit: gioi han bao nhieu ban ghi
 */
select * from employees limit 3 offset 2;
-- c5 Tìm nhân viên có tên chứa “Nguyễn”:
select * from employees where name like '%Nguyễn%';
-- c6 Tính tổng và trung bình lương của toàn bộ nhân viên
/*
sum: tính tổng
avg: tính trung bình
 */
select sum(employees.salary) total_salary,avg(employees.salary) from employees;
-- c7 Lấy danh sách nhân viên và tên phòng ban của họ
select emp.name,dept.department_name from employees emp
                                              inner join departments dept on emp.department_id = dept.department_id;

-- c8 Lấy danh sách tất cả phòng ban và nhân viên của phòng ban đó (nếu có):
select dept.department_name,emp.name from departments dept left join employees emp
                                                                     on dept.department_id = emp.department_id;

-- 10 Tìm các nhân viên có cùng mức lương
select distinct emp.salary,emp.name from employees emp
                                             inner join employees emp_same_salary on emp.salary = emp_same_salary.salary
    and emp_same_salary.employee_id != emp.employee_id;

-- 11 Tìm phòng ban có nhiều nhân viên nhất và tổng lương của phòng ban đó
select dept.department_name,count(emp.employee_id),sum(emp.salary)
from departments dept
         inner join employees emp on dept.department_id = emp.department_id
group by dept.department_name order by count(emp.employee_id) desc limit 1;