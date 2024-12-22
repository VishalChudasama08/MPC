<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">MyNotes</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/About">About</a>
                </li>
            </ul>
            <div class="d-flex">
                <!-- {!localStorage.getItem('UserToken') ? (
                            <> -->
                <a role="button" href="/login" class="btn btn-primary me-2">Login</a>
                <a role="button" href="/register" class="btn btn-primary">SignUp</a>
                <!-- </>
                        ) : (
                            <> -->
                <button class="btn btn-primary me-2" onClick={handleLogout}>Logout</button>
                <!-- </>
                        )} -->
            </div>
        </div>
    </div>
</nav>