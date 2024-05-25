<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>View ToDo Item List</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>

</head>
<body>

<div class="container">

    <h1 class="p-3"> ToDo Item List</h1>

    <form:form>

        <table class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Date</th>
                <th>Status</th>
                <th>Mark Completed</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="donner" items="${list}">
                <tr>
                    <td>${donner.id}</td>
                    <td>${donner.firstName}</td>
                    <td>${donner.lastName}</td>
                    <td>${donner.phoneNumber}</td>
                    <td>${donner.bloodGroup}</td>
                    <td>${donner.permanentAddress}</td>
                    <td>${donner.status}</td>
                    <td><button type="button" class="btn btn-success">
                        <a href="/updateToDoStatus/${donner.id}">Mark Complete</a>
                    </button></td>
                    <td><button type="button" class="btn btn-primary">
                        <a href="/editToDoItem/${donner.id}">Edit</a>
                    </button></td>
                    <td><button type="button" class="btn btn-danger">
                        <a href="/deleteToDoItem/${donner.id}">Delete</a>
                    </button></td>
                </tr>

            </c:forEach>

        </table>

    </form:form>

    <button type="button" class="btn btn-primary btn-block">
        <a href="/addToDoItem">Add New ToDo Item</a>
    </button>

</div>


</body>

</html>