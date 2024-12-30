<script>
   $(document).ready(function () {
      sessionStorage.clear();
      function toggleLoginSubmitButtonDisability() {
         // boolean 
         const allFieldsFilled = $("#email").val() !== '' && $("#password").val() !== '';

         $("#loginSubmitBtn").prop("disabled", !allFieldsFilled); // Enable if all fields are filled
      }

      // Attach event listeners to all input fields
      $("#email, #password").on('input', function () {
         toggleLoginSubmitButtonDisability();
      });

      // on page load
      toggleLoginSubmitButtonDisability();

      $("#loginForm").submit(function (event) {
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
            success: function (response) {
               if (response.status === "success") {
                  softAlert(response.status, response.message, 2000);

                  sessionStorage.setItem("UserName", response.UserName);
                  sessionStorage.setItem("UserId", BigInt(response.UserId));
                  const loggedInUser = {
                     id: "${loggedInUser.id}",
                     firstName: "${loggedInUser.firstName}",
                     lastName: "${loggedInUser.lastName}",
                     email: "${loggedInUser.email}",
                     password: "${loggedInUser.password}",
                     phoneNumber: "${loggedInUser.phoneNumber}",
                     createDate: "${loggedInUser.createDate}"
                  };
                  sessionStorage.setItem("UserFirstName", loggedInUser.firstName);
                  sessionStorage.setItem("UserLastName", loggedInUser.lastName);
                  sessionStorage.setItem("UserEmail", loggedInUser.email);
                  sessionStorage.setItem("UserPhoneNumber", loggedInUser.phoneNumber);
                  console.log("Logged-in User:", loggedInUser);

                  setTimeout(() => {
                     window.location.href = "NotesHome"; // go on NotesHome page
                  }, 1000);
               } else {
                  softAlert("danger", response.message, 30000);
               }
            },
            error: function () {
               softAlert("danger", "Server error occurred while login.", 30000);
            }
         });
      });
   });
</script>