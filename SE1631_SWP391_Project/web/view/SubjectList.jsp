<%-- 
    Document   : SubjectList
    Created on : Sep 20, 2022, 10:35:59 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <input type="submit" value="Subject List" />
        <br><!--  -->
        <br>
        <select name="Manager">
            <option>Kien Chym To</option>
            <option>Kien cu bu</option>
        </select>
        <select name="Expert">
            <option>Kien Chym To</option>
            <option>Kien cu bu</option>
        </select>
        <select name="Status">
            <option>Kien Chym To</option>
            <option>Kien cu bu</option>
        </select>
        <input style="width: 200px" type="text" placeholder="Search subject code or name" name="search" value="" />
        <input type="submit" value="Search" />
    </body>
</html>
