<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
                <div align="left"><a href="getAllEmployees"> <b>Employees List</b> </a></div>
                <div align="right"><a href="createEmployee">Add New Employee</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <c:if test="${empty employeeList}">
                There are no Employees
            </c:if>
            <c:if test="${not empty employeeList}">

                <form action="searchEmployee">
                    <div class="col-xs-8">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="col-md-6">Search Employee by Name:</div>
                                <div class="col-md-6"><input type="text" name="searchName" id="searchName"></div>
                            </div>
                            <div class="col-md-4"><input class="btn btn-success" type='submit' value='Search'/></div>
                            <div class="col-md-4"></div>
                            <br>
                        </div>
                    </div>
                </form>

                <form action="searchEmployeeByAge">
                    <div class="col-xs-8">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="col-md-6">Search Employee by Age:</div>
                                <div class="col-md-6"><input type="number" min="1" step="1" name="searchAge"
                                                             id="searchAge"></div>
                            </div>
                            <div class="col-md-4"><input class="btn btn-success" type='submit' value='Search'/></div>
                            <div class="col-md-4"></div>
                        </div>
                    </div>
                </form>

                <form action="searchEmployeeByIsAdmin">
                    <div class="col-xs-8">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="col-md-6">Search Employee by IsAdmin:</div>
                                <div class="col-md-6"><input type="checkbox" name="searchIsAdmin" id="searchIsAdmin">
                                </div>
                            </div>
                            <div class="col-md-4"><input class="btn btn-success" type='submit' value='Search'/></div>
                            <div class="col-md-4"></div>
                        </div>
                    </div>
                </form>

                <form align="right">
                    <div id="pagination">
                        <c:url value="/" var="prev">
                            <c:param name="page" value="${page-1}"/>
                        </c:url>
                        <c:if test="${page > 1}">
                            <a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
                        </c:if>
                        <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
                            <c:choose>
                                <c:when test="${page == i.index}">
                                    <span>${i.index}</span>
                                </c:when>
                                <c:otherwise>
                                    <c:url value="/" var="url">
                                        <c:param name="page" value="${i.index}"/>
                                    </c:url>
                                    <a href='<c:out value="${url}" />'>${i.index}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:url value="/" var="next">
                            <c:param name="page" value="${page + 1}"/>
                        </c:url>
                        <c:if test="${page + 1 <= maxPages}">
                            <a href='<c:out value="${next}" />' class="pn next">Next</a>
                        </c:if>
                    </div>
                </form>


                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>Name</th>
                        <th>Age</th>
                        <th style="text-align: center;">IsAdmin</th>
                        <th>CreatedDate</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employeeList}" var="emp">
                        <tr>
                            <th><c:out value="${emp.name}"/></th>
                            <th><c:out value="${emp.age}"/></th>
                            <td style="text-align: center; vertical-align: middle;">
                                <input type="hidden" name="_isAdmin"/>
                                <input type="checkbox" disabled name="isAdmin" value="true"
                                       <c:if test="${emp.admin}">checked</c:if>/>
                            </td>
                            <th><c:out value="${emp.createdDate}"/></th>
                            <th><a href="editEmployee?id=<c:out value='${emp.id}'/>">Edit</a></th>
                            <th><a href="deleteEmployee?id=<c:out value='${emp.id}'/>">Delete</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </c:if>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>