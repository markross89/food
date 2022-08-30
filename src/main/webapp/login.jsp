<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="header.jsp"/>
    <section class="dashboard-section">
        <div class="container pt-4 pb-4">
            <div class="border-dashed view-height">
                <div class="container w-25">
                    <form method="POST" class="padding-small text-center">
                        <h1 class="text-color-darker">Logowanie</h1>
                        <div class="form-group">
                            <input type="text" class="form-control" id="email" name="email" placeholder="podaj adres email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="podaj hasło">
                        </div>
                        <button class="btn btn-color rounded-0" type="submit">Zaloguj</button>
                    </form>
                 </div>
            </div>
        </div>
    </section>
<jsp:include page="footer.jsp"/>