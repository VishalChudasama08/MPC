<script>
   $(document).ready(function () {
      sessionStorage.clear()

      $("#password, #cPassword").on("input", function () {
         const password = $("#password").val();
         const cPassword = $("#cPassword").val();

         // Clear previous message
         const msgElement = document.querySelector("#passMatchMsg");
         if (msgElement) { msgElement.remove(); }

         // Add message if passwords do not match
         if (password && cPassword && password !== cPassword) {
            const small = document.createElement("small");
            small.id = "passMatchMsg";
            small.className = "text-danger";
            small.textContent = "Passwords do not match, Please confirm your password";
            document.getElementById("cPassword").parentNode.appendChild(small);
         }
      });


      function toggleRegisterSubmitButtonDisability() {
         // boolean 
         const allFieldsFilled = $("#firstName").val() !== '' && $("#lastName").val() !== '' && $("#email").val() !== '' && $("#password").val() !== '' && $("#cPassword").val() !== '' && $("#phoneNumber").val() !== '';

         $("#registerBtn").prop("disabled", !allFieldsFilled); // Enable if all fields are filled
      }

      // Attach event listeners to all input fields
      $("#firstName, #lastName, #email, #password, #cPassword, #phoneNumber").on('input', function () {
         toggleRegisterSubmitButtonDisability();
      });

      // on page load
      toggleRegisterSubmitButtonDisability();

      $("#registerForm").submit(function (event) {
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
            success: function (response) {
               if (response.status === "success") {
                  softAlert(response.status, response.message, 2000);
                  setTimeout(() => {
                     window.location.href = "login"; // go on login page
                  }, 1600);
               } else {
                  softAlert("danger", response.message, 30000);
               }
            },
            error: function () {
               console.log(error); // do not remove this log
               softAlert("danger", "An error occurred while registering.", 30000);
            }
         });
      });
   });
</script>