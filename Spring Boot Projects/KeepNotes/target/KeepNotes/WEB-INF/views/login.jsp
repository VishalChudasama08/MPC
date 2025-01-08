<jsp:include page="header.jsp" />
<jsp:include page="Navbar.jsp" />

    <div>
        <h3 class='my-4'>Login Here</h3>
        <form id="loginForm">
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp" required />
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="password" minLength={8} required />
            </div>
            <button type="submit" id="loginSubmitBtn" class="btn btn-primary btn-sm">Submit</button>
        </form>
    </div>

    <jsp:include page="user_login_script.jsp" />
<jsp:include page="footer.jsp" />