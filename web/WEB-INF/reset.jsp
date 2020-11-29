<%-- 
    Document   : reset
    Created on : 29-Nov-2020, 12:22:04 PM
    Author     : Raymond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NoteKeepr Reset Password</title>
    </head>
    <h1>Reset password</h1>
        <p>Please enter your email address associated with your account to reset your password.</p>
        <form method="post" action="reset">
            Email Address: <input type="text" name="email"><br>
            <input type="hidden" name="action" value="reset">
            <input type="submit" value="Submit">
        </form>
        <p>${message}</p>
</html>
