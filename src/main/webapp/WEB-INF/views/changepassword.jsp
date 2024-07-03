<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Change password</title>
</head>
<body>
    <h2 align="center">Enter Your Details Here</h2>
    <form:form modelAttribute="passwordable" action="processpassword" method="POST">
        <table align="center">
            <tr>
                <td align="right"><form:label path="oldPassword">Old Password : </form:label></td>
                <td><form:password path="oldPassword"/></td>
                <td>${wrongPassword}</td>
            </tr>
            <tr>
                <td align="right"><form:label path="password">New Password : </form:label></td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password"/></td>
            </tr>
            <tr>
                <td align="right"><form:label path="rePassword">Confirm Password : </form:label></td>
                <td><form:password path="rePassword"/></td>
                <td>${passwordMisMatch}</td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Change Password"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>