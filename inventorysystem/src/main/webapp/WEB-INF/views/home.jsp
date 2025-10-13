<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Inventory System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        html, body { height: 100%; }
        body { display: flex; align-items: center; padding-top: 40px; padding-bottom: 40px; }
        .form-signin { width: 100%; max-width: 330px; padding: 15px; margin: auto; }
        .form-signin .checkbox { font-weight: 400; }
        .form-signin .form-floating:focus-within { z-index: 2; }
        .form-signin input[type="text"] { margin-bottom: -1px; border-bottom-right-radius: 0; border-bottom-left-radius: 0; }
        .form-signin input[type="password"] { margin-bottom: 10px; border-top-left-radius: 0; border-top-right-radius: 0; }
    </style>
</head>
<body class="text-center">
    <main class="form-signin">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <form action="<c:url value='/login'/>" method="post">
            <div class="form-floating">
                <input type="text" name="username" class="form-control" id="username" placeholder="Username" required autofocus>
                <label for="username">Username</label>
            </div>
            <div class="form-floating">
                <input type="password" name="password" class="form-control" id="password" placeholder="Password" required>
                <label for="password">Password</label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        </form>

        <c:if test="${param.error == 1}">
            <div class="alert alert-danger mt-3" role="alert">
                Invalid username or password!
            </div>
        </c:if>
    </main>
</body>
</html>