<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="/" method="POST">
            Username: <input type="text" name="username"> 
            <input type="submit" value="Register Name">
            <input type="hidden" name="action" value="register"> <br/>
            ${message}
        </form>
    </body>
</html>
