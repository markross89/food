<jsp:useBean id="plan" scope="request" class="pl.coderslab.model.Plan"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="header.jsp"/>
    <section class="dashboard-section">
    <div class="row dashboard-nowrap">
    <jsp:include page="sidebar.jsp"/>
            <div class="m-4 p-3 width-medium">
                <div class="dashboard-content border-dashed p-3 m-4 view-height">
                    <form method="POST">
                        <input type="hidden" class="form-control" name="planId" value="${plan.id}"/>
                    <div class="row border-bottom border-3 p-1 m-1">
                        <div class="col noPadding">
                            <h3 class="color-header text-uppercase">NOWY PLAN</h3>
                        </div>
                        <div class="col d-flex justify-content-end mb-2">
                            <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
                        </div>
                    </div>

                    <div class="schedules-content">
                            <div class="form-group row">
                                <label for="planName" class="col-sm-2 label-size col-form-label">
                                    Nazwa planu
                                </label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="planName" value="${plan.name}" id="planName" placeholder="Nazwa planu">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="planDescription" class="col-sm-2 label-size col-form-label">
                                    Opis planu
                                </label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="5" name="planDescription" id="planDescription" placeholder="Opis plany">${plan.description}</textarea>
                                </div>
                            </div>

                    </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
<jsp:include page="footer.jsp"/>