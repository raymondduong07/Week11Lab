<%-- 
    Document   : resetNewPassword
    Created on : 29-Nov-2020, 1:19:53 PM
    Author     : Raymond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NoteKeepr Reset Password</title>
    </head>
    <body>
        <h1>Enter a new password</h1>
        <form method="post" action="reset">
            <input type="text" name="newpassword">
            <input type="hidden" name="uuid" value="${uuid}">
            <input type="hidden" name="action" value="newpassword">
            <br>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
