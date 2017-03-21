<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有的页面</title>
</head>
<body>
	<center>
		<form action="saveStudent" method="post">
			<input type="text" name="stu.stuName"/><br/>
			<input type="text" name="stu.clsName"/><br/>
			<input type="submit" value="保存"/><br/>
		</form>
	</center>
</body>
</html>