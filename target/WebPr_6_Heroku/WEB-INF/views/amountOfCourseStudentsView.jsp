<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Количество студентов заданного курса</title>
    </head>

    <body>

        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_back.jsp"></jsp:include>

            <h3>Количество студентов, записавшихся на заданный курс:</h3>

            <form method="POST" action="${pageContext.request.contextPath}?command=amountOfCourseStudents">
            id курса: <input type="text" name="id_course"> <br> <br>

            <input type="submit" name="btnadd" value="Подтвердить">
        </form>

        <p>Количество: ${amount}</p>

    </body>
</html>