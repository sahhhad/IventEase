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
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Sales Records</h2>
        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addSaleModal">
            <i class="bi bi-plus-circle"></i> Add Sale
        </button>
    </div>

    <!-- Sales Table -->
    <div class="table-responsive">
        <table class="table table-striped table-hover align-middle">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Product ID</th>
                    <th>Quantity</th>
                    <th>Total (Rs.)</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sale" items="${sales}">
                    <tr>
                        <td>${sale.id}</td>
                        <td>${sale.productId}</td>
                        <td>${sale.quantity}</td>
                        <td>Rs.${sale.total}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Add Sale Modal -->
    <div class="modal fade" id="addSaleModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Record New Sale</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <form action="<c:url value='/sales/add'/>" method="post">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label">Product ID</label>
                            <input type="number" name="productId" class="form-control" min="1" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Quantity</label>
                            <input type="number" name="quantity" class="form-control" min="1" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Total (Rs.)</label>
                            <input type="number" name="total" class="form-control" step="0.01" min="0.01" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Record Sale</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="includes/footer.jsp" />