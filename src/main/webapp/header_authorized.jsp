<%@ page contentType="text/html;charset=UTF-8" %>
<header class="page-header">
  <nav class="navbar navbar-expand-lg justify-content-between">
    <a href="${pageContext.request.contextPath}/" class="navbar-brand main-logo main-logo-smaller">
      Zaplanuj <span>Jedzonko</span>
    </a>
    <div class="d-flex justify-content-around">
          <a class="nav-link disabled" href="/logOut">Wyloguj</a>
      <h4 class="text-light mr-3">${sessionScope['User'].getFirstName()}</h4>
      <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>
    </div>
  </nav>
</header>
