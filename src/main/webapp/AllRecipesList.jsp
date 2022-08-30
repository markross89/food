<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="header.jsp"/>
<section>
    <div class="row padding-small" style="margin: 0">
        <i class="fas fa-users icon-users"></i>
        <h1>Przepisy naszych użytkowników:</h1>
        <hr>
        <div class="orange-line w-100"></div>
    </div>
</section>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <div class="m-4 p-3 width-medium">
            <form method="POST" class="padding-small text-center">
                <div class="form-group">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Podaj tytuł przepisu">
                </div>
                <button class="btn btn-color rounded-0" type="submit">wyszukaj</button>
            </form>
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding"><h3 class="color-header text-uppercase">Lista Przepisów</h3></div>
                </div>
                <table class="table border-bottom schedules-content">
                    <thead>
                    <tr class="d-flex text-color-darker">
                        <th scope="col" class="col-1">ID</th>
                        <th scope="col" class="col-2">NAZWA</th>
                        <th scope="col" class="col-3">OPIS</th>
                        <th scope="col" class="col-4">DODANO</th>
                        <th scope="col" class="col-1">AKCJE</th>
                    </tr>
                    </thead>
                    <tbody class="text-color-lighter">
                    <c:forEach items="${recipes}" var="recipe">
                        <jsp:useBean id="recipe" scope="request" class="pl.coderslab.model.Recipe"/>
                        <tr class="d-flex">
                            <th scope="row" class="col-1">${recipe.id}</th>
                            <td class="col-2">${recipe.name}</td>
                            <td class="col-3">${recipe.description}</td>
                            <td class="col-4">${recipe.created}</td>
                            <td class="col-1"><a href="/allRecipesDetails?id=${recipe.id}" class="btn btn-info rounded-0 text-light">Szczegóły</a></td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>

