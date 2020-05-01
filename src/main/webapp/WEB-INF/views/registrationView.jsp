<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Регистрация пользователя</title>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_back.jsp"></jsp:include>

            <h3>Страница регистрации пользователя</h3>
            <p style="color: red;">${errorString}</p>
        <p><c:if test="${errorCode!=null}">
                <c:if test="${errorCode.equals('sessionUserExists')}">В данной сессии уже присутствует пользователь.</c:if>
                <c:if test="${errorCode.equals('userExists')}">Пользователь с таким именем уже существует.</c:if>
                <c:if test="${errorCode.equals('usernameLength')}">Имя пользователя не может содержать менее 6 символов!</c:if>
                <c:if test="${errorCode.equals('passwordLength')}">Пароль не может содержать менее 5 символов!</c:if>
            </c:if></p>

        <form method="POST" action="${pageContext.request.contextPath}?command=register">
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
                    <td>Зарегистрироваться как преподаватель:</td>
                    <td><input type="checkbox" name="isTeacher" value= "1" /> </td>
                </tr>
                <tr>
                    <td colspan ="2">
                        <input type="submit" value= "Подтвердить" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>