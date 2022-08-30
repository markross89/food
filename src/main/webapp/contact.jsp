<%@ page contentType="text/html;charset=UTF-8" %>

<section class="last-info-section padding-small" id="contact">
    <div class="container">
        <div class="row">
            <div class="col">
                <h3 class="mb-4">Witaj</h3>
                <p> ${contact.description}</p>
            </div>
            <div class="col pl-4 ml-4">
                <h3 class="mb-4">${contact.name}</h3>
                <ul class="container">
                    <li>${contact.email}</li>
                    <li>${contact.phoneNumber}</li>
                    <li>${contact.facebook}</li>

                </ul>
            </div>
            <div class="col">
                <h3 class="mb-4">Znajdź nas online</h3>
                <div class="input-group mb-3">
                    <input type="text" class="form-control border-0 rounded-0" placeholder="Szukaj"
                           aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="input-group-text btn-color border-0 rounded-0" type="submit" id="basic-addon2"><a
                                href="https://www.google.com/search?q=${contact.name}">Szukaj</a></button>
                    </div>
                </div>
                <div class="container d-flex-row">
                    <a href="https://pl-pl.facebook.com/">
                        <i class="fab fa-facebook-square mr-4 icon-social"></i>
                    </a>
                    <a href="https://twitter.com/?lang=pl">
                        <i class="fab fa-twitter-square mr-4 icon-social"></i>

                    </a>
                    <a href="https://www.instagram.com/">
                        <i class="fab fa-instagram icon-social"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

