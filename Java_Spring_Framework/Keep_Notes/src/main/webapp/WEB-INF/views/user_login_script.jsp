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

                  setTimeout(() => {
                     window.location.href = "NotesHome"; // go on NotesHome page
                  }, 300);
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