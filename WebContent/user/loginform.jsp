<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8888/UserRegistration/register"
		method="POST">
		<table>
			<tr>
				<td>Enter Your Name :</td>
				<td><input type="test" name="name"></td>
			</tr>
			<tr>
				<td>Enter Employee ID :</td>
				<td><input type="text" name="eid"></td>
			</tr>
			<tr>
				<td>Enter Salary :</td>
				<td><input type="number" name="salary">
					<button>submit</button></td>
			</tr>
		</table>
</body>
</html>