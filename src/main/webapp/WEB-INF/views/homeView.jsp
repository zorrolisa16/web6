<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Факультативы</title>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <p style="color: red;">${errorString}</p>

        <p>
            <br>Существует перечень <strong>Курсов</strong>, за каждым из которых закреплен один <strong>Преподаватель</strong>.<br>
            <strong>Студент</strong> записывается на один или несколько <strong>Курсов</strong>, данные о регистрации сохраняются.<br>
            По окончании обучения <strong>Преподаватель</strong> выставляет <strong>Студенту</strong> оценку, которая сохраняется в <strong>Архиве</strong>.
        </p>
        
        <ul id="menu">
            <li>
                <a href="${pageContext.request.contextPath}?command=login">Войти в систему</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}?command=amountOfCourseStudents">Вывести информацию о количестве студентов записавшихся на заданный курс.</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}?command=teachersWithManyCoursesList">Вывести фамилии преподавателей, ведущих более одного курса.</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}?command=marksOfStudentList">Вывести информацию об оценках заданного студента.</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}?command=openNewCourse">Открыть новый курс, назначить дату начала занятий курса.</a>
            </li>
        </ul>
        
    </body>
</html>