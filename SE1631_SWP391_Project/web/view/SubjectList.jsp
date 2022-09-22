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

        <form action="SubjectList" method="POST">
            <input type="submit" value="Subject List" />
            <br>
        </form>

        <c:if test="${user !=null && manager !=null && status != null}">
            <select name="Manager">
                <c:forEach items="${user}" var="u">
                    <option>${u.getFullname()}</option>   
                </c:forEach>
            </select>

            <select name="Expert">
                <c:forEach items="${manager}" var="m">
                    <option>${m.getFullname()}</option>
                </c:forEach>
            </select>

            <select name="Status">
                <c:forEach items="${status}" var="s">
                    <c:if test="${s.getStatus() == true}">
                        <option>Active</option>
                    </c:if>
                    <c:if test="${s.getStatus() == false}">
                        <option>Inactive</option>
                    </c:if>
                </c:forEach>

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
        </c:if>






    </body>
</html>
