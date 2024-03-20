<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/brand-demo/loginServlet" method="post" id="form">
        <h1 id="loginMsg">登 录</h1>
        <div id="errorMsg">${login_msg}${register_msg}</div>
        <p>用户名:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>
        <p>密码:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>

        <%--保存了用户名,默认选中记住我--%>
        <c:if test="${cookie.username.value!=null}">
            <p>记住我: <input name="remember" type="checkbox" value="1" checked="checked"></p>
        </c:if>

        <%--没有保存用户名,不选中记住我--%>
        <c:if test="${cookie.username.value==null}">
            <p>记住我: <input name="remember" type="checkbox" value="1"></p>
        </c:if>

        <div id="subDiv">
            <input type="submit" class="button" value="登 录">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>
</body>
</html>