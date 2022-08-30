<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<jsp:include page="header.jsp"/>
<section class="dashboard-section">
        <div class="row dashboard-nowrap">
            <jsp:include page="sidebar.jsp"/>
            <div class="m-4 p-3 width-medium">
                <div class="m-4 p-3 border-dashed view-height">

                    <div class="row border-bottom border-3 p-1 m-1">
                        <div class="col noPadding">
                            <h3 class="color-header text-uppercase">LISTA UŻYTKOWNIKÓW</h3>
                        </div>
                        <div class="col d-flex justify-content-end mb-2 noPadding">
                            <a href="${pageContext.request.contextPath}/app/dashboard" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
                        </div>
                    </div>

                    <div class="schedules-content">
                        <table class="table">
                            <thead>
                                <tr class="d-flex">
                                    <th class="col-1">ID</th>
                                    <th class="col-2">IMIĘ</th>
                                    <th class="col-3">NAZWISKO</th>
                                    <th class="col-3">STATUS</th>
                                    <th class="col-3 center">AKCJE</th>
                                </tr>
                            </thead>
                            <tbody class="text-color-lighter">
                            <jsp:useBean id="adminList" scope="request" type="java.util.List"/>
                            <c:forEach var="admin" items="${adminList}">
                                <jsp:useBean id="admin" scope="request" class="pl.coderslab.model.Admin"/>
                                <tr class="d-flex">
                                    <td class="col-1">${admin.id}</td>
                                    <td class="col-2">${admin.firstName}</td>
                                    <td class="col-3">${admin.lastName}</td>
                                    <td class="col-3">${admin.enable}</td>
                                    <td class="col-3 center">
                                        <a href="${pageContext.request.contextPath}/app/user/superAdmin/userBlock?userId=${admin.id}" class="btn btn-danger rounded-0 text-light m-1">Blokuj</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </section>
<jsp:include page="footer.jsp"/>