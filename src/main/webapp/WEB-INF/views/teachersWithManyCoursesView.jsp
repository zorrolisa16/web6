<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Список преподавателей, ведущих более одного курса</title>
    </head>

    <body>

        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_back.jsp"></jsp:include>

            <h3>Список преподавателей, ведущих более одного курса:</h3>

        <c:if test = "${teacherList != null}">
            <table border="1" cellpadding="5" cellspacing="1" >
                <tr>
                    <th>id преподавателея</th>
                    <th>ФИО преподавателя</th>
                </tr>
                <c:forEach items="${teacherList}" var="teacher" >
                    <tr>
                        <td>${teacher.id}</td>
                        <td>${teacher.fio}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>