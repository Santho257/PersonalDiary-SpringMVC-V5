<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
</head>
<body>
    <h2 align="center">Enter Your Details Here</h2>
    <form:form modelAttribute="user" method="post" action="login">
        <table align="center">
            <tr>
                <td align="right"><form:label path="email">Email : </form:label></td>
                <td><input type="text" name="username"/></td>
                <td><form:errors rowspan = "2" path="email"/></td>
            </tr>
            <tr>
                <td align="right"><form:label path="password">Password : </form:label></td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="open-diary"/></td>
            </tr>
        </table>
    </form:form>
    <a href="register">New User?</a>
</body>
</html>