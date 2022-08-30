<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="header.jsp"/>
<section class="dashboard-section">
  <div class="row dashboard-nowrap">
    <div class="m-4 p-3 width-medium">
      <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="row border-bottom border-3 p-1 m-1">
          <div class="col noPadding"><h3 class="color-header text-uppercase">Użytkownik o podanym email-u już istnieje spróbuj ponownie!</h3></div>
          <a href="/register" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
        </div>
      </div>
    </div>
  </div>
</section>
<jsp:include page="footer.jsp"/>
