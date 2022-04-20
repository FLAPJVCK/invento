<%--
  Created by IntelliJ IDEA.
  User: vaske
  Date: 20.04.2022
  Time: 4:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<style>
    .form{
        top: 0;
        left: 0;
        height: 100%;
        width: 100%;
        vertical-align: middle;
        margin-left: auto;
        margin-right: auto;
    }
</style>

<body class="form">
    <a href="${pageContext.request.contextPath}/hello?&time=none"><button type="button" class="btn btn-primary">Отобразить всю статистику</button></a>
    <a href="${pageContext.request.contextPath}/hello?&time=day"><button type="button" class="btn btn-primary">Отобразить статистику за день</button></a>
    <a href="${pageContext.request.contextPath}/hello?&time=month"><button type="button" class="btn btn-primary">Отобразить статистику за месяц</button></a>
    <a href="${pageContext.request.contextPath}/hello?&time=quarter"><button type="button" class="btn btn-primary">Отобразить статистику за квартал</button></a>
    <a href="${pageContext.request.contextPath}/hello?&time=year"><button type="button" class="btn btn-primary">Отобразить статистику за год</button></a>
    <a href="${pageContext.request.contextPath}/hello?&time=authorized"><button type="button" class="btn btn-primary">Отобразить авторизированные поставки</button></a>
</body>
</html>
