<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="header.jsp"/>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
    <jsp:include page="sidebar.jsp"/>
        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="row border-bottom border-3 p-1 m-1">
                    <form action="${pageContext.request.contextPath}/app/recipe/plan/delete" method="post">
                        <div class="col noPadding">
                            <h3 class="color-header text-uppercase">Czy napewno chcesz usunąć?</h3>
                        </div>
                        <button type="submit" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Usuń</button>
                        <input hidden name="recipePlanId" value="${recipePlanId}"/>
                        <input hidden name="planId" value="${planId}"/>
                        <a href="${pageContext.request.contextPath}/app/plan/details" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Anuluj</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>