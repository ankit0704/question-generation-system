<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Question</title>
</head>
<body>
<form action="/Question-Generation-System/question/create" method="Post">
<table>
<tr>
<td>
Question :
</td>
<td>
<input type="text" name="question" size="50">
</td>
</tr>
<tr>
<td>
Question Type :
</td>
<td>
<select name="questiontype">
<option value="mcq">MCQ</option>
<option value="subjectvie">Subjective</option>
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
<input type="radio" name="correct_option" value="option 1">Option 1
</td>

<td>
<input type="radio" name="correct_option" value="option 2">Option 2
</td>


<td>
<input type="radio" name="correct_option" value="option 3">Option 3
</td>

<td>
<input type="radio" name="correct_option" value="option ">Option 3
</td>
</tr>

<tr>
<td>
<style>
.button {
  border-radius: 50px;
  background-color: red;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 20px;
  padding: 10px;
  width: 190px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
<button class="button"><span>Submit</span></button>
</td>
</form>
</body> 
</html>									 
