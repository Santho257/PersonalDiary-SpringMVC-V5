<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
</head>
<body>
    <h2>Welcome ${user}</h2>
    <a href="./viewpage">View Page</a>
    <a href="./writepage">Write Page</a>
    <a href="../user/changepassword">Change Password</a>
    <a href="../user/deleteuser">Delete User</a>
    <form:form action="../logout">
        <input type="submit" value="logout"/>
    </form:form>
</body>
</html>