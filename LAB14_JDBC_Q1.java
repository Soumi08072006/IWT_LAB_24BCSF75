<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // SESSION CHECK: If no user is logged in, redirect to login page
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    String username = (String) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; line-height: 1.6; }
        .welcome-box { background: #e3f2fd; padding: 20px; border-radius: 8px; border-left: 5px solid #2196f3; }
        .menu-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(200px, 1fr)); gap: 20px; margin-top: 30px; }
        .card { border: 1px solid #ddd; padding: 20px; border-radius: 8px; text-align: center; text-decoration: none; color: #333; transition: 0.3s; }
        .card:hover { background: #f5f5f5; border-color: #2196f3; transform: translateY(-5px); }
        .card h3 { margin: 0; color: #2196f3; }
    </style>
</head>
<body>

    <%@ include file="nav.jsp" %>

    <div class="welcome-box">
        <h1>Welcome, <%= username %>!</h1>
        <p>You are now logged into the **Student Management System**. Use the links below to manage records.</p>
    </div>

    <div class="menu-grid">
        <a href="displayStudents.jsp" class="card">
            <h3>View Students</h3>
            <p>See all registered students and their details.</p>
        </a>

        <a href="ADD_STUDENT.jsp" class="card">
            <h3>Add Student</h3>
            <p>Register a new student into the system.</p>
        </a>

        <a href="logout.jsp" class="card" style="border-color: #ffcdd2;">
            <h3 style="color: #d32f2f;">Logout</h3>
            <p>Safely end your current session.</p>
        </a>
    </div>

</body>
</html>
