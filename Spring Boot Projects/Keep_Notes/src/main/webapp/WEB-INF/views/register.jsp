<jsp:include page="header.jsp" />
<jsp:include page="Navbar.jsp" />
    <div>
        <h3 class='my-4'>Register Here</h3>

        <form id="registerForm">
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" required />
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" required />
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email </label>
                <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" required />
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" minLength="5" autoComplete="new-password" required />
            </div>
            <div class="mb-3">
                <label for="cPassword" class="form-label">Confirm Password</label>
                <input type="password" class="form-control" id="cPassword" name="cPassword" minLength="5" autoComplete="new-password" required />
            </div>
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number</label><i style="font-size: small;" class="fa-solid fa-info bg-warning-subtle rounded-circle py-1 px-2" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-custom-class="custom-tooltip" data-bs-title="for recovery password and account."></i>
                <input type="number" class="form-control" id="phoneNumber" name="phoneNumber" required />
            </div>
            <button type="submit" id="registerBtn" class="btn btn-primary d-block btn-sm">Submit</button>
        </form>
    </div>

    <jsp:include page="user_register_script.jsp" />
<jsp:include page="footer.jsp" />
