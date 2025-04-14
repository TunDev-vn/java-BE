<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<div class="container my-4">
    <div style="float: right">
        <a href="${applicationScope.baseUrl}/logout">Đăng xuất</a>
    </div>
    <h1 class="text-center mb-4">Manager Employee</h1>

    <!-- Form tìm kiếm với các trường hiển thị ngang -->
    <form class="row g-3" action="employees" method="get">
        <div class="col-md-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" id="name" name="name" class="form-control" value="${param.name}" placeholder="Search by Name">
        </div>

        <div class="col-md-3">
            <label for="salary" class="form-label">Salary</label>
            <input type="text" id="salary" name="salary" class="form-control" value="${param.salary}" placeholder="Search by Salary">
        </div>

        <div class="col-md-3">
            <label for="fromDate" class="form-label">From Hire Date</label>
            <input type="date" id="fromDate" name="fromDate" class="form-control" value="${param.fromDate}">
        </div>

        <div class="col-md-3">
            <label for="toDate" class="form-label">To Hire Date</label>
            <input type="date" id="toDate" name="toDate" class="form-control" value="${param.toDate}">
        </div>

        <div class="col-md-3">
            <label for="position" class="form-label">Position</label>
            <input type="text" id="position" name="position" class="form-control" value="${param.position}" placeholder="Search by Position">
        </div>
        <br>
        <div class="col-md-3 d-flex align-items-end">
            <button type="submit" class="btn btn-primary me-2">
                <i class="fas fa-search"></i> Search
            </button>
        </div>
    </form>
    <!-- Button thêm mới -->
    <div class="mt-3">
        <form action="/cms/action-employee" method="get">
            <button type="submit" class="btn btn-success">
                <i class="fas fa-plus"></i> Add New
            </button>
        </form>
    </div>

    <!-- Bảng danh sách nhân viên -->
    <table class="table table-bordered table-hover mt-4">
        <thead class="table-dark">
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Position</th>
            <th>Salary</th>
            <th>Department</th>
            <th>Hire Date</th>
            <th width="20%">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employeeModel" items="${employeeModels}">
            <tr>
                <td>${employeeModel.employeeId}</td>
                <td>${employeeModel.name}</td>
                <td>${employeeModel.position}</td>
                <td>${employeeModel.salary}</td>
                <td>${employeeModel.departmentName}</td>
                <td>${employeeModel.hireDate}</td>
                <td>
                    <a href="/cms/action-employee?id=${employeeModel.employeeId}" class="btn btn-warning btn-sm">
                        <i class="fas fa-edit"></i>
                    </a>
                    <form action="/cms/action-employee?id=${employeeModel.employeeId}&deleted=true" method="post">
                        <button type="submit" class="btn btn-danger">
                            <i class="fas fa-trash-alt"></i>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
