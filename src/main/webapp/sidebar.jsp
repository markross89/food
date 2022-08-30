<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ul class="nav flex-column long-bg">
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/app/dashboard">
            <span>Pulpit</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/app/recipe/list">
            <span>Przepisy</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/app/plan/list">
            <span>Plany</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a  class="nav-link" href="${pageContext.request.contextPath}/app/user/edit">
            <span>Edytuj dane</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link disabled" href="${pageContext.request.contextPath}/app/user/edit/password">
            <span>Zmień hasło</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <c:if test="${sessionScope['superAdmin'] != null && sessionScope['superAdmin'] == 1}">
        <jsp:include page="sidebarAdmin.jsp"/>
    </c:if>
</ul>
