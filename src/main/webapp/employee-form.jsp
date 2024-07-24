<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
<style>
    body {
        background-color: #FFFFFF !important;
    }
    
    .card-body {
        background-color: #F0FFFF;
        padding: 20px;
    }
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #0096FF">
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/" class="nav-link">Contact US</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${Employee != null}">
                <form id="employeeForm" action="updateEmployee" method="post" onsubmit="return validateForm()">
            </c:if>
            <c:if test="${Employee == null}">
                <form id="employeeForm" action="insertEmployee" method="post" onsubmit="return validateForm()">
            </c:if>

            <caption>
                <h2>
                    <c:if test="${Employee != null}">
                        Edit Employee
                    </c:if>
                    <c:if test="${Employee == null}">
                        Contact Us Form
                    </c:if>
                </h2>
            </caption>

            <c:if test="${Employee != null}">
                <input type="hidden" name="id" value="<c:out value='${Employee.id}' />" />
            </c:if>

            <fieldset class="form-group">
                <label>Name</label> 
                <input type="text" value="<c:out value='${Employee.name}' />" class="form-control" name="name" id="name" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>Date</label> 
                <input type="date" value="<c:out value='${Employee.birthdate}' />" class="form-control" name="birthdate" id="birthdate" required="required">
            </fieldset>
            <fieldset class="form-group">
                <label>Address</label> 
                <input type="text" value="<c:out value='${Employee.address}' />" class="form-control" name="address" id="address" required="required">
            </fieldset>
            <fieldset class="form-group">
                <label>Email</label> 
                <input type="email" value="<c:out value='${Employee.gender}' />" class="form-control" name="gender" id="gender" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>Contact no</label> 
                <input type="number" value="<c:out value='${Employee.phone}' />" class="form-control" name="phone" id="phone" required="required" step="1">
            </fieldset>

            <fieldset class="form-group">
                <label>Message</label> 
                <input type="text" value="<c:out value='${Employee.position}' />" class="form-control" name="position" id="position" required="required">
            </fieldset>

            <button type="submit" class="btn btn-success" style="background-color: #17202A; border-color: #007bff;">Save</button>
            </form>
        </div>
    </div>
</div>
<footer>
    <!-- Footer content here -->
    <p>&copy; 2024 Staff Management</p>
</footer>

<script>
    function validateForm() {
        const email = document.getElementById('gender').value;
        const birthdate = document.getElementById('birthdate').value;
        const currentDate = new Date().toISOString().split('T')[0];

        if (!email.includes('@')) {
            alert('Please enter a valid email address.');
            return false;
        }

        if (birthdate < currentDate) {
            alert('The Date is invalid.');
            return false;
        }

        return true;
    }
</script>

</body>
</html>
