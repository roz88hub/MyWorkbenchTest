<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
<form action ="connect" method ="post">
	<label class="control-label">Database Name</label>
                    <input maxlength="200" type="text" required="required" class="form-control" placeholder="Enter Database"  name="dbName"/>
                	<br>
                	<label class="control-label">User Name</label>
                    <input maxlength="200" type="text" required="required" class="form-control" placeholder="Enter Username" name="rootName" />
                    <br>
                    <label class="control-label">Password</label>
                    <input maxlength="200" type="password" required="required" class="form-control" placeholder="Enter Password" name="rootPwd" /><br>
                     <label class="control-label">Please Enter your Query :</label>                   
                    <input maxlength="200" type="text" required="required" class="form-control" placeholder="Enter your Query"  name="dbQuery"/></input>
                    <br><button type= "submit">Submit</button>
</form>
<div> ${message} </div>
<div> ${result} </div>
</body>
</html>