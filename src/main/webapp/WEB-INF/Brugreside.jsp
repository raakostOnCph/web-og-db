<%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 19/03/2023
  Time: 19.56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> ${requestScope.msg}</h1>

<c:forEach var="item" items="${sessionScope.person.stringSet}">


    <br>
    ${item}

</c:forEach>




</body>
</html>
