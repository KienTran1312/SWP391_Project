<%-- 
    Document   : SubjectList
    Created on : Sep 20, 2022, 10:35:59 PM
    Author     : dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="SubjectDetails" method="POST">
            <input type="submit" value="Subject List" />
            <br>
            <select name="Manager">
                <c:forEach items="${user}" var="u">
                    <option>${u.getFullname()}</option>   
                </c:forEach>


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
            <br>
            <br><!-- <br> -->
            <br>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Subject code</th>
                        <th>Subject name</th>
                        <th>Manager</th>
                        <th>Expert</th>
                        <th>Status</th>
                        <th>Subject Details</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                        <td>5</td>
                        <td>6</td>
                        <td>7</td>
                    </tr>

                </tbody>

            </table>
        </form>






    </body>
</html>
