<jsp:include page="header.jsp" />
<jsp:include page="Navbar.jsp" />
    <div>
        <h3 class='my-4'>Register Here</h3>

        <div id="message"></div>

        <form id="registerForm">
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" onChange={handleOnChange} required />
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" onChange={handleOnChange} required />
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email </label>
                <input type="email" class="form-control" id="email" name="email" onChange={handleOnChange} aria-describedby="emailHelp" required />
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" onChange={handleOnChange} minLength={8} autoComplete="new-password" required />
            </div>
            <div class="mb-3">
                <label for="cPassword" class="form-label">Confirm Password</label>
                <input type="password" class="form-control" id="cPassword" name="cPassword" onChange={handleOnChange} minLength={8} autoComplete="new-password" required />
            </div>
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <input type="number" class="form-control" id="phoneNumber" name="phoneNumber" onChange={handleOnChange} required />
            </div>
            <%-- {credentials.cPassword.length !==0 && credentials.password !==credentials.cPassword && (<small class="text-danger">{"Passwords do not match, Please confirm your password"}</small>)} --%>
            <%-- disabled={credentials.password !==credentials.cPassword} --%>
            <button type="submit" id="registerBtn" class="btn btn-primary d-block">Submit</button>
        </form>
    </div>

    <script>
        $(document).ready(function() {
            $("#registerForm").submit(function(event) {
                event.preventDefault(); // Prevent page reload
                // Collect form data
                const userData = {
                    firstName: $("#firstName").val(),
                    lastName: $("#lastName").val(),
                    email: $("#email").val(),
                    password: $("#password").val(),
                    phoneNumber: $("#phoneNumber").val()
                };

                // Make AJAX request
                $.ajax({
                    url: "/api/user/createUser",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify(userData),
                    success: function(response) {
                        if (response.status === "success") {
                            $("#message").text(response.message).css("color", "green");
                            setTimeout(() => {
                                window.location.href = "login"; // go on login page
                            }, 2000);
                        } else {
                            $("#message").text(response.message).css("color", "red");
                        }
                    },
                    error: function() {
                        $("#message").text("An error occurred while registering.").css("color", "red");
                    }
                });
            });
        });
    </script>
<jsp:include page="footer.jsp" />
