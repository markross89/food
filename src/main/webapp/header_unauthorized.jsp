<%@ page contentType="text/html;charset=UTF-8" %>
<header class="page-header">
  <nav class="navbar navbar-expand-lg justify-content-around">
    <a href="${pageContext.request.contextPath}/" class="navbar-brand main-logo">
      Zaplanuj <span>Jedzonko</span>
    </a>
    <ul class="nav nounderline text-uppercase">
      <li class="nav-item ml-4">
        <a class="nav-link color-header" href="${pageContext.request.contextPath}/login">logowanie</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link color-header" href="${pageContext.request.contextPath}/register">rejestracja</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link" href="${pageContext.request.contextPath}/aboutApp">o aplikacji</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link disabled" href="${pageContext.request.contextPath}/allRecipes">Przepisy</a>
      </li>
      <li class="nav-item ml-4">
        <a class="nav-link disabled" href="${pageContext.request.contextPath}/contact">Kontakt</a>
      </li>
    </ul>
  </nav>
</header>
