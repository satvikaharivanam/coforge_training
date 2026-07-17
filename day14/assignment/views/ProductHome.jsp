<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management System</title>
<link rel="stylesheet" href="EMSStyle.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<div class="header">
		<h1>Product Management System</h1>
	</div>
	<br />
	<form action = "product" method = "post">
	<div class="content">
		<table>
			<tr>
				<td>Product id</td>
				<td><input type="text" name ="pid"></td>
			</tr>

			<tr>
				<td>Product Name</td>
				<td><input type="text" name = "pname"></td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td><input type="text" name = "price"></td>
			</tr>

			<tr>
				<td>Product Quantity</td>
				<td><input type="text" name = "quantity"></td>
			</tr>
		</table>
		<br />
		<input type="submit" name="insert" value="Insert" class="btn btn-primary">
		<input type="submit" name = "findAll" value="FindAll" class="btn btn-info">
		<input type="submit" name = "find" value="Find" class="btn btn-info">
		<input type="submit" name ="update" value="Update"  class="btn btn-warning"> 
		<input type="submit" name="delete" value="Delete" class="btn btn-danger"> 
		
		

		<br/><br/>
		
	</div>
	</form>
	<br>
	<div>
		<b>${result}</b>
	</div>

</html>