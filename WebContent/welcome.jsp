<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="elements/header.jsp"></jsp:include>
	<%
		String name = session.getAttribute("name") != null ? session.getAttribute("name").toString() : null;
		out.println("Welcome " + name);
	%>
<a href="/Question-Generation-System/logout">LogOut</a>
<a href="/Question-Generation-System/question/create">Add Question</a>
<jsp:include page="elements/footer.jsp"></jsp:include>