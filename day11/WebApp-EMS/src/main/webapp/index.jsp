<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<link href="EMSStyle.css" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src = "./AjaxScript.js"></script>
</head>
<body>
	<div class="Header">
		<h1>Employee Management System</h1>
	</div>
	<br>
	<form action = "EmployeeController" method = "POST">
	<div class="Content">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name = "eid" onblur = "getEmployeeDetails()" id = "eid"/></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name = "ename" id = "ename"/></td>
			</tr>
			<tr>
				<td>Employee Salary</td>
				<td><input type="text" name = "esalary" id="esalary"/></td>
			</tr>
			<tr>
				<td>Department Number</td>
				<td><input type="text" name = "dno" id ="dno"/></td>
			</tr>
		</table>
		<br>
		<input type="Submit", value = "Insert" class = "btn-primary" name = "EMSButton"/>
		<input type="Submit", value = "Delete" class = "btn-danger" name = "EMSButton"/>
		<input type="Submit", value = "Update" class = "btn-warning" name = "EMSButton"/>
		<input type="Submit", value = "Find" class = "btn-success" name = "EMSButton"/>
		<input type="Submit", value = "FindAll" class = "btn-info" name = "EMSButton"/>
		<br>
	</div>
	</form>
	<div class="alert alert-primary">
	<font align = "center"><b><%=request.getParameter("result") %></b></font>
	</div>
</body>
</html>