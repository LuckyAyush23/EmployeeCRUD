<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="emp" action="save" method="post">
<form:label path="name">Name</form:label>
<form:input path="name"/>
<form:label path="phone">Phone</form:label>
<form:input path="phone"/>
<form:label path="email">Email</form:label>
<form:input path="email"/>
<form:label path="gender">Gender :</form:label>
Male :<form:radiobutton path="gender" value="male"/>
Female :<form:radiobutton path="gender" value="female"/>
<form:label path="desg">Designation</form:label>
<form:input path="desg"/>
<form:label path="salary">Salary</form:label>
<form:input path="salary"/>
<form:label path="password">Password</form:label>
<form:password path="password"/>
<form:button>Submit</form:button>
</form:form>
</body>
</html>