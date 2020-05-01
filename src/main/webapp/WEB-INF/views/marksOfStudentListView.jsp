<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Список оценок заданного студента</title>
    </head>

    <body>

        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_back.jsp"></jsp:include>

            <h3>Список оценок заданного студента:</h3>

        <form method="POST" action="${pageContext.request.contextPath}?command=marksOfStudentList">
            id студента: <input type="text" name="id_student"> <br> <br>

            <input type="submit" name="btnadd" value="Подтвердить">
        </form>

        <c:if test = "${marksOfStudentList != null}">
            <table border="1" cellpadding="5" cellspacing="1" >
                <tr>
                    <th>id оценки</th>
                    <th>Оценка студента</th>
                    <th>id студента</th>
                    <th>id курса</th>
                </tr>
                <c:forEach items="${marksOfStudentList}" var="mark" >
                    <tr>
                        <td>${mark.id}</td>
                        <td>${mark.value}</td>
                        <td>${mark.idstudent}</td>
                        <td>${mark.idcourse}</td>                    
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>