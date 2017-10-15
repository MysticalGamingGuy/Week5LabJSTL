<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="/?action=logout">Logout</a> </p>
        <h2>List</h2>
        
        <form action="/" method="POST">
            Add Item: <input type="text" name="item"> <input type="submit" value="Add">
            <input type="hidden" name="action" value="add"> <br/> <br/>
        </form>
        
        <form action="/" method="POST">
            <c:forEach items="${list}" var="item" varStatus="loop">
                <input type="radio" name="radioList" value="${loop.index}"> ${item} <br/>
            </c:forEach>
            <c:if test="${list.size() > 0}" >
                <br/> Delete Selected: <input type="submit" value="Delete">
                <input type="hidden" name="action" value="delete"> <br/> <br/>
            </c:if>
            ${message}
        </form>
        
    </body>
</html>
