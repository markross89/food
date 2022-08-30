<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="header.jsp"/>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
    <jsp:include page="sidebar.jsp"/>
        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding">
                        <h3 class="color-header text-uppercase">DODAJ PRZEPIS DO PLANU</h3>
                    </div>
                    <div class="col d-flex justify-content-end mb-2 noPadding">
                        <button type="submit" form="add-recipe-form" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
                    </div>
                </div>

                <div class="schedules-content">
                    <form action="/app/recipe/plan/add" id="add-recipe-form" method="POST">
                        <div class="form-group row">
                            <label for="choosePlan" class="col-sm-2 label-size col-form-label">
                                Wybierz plan
                            </label>
                            <div class="col-sm-3">
                                <select class="form-control" name="choosePlan" id="choosePlan">
                                    <jsp:useBean id="plans" scope="request" type="java.util.List"/>
                                    <c:forEach var="plan" items="${plans}">
                                        <jsp:useBean id="plan" scope="request" class="pl.coderslab.model.Plan"/>
                                        <option value="${plan.id}">${plan.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="name" class="col-sm-2 label-size col-form-label">
                                Nazwa posiłku
                            </label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" id="name" name="name" placeholder="Nazwa posiłku">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="number" class="col-sm-2 label-size col-form-label">
                                Numer posiłku
                            </label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" value="" id="number" name="number" placeholder="Numer posiłku">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="recipe" class="col-sm-2 label-size col-form-label">
                                Przepis
                            </label>
                            <div class="col-sm-4">
                                <select class="form-control" id="recipe" name="recipe">
                                    <jsp:useBean id="recipes" scope="request" type="java.util.List"/>
                                    <c:forEach var="recipe" items="${recipes}">
                                        <jsp:useBean id="recipe" scope="request" class="pl.coderslab.model.Recipe"/>
                                        <option value="${recipe.id}">${recipe.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="day" class="col-sm-2 label-size col-form-label">
                                Dzień
                            </label>
                            <div class="col-sm-2">
                                <select class="form-control" id="day" name="day">
                                    <jsp:useBean id="days" scope="request" type="java.util.List"/>
                                    <c:forEach var="day" items="${days}">
                                        <jsp:useBean id="day" scope="request" class="pl.coderslab.model.DayName"/>
                                        <option value="${day.id}">${day.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>