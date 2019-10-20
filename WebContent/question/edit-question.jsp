<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="question/edit" method="Put">
<table>
<tr>
<td>
New Question :
</td>
<td>
<input type="text" name="newQuestion" size="50px">
</td>
</tr>
<tr>
<td>
Options :</td>

</tr>
<tr>
<td>
Option 1</td>
<td>
<input type="option" name="option">
</td>

<td>
Option 2
</td>
<td>
<input type="option" name="option">
</td>
</tr>
<tr>

<td>
Option 3</td>
<td>
<input type="option" name="option">
</td>

<td>
Option 4</td>
<td>
<input type="option" name="option">
</td>
</tr>
<tr>
<td>
Correct Option :
<td>
<td>
<input type="radio" name="correct_answer" value="option 1">Option 1
</td>

<td>
<input type="radio" name="correct_answer" value="option 2">Option 2
</td>


<td>
<input type="radio" name="correct_answer" value="option 3">Option 3
</td>

<td>
<input type="radio" name="correct_answer" value="option ">Option 3
</td>
</tr>

<tr>
<td>
<input type="submit" value="Update" >
</td>
<td>
<input type="submit" value="Show old Question">
</td>
</tr>
</table>
</body>
</html>