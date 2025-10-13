<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="includes/header.jsp" />
<div class="container">
<!-- Success Message -->
<c:if test="${not empty successMessage}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        ${successMessage}
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
    </div>
</c:if>

<!-- Error Message -->
<c:if test="${not empty errorMessage}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        ${errorMessage}
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
    </div>
</c:if>
    <div class="row justify-content-center">
        <div class="col-md-8 text-center">
            <h1 class="my-4">Welcome, <span class="text-primary">${user.username}</span>!</h1>
            <p class="lead">Manage your inventory efficiently</p>

            <div class="row mt-5">
                <div class="col-md-4 mb-4">
                    <div class="card h-100 shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">Products</h5>
                            <p class="card-text">Manage inventory items</p>
                            <a href="<c:url value='/product/list'/>" class="btn btn-outline-primary">Go to Products</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="card h-100 shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">Suppliers</h5>
                            <p class="card-text">Manage supplier contacts</p>
                            <a href="<c:url value='/supplier/list'/>" class="btn btn-outline-success">Go to Suppliers</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="card h-100 shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">Sales</h5>
                            <p class="card-text">Track sales records</p>
                            <a href="<c:url value='/sales/list'/>" class="btn btn-outline-info">Go to Sales</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="includes/footer.jsp" />