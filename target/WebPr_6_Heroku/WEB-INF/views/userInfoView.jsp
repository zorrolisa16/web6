<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Информация о пользователе</title>
    </head>
    <body>

        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_back.jsp"></jsp:include>

            <h3>Здравствуйте, ${username}! Рады видеть вас в системе.</h3>

        <p style="color: forestgreen;">Время последнего сеанса: ${time}</p>

        <p style="color: mediumslateblue;">${userRoleInfo}</p>

        <p style="color: red;">${errorMessage}</p>

    </body>
</html>