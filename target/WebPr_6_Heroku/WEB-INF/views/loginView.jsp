<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Вход в систему</title>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_back.jsp"></jsp:include>

            <h3>Страница входа в систему</h3>
            <p style="color: red;">${errorString}</p>


        <form method="POST" action="${pageContext.request.contextPath}?command=login">
            <table border="0">
                <tr>
                    <td>Имя пользователя:</td>
                    <td><input type="text" name="username" value= "" /> </td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="password" name="password" value= "" /> </td>
                </tr>
                <tr>
                    <td>Сохранить данные в cookie:</td>
                    <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
                </tr>
                <tr>
                    <td colspan ="2">
                        <input type="submit" value= "Войти" />
                    </td>
                </tr>
            </table>
        </form>
        <p>Впервые на нашем сайте? <a href="${pageContext.request.contextPath}?command=register">Зарегистрируйтесь!</a></p>
    </body>
</html>