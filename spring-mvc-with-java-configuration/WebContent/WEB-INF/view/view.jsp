<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
 <c:url value="/addStudent" var="addStudentURL" />
 <c:url value="/updateStudent" var="updateStudentURL" />
 <c:url value="/studentUpdate" var="studentUpdateURL" /> 
 <c:url value="/getStudents" var="getStudentsURL" />
 <c:url value="/deleteStudent" var="deleteStudentURL" />  

<html>
	<head>
	   <title>Student List</title>
	  	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    	<script src="<c:url value="/resources/js/jquery-1.11.2.min.js" />"></script>
    	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>	   
	</head>
	<body>
		<div style="width: 400px; margin:20px 0 0 50px;">

			<c:if test="${operation != 'UPDATE'}">
				<table class="table table-striped table-bordered">
					<caption>
						<strong>Student List</strong>
					</caption>
	
					<thead>
						<tr>
							<th><spring:message code="table.header.1" /></th>
							<th><spring:message code="table.header.2" /></th>
							<th><spring:message code="table.header.3" /></th>
							<th><spring:message code="table.header.4" /></th>
						</tr>
					</thead>
	
					<tbody>
						<c:forEach var="student" items="${studentList}">
							<tr>
								<td><a href='${updateStudentURL}/${student.studentId}'>${student.studentId}</a></td>
								<td><a href='${updateStudentURL}/${student.studentId}'>${student.studentName}</a></td>
								<td>${student.studentAge}</td>
								<td><a href='${deleteStudentURL}/${student.studentId}' class="btn btn-danger">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
	
				<!-- Button trigger modal -->
				<button class="btn btn-primary btn-lg" data-toggle="modal"
					data-target="#myModal">Add Student</button>
	
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
	
					<div class="modal-dialog">
						<div class="modal-content">
	
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
	
								<h4 class="modal-title" id="myModalLabel">Add Student</h4>
							</div>
							<form:form action="${addStudentURL}" commandName="student"
								method="POST" id="add-student-form">
								<div class="modal-body">
									<table class="table table-striped table-bordered">
										<tr>
											<td><form:label path="studentName">Student Name</form:label>
												<form:input path="studentName" />
											</td>
										</tr>
										<tr>
											<td><form:label path="studentAge">Student Age</form:label>
												<form:input path="studentAge" />
											</td>
										</tr>
									</table>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
	
									<button type="button" class="btn btn-primary btn-form-submit">
										Submit</button>
								</div>
							</form:form>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
	
				</div>
				<!-- /.modal -->
			</c:if>
			<c:if test="${operation == 'UPDATE'}">
				<form:form action="${studentUpdateURL}" commandName="student" method="POST">
					<div class="modal-body">
						<table class="table table-striped table-bordered">
							<tr>
								<td><form:label path="studentId">Student Id</form:label>
									<form:input path="studentId" />
								</td>
							</tr>
							<tr>
								<td><form:label path="studentName">Student Name</form:label>
									<form:input path="studentName" />
								</td>
							</tr>
							<tr>
								<td>
									<form:label path="studentAge">Student Age</form:label>
								    <form:input path="studentAge" />
								 </td>
							</tr>
						</table>
					</div>				
					<button type = "button" class = 'btn btn-default back-url'>  Close  </button>
					<input type="submit" class="btn btn-primary" value="Update">
				</form:form>
			</c:if>
		</div>			
	</body>
	<script type="text/javascript">
	
	$(document).ready(function(){
		$('.btn-form-submit').on('click',function(){
			$('#add-student-form').submit();
		});
		
		$('.back-url').on('click',function(){
				window.history.back();			;
		});
		
	})
		
	</script>
</html>
