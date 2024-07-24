<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <style>
   		 body {
			 background-color:#FFFFFF!important;
				}
		table.table-bordered > thead > tr > th,
	    table.table-bordered > tbody > tr > td {
	        border: 2px solid #2E4053 ; /* Change border color here */
	    }
       
        .content {
            padding: 20px;
        }
        .main-content {
            margin: 0 auto; 
            max-width: 1000px; 
        }
        footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            background-color:#0096FF ;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
    </style>
</head>
<body>
	<header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #0096FF ">
            <div>
                <a href="https://www.javaguides.net" class="navbar-brand"> Contact US </a>
            </div>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/" class="nav-link">All Concerns</a></li>
            </ul>
        </nav>
    </header>
    
    <div class="container-fluid">
        <div class="row">
            
            <div class="col-md-10">
                <div class="content">
                    <!-- Main content wrapper -->
                    <div class="main-content">
                        <!-- Main content here -->
                        <div class="container">
                            <h3 class="text-center">Concerns</h3>
                            <hr>
                            <div class="container text-left">
                              <a href="<%=request.getContextPath()%>/newEmployee" class="btn btn-success" style="background-color: #17202A ; border-color: #007bff;">Contact US</a>

                            </div>
                            <br>
                            
                            <div class="table-responsive text-center">
                                <table class="table table-bordered d-inline-block table-right">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Date</th>
                                            <th>Address</th>
                                            <th>Email</th>
                                            <th>Phone</th>
                                            <th>Message</th>
                                             <th>Actions</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="Employee" items = "${listEmployees}">
                                            <tr>
                                                <td><c:out value="${Employee.id}" /></td>
                                                <td><c:out value="${Employee.name}" /></td>
                                                <td><c:out value="${Employee.birthdate}" /></td>
                                                 <td><c:out value="${Employee.address}" /></td>
                                                  <td><c:out value="${Employee.gender}" /></td>
                                                <td><c:out value="${Employee.phone}" /></td>
                                                <td><c:out value="${Employee.position}" /></td>
                                                
                                                <td>
												    <a href="<%=request.getContextPath()%>/editEmployee?id=<c:out value='${Employee.id}' />" class="btn btn-primary"style="background-color: #008080 ; border-color: #007bff";>Edit</a>
												    <a href="#" onclick="confirmDelete('<c:out value='${Employee.id}' />')" class="btn btn-danger">Delete</a>
												</td>

                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <footer>
        <!-- Footer content here -->
        <p>&copy; 2024 Contact Us</p>
    </footer>
    
    <script>
    function confirmDelete(id) {
        if (confirm("Are you sure you want to delete?")) {
            window.location.href = "<%=request.getContextPath()%>/deleteEmployee?id=" + id;
        }
    }
</script>
    
    
</body>
</body>
</html>