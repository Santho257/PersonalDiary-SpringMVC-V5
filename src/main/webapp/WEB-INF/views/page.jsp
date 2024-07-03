<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
</head>
<body>
    <h2>Page Detail</h2>
    <p><strong>Date : </strong> ${page.date.toString()}</p>
    <p><strong>Title : </strong> ${page.title}</p>
    <p><strong>Content : </strong> ${page.content}</p>

    <form:form action="../logout">
        <input type="submit" value="logout"/>
    </form:form>
</body>
</html>