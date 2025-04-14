<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">

        <c:if test="${empty model.employeeId}">
            <h2 class="mb-4 text-center">Add New Employee</h2>
        </c:if>
        <c:if test="${not empty model.employeeId}">
            <h2 class="mb-4 text-center">Edit Employee</h2>
        </c:if>
        <form action="/cms/action-employee" method="POST" enctype="multipart/form-data">
            <input type="text" class="form-control" id="employeeId" name="employeeId" hidden
                   value="${model.employeeId}">

            <!-- Avatar Section -->
            <div class="mb-3 text-center">
                <label for="avatar" class="form-label">Employee Avatar</label>
                <!-- Hiển thị ảnh đại diện nếu có, nếu không sẽ hiển thị ảnh mặc định -->
                <c:if test="${not empty model.avatarUrl}">
                    <img src="${model.avatarUrl}" alt="Employee Avatar" class="img-fluid rounded-circle" style="width: 150px; height: 150px;">
                </c:if>
                <c:if test="${empty model.avatarUrl}">
                    <img src="default-avatar.jpg" alt="Default Avatar" class="img-fluid rounded-circle" style="width: 150px; height: 150px;">
                </c:if>

                <!-- Input file để thay đổi ảnh đại diện -->
                <input type="file" class="form-control mt-2" id="avatar" name="avatar" accept="image/*">
            </div>

            <!-- Name -->
            <div class="mb-3">
                <label for="name" class="form-label">Full Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter employee name"
                       value="${model.name}" required>
            </div>

            <!-- Position -->
            <div class="mb-3">
                <label for="position" class="form-label">Position</label>
                <input type="text" class="form-control" id="position" name="position" placeholder="Enter position"
                       value="${model.position}" required>
            </div>

            <!-- Salary -->
            <div class="mb-3">
                <label for="salary" class="form-label">Salary</label>
                <input type="number" class="form-control" id="salary" name="salary" placeholder="Enter salary"
                       value="${model.salary}" required>
            </div>

            <!-- Email -->
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter email"
                       value="${model.email}" required>
            </div>

            <!-- Contact Number -->
            <div class="mb-3">
                <label for="contactNumber" class="form-label">Contact Number</label>
                <input type="text" class="form-control" id="contactNumber" name="contactNumber" placeholder="Enter contact number"
                       value="${model.contactNumber}" required>
            </div>

            <!-- Department -->
            <div class="mb-3">
                <label for="department" class="form-label">Department</label>
                <input type="text" class="form-control" id="department" name="department" placeholder="Enter department"
                       value="${model.department}" required>
            </div>

            <!-- Submit Button -->
            <div class="mb-3 text-center">
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
