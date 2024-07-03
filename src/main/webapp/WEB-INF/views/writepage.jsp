<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
</head>
<body>
    <h2 align="center">Enter Your Details Here</h2>
    <form:form modelAttribute="page" action="updatePage">
        <table align="center">
        <tr>
            <td align="right"><form:label path="date">Date : </form:label></td>
            <td><form:input type="date" id="date" path="date"/></td>
            <td><form:errors path="date"/></td>
        </tr>
        <tr>
            <td align="right"><form:label path="title">Title : </form:label></td>
            <td><form:input id="title" path="title"/></td>
            <td><form:errors path="title"/></td>
        </tr>
        <tr>
            <td align="right"><form:label path="content">Content : </form:label></td>
            <td><form:textarea id="content" path="content"/></td>
            <td><form:errors path="content"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="write"/></td>
        </tr>
        </table>

    </form:form>
</body>
</html>