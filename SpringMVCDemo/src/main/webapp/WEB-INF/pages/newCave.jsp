<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Cave </title>
</head>
<body>

	<p>Enter some new cave data</p>
	<!-- commandName tells us to go to /cave/create -->
	<form:form method="POST" action="create" commandName="cave">
		<table>
			<tr>
				<td><form:label path="id">ID: </form:label></td>
				<td><form:input path="id"/></td>
			</tr>
			<tr>
				<td><form:label path="name">Name: </form:label></td>
				<td><form:input path="name"/></td>
			</tr>
			<td colspan="2"><input type="submit" value="Create this cave"/></td>
		</table>
	</form:form>
	<br>
	<br>
	<p>You added the following cave: </p>
	<table>
		<tr>
			<td>Id: </td>
			<td>${caveId}</td>
		</tr>
		<tr>
			<td>Name: </td>
			<td>${caveName}</td>
		</tr>
	</table>

</body>
</html>