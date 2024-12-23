<jsp:include page="header.jsp" />
<jsp:include page="Navbar.jsp" />

    <div id="message"></div>
    <div id="data"></div>

    <div>
        <h3 class='my-4'>Login Here</h3>
        <form id="loginForm" onSubmit={handleSubmit}>
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" name="email" onChange={handleOnChange} class="form-control" id="email" aria-describedby="emailHelp" required />
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" onChange={handleOnChange} class="form-control" id="password" minLength={8} required />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <script>
        $(document).ready(function() {
            $("#loginForm").submit(function(event) {
                event.preventDefault(); // Prevent page reload
                // Collect form data
                const loginData = {
                    email: $("#email").val(),
                    password: $("#password").val()
                };

                // Make AJAX request
                $.ajax({
                    url: "/api/user/login",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify(loginData),
                    success: function(response) {
                        if (response.status === "success") {
                            $("#message").text(response.message).css("color", "green");
                            $("#data").html("User Name: " + response.UserName + "<br> User Id: " + response.UserId).css("color", "green");
                            sessionStorage.setItem("UserName", response.UserName);
                            sessionStorage.setItem("UserId", BigInt(response.UserId));
                            setTimeout(() => {
                                window.location.href = "profile"; // go on profile page
                            }, 3000);
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