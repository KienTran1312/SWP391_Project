<%-- 
    Document   : SearchList
    Created on : Sep 24, 2022, 8:29:04 PM
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

        <select name="Manager">
            <option value="" disabled selected hidden>Manager</option>
            <c:forEach items="${user}" var="u">
                <option>${u.getFullname()}</option>   
            </c:forEach>
        </select>

        <select name="Expert">
            <option value="" disabled selected hidden>Expert</option>
            <c:forEach items="${manager}" var="m">
                <option>${m.getFullname()}</option>
            </c:forEach>
        </select>

        <select name="Status">
            <option value="" disabled selected hidden>Status</option>
            <c:forEach items="${status}" var="s">
                <c:if test="${s.getStatus() == true}">
                    <option>Active</option>
                </c:if>
                <c:if test="${s.getStatus() == false}">
                    <option>Inactive</option>
                </c:if>
            </c:forEach>

        </select>

        <form action="Search" method="GET">
            <input style="width: 200px" type="text" placeholder="Search subject code or name" name="txt" />
            <input type="submit" value="Search" />    
        </form>

        <br>
        <br
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
                <c:forEach items="${listSubjects}" var="l">
                    <tr>
                        <td>${l.getSubjectId()}</td>
                        <td>${l.getSubjectCode()}</td>
                        <td>${l.getSubjectName()}</td>
                        <td>${l.getManagerId()}</td>    
                        <td>${l.getExpertId()}</td>
                        <c:if test="${l.getStatus() eq true}">
                            <td>Active</td>
                        </c:if>
                        <c:if test="${l.getStatus() eq false}">
                            <td>Inactive</td>
                        </c:if>
                        <td>edit</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <c:forEach begin="1" end="${endP}" var="i">
            <a class="page-link" href="Search?index=${i}&txt=${search}">${i}</a>
        </c:forEach>
    </body>
</html>