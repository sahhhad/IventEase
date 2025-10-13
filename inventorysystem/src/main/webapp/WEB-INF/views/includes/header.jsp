<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory System</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom Styles -->
    <style>
        body { padding-top: 56px; }
        .navbar-brand { font-weight: 600; }
        .user-info { color: #fff; opacity: 0.9; }
        .table th { font-weight: 600; }
        .footer {
            margin-top: 3rem;
            padding: 1.5rem 0;
            background-color: #f8f9fa;
            border-top: 1px solid #e9ecef;
        }
    </style>
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/dashboard'/>">Inventory Manager</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/product/list'/>">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/supplier/list'/>">Suppliers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/sales/list'/>">Sales</a>
                    </li>
                </ul>

                <c:if test="${not empty user}">
                    <span class="navbar-text user-info me-3">
                        Welcome, <strong>${user.username}</strong>!
                    </span>
                    <a class="btn btn-outline-light" href="<c:url value='/logout'/>">Logout</a>
                </c:if>
            </div>
        </div>
    </nav>