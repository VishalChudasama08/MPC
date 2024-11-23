<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register JSP file - Spring Boot V14 </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">VISHAL</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="About.html">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="RegisterFrom">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="LoginForm">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="LogoutForm">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">

        <h4>Register Here</h4>

        <c:if test="${not empty SuccessMsg}">
            <h5 style="color: green;">${SuccessMsg}</h5>
        </c:if>
        <c:if test="${not empty ErrorMsg}">
            <h5 style="color: red;">${ErrorMsg}</h5>
        </c:if>

        <form action="RegisterFormSubmit" method="post">
            <div class="mb-3 row">
                <label for="name" class="col-sm-2 col-form-label">Name :</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="name" required>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="email" class="col-sm-2 col-form-label">Email : </label>
                <div class="col-sm-10">
                    <input type="email" name="email" class="form-control" id="email" required>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="password" class="col-sm-2 col-form-label">Password :</label>
                <div class="col-sm-10">
                    <input type="password" name="password" class="form-control" id="password" required>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="number" class="col-sm-2 col-form-label">Phone Number :</label>
                <div class="col-sm-10">
                    <input type="number" name="number" class="form-control" id="number" required>
                </div>
            </div>
            <input type="submit" class="btn btn-primary" value="Register">

            If you are already registered than <a href="LoginForm"><strong>click me.</strong></a>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>

</html>