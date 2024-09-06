<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
</head>
<body>
    <h2 align="center">Enter Your Details Here</h2>
    <form:form modelAttribute="user" action="processRegister" method="POST">
        <table align="center">
        <tr>
            <td align="right"><form:label path="name">Name : </form:label></td>
            <td><form:input id="name" value="Abdur rahman" path="name"/></td>
            <td><form:errors path="name"></form:errors><td>
        </tr>
        <tr>
            <td align="right"><form:label path="email">Email : </form:label></td>
            <td><form:input id="email" value="msabuofficial@gmail.com" path="email"/></td>
            <td><form:errors path="email"></form:errors><td>
            <td>${userExists}</td>
        </tr>
        <tr>
            <td align="right"><form:label path="password">Password : </form:label></td>
            <td><form:password id="password" value="Abdur@147" path="password"/></td>
            <td><form:errors path="password"></form:errors><td>
        </tr>
        <tr>
            <td align="right"><form:label path="rePassword">Re-Enter Password : </form:label></td>
            <td><form:password id="re-password" value="Abdur@147" path="rePassword"/></td>
            <td>${passMisMatch}</td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="register"/></td>
        </tr>
        </table>

    </form:form>
</body>
</html>