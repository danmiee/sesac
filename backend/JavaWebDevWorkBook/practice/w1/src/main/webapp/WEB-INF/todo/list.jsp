<%--
  Created by IntelliJ IDEA.
  User: redfo
  Date: 2024-06-18
  Time: 오후 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List Page</h1>
    ${list}

    <h1>JSP - EL(Expression Language)</h1>
    ${list[0].tno} --- ${list[0].title}

    <h3>${1+2+3}</h3>
    <h3>${"AAA"+="BBB"}</h3>
    <h3>${"AAA".equals("AAA")}</h3>

    <h4>${list[0].title}</h4>
    <h4>${list[0].getTitle()}</h4>

    <h1>JSTL</h1>
    <ul>
        <c:forEach var="dto" items="${list}">
            <li>${dto}</li>
        </c:forEach>
    </ul>

    <h1>JSTL - Choose</h1>
    <c:choose>
        <c:when test="${list.size() % 2 == 0}">
            짝수
        </c:when>
        <c:otherwise>
            홀수
        </c:otherwise>
    </c:choose>

    <h1>JSTL - Set</h1>
    <c:set var="target" value="5"></c:set>
    <ul>
        <c:forEach var="num" begin="1" end="10">
            <c:if test="${num == target}">
                num is target
            </c:if>
        </c:forEach>
    </ul>
</body>
</html>
