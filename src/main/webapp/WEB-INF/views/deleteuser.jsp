<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Account Deletion</title>
</head>
<body>
    <h2>Account Deletion</h2>
    <form:form modelAttribute="deletor" action="./deleteprocess" method="POST">
        <form:checkbox path="accept" />I accept to delete my account and data from the database
        <p>This action will lead to deletion of all the data that you have synchronized with the Personal Diary Application</p>
        <input type="submit" value="delete account" />
    </form:form>
</body>
</html>