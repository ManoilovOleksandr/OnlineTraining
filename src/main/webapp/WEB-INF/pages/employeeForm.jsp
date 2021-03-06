<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="cypher">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Information</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                Employee Details
            </h3>
        </div>
        <div class="panel-body">
            <form:form id="employeeRegisterForm" cssClass="form-horizontal" modelAttribute="employee" method="post"
                       action="saveEmployee">

                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="name">Name</form:label></div>
                    <div class="col-xs-6">
                        <form:hidden path="id" value="${employeeObject.id}"/>
                        <form:input cssClass="form-control" path="name" value="${employeeObject.name}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="age">Age</form:label></div>
                    <div class="col-xs-6">
                        <form:input type="number" min="18" max="60" step="1" cssClass="form-control" path="age" value="${employeeObject.age}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="admin">IsAdmin</form:label></div>
                    <div class="col-xs-6">
                        <input type="hidden" name="_admin"/>
                        <input type="checkbox" path="admin" name="admin"
                               <c:if test="${employeeObject.admin}">checked</c:if>/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-xs-7"> </div>
                        <div class="col-xs-4"><input type="submit" id="saveEmployee" class="btn btn-primary" value="Save" onclick="return submitEmployeeForm();"/>
                            <input type="button" class="btn btn-primary" value="Cancel" onclick='location.href="getAllEmployees"'/>
                        </div>
                        <div class="col-xs-2"></div>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
    function submitEmployeeForm() {
        // getting the employee form values
        var name = $('#name').val().trim();
        var age = $('#age').val();
        if (name.length == 0 || name.length >25) {
            alert('Please enter name');
            $('#name').focus();
            return false;
        }
        if (age <= 0 || age >200 || !isFinite(age)) {
            alert('Please enter proper age');
            $('#age').focus();
            return false;
        }
        return true;
    };
</script>
</body>
</html>