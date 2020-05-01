<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Открыть новый курс</title>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_back.jsp"></jsp:include>

            <h3>Открыть новый курс:</h3>
            <p style="color: red;">${errorString}</p>

        <form method="POST" action="${pageContext.request.contextPath}?command=openNewCourse">
            название курса: <input type="text" name="title"> <br> <br>
            дата начала курса: <input type="text" name="date_begin"> <br> <br>
            id преподавателя: <input type="text" name="id_teacher"> <br> <br>

            <input type="submit" name="btnadd" value="Подтвердить">
        </form>
    </body>
</html>