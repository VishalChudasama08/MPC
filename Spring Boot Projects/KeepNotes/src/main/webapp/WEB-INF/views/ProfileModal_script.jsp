<script>
   $(document).ready(function () {
      $('#infoEditable').hide();
      $('#editProfileBtn').show();
      $('#cancelEditingBtn').hide();
      $('#saveProfileChanges').hide();
      $('#deleteAccount').show();

      const userDetails = {
         "firstName": $('#pFirstName').val(),
         "lastName": $('#pLastName').val(),
         "email": $('#pEmail').val(),
         "phoneNumber": $('#pPhoneNumber').val()
      }
      console.log(userDetails);
      sessionStorage.setItem("UserFirstName", userDetails.firstName);
      sessionStorage.setItem("UserLastName", userDetails.lastName);
      sessionStorage.setItem("UserEmail", userDetails.email);
      sessionStorage.setItem("UserPhoneNumber", userDetails.phoneNumber);

      $('#editProfileBtn').click(function () { // enable all an input field
         $('#infoEditable').slideDown(500);
         setTimeout(function () {
            $('#infoEditable').slideUp(500);
         }, 2000)

         $('#pFirstName').prop('disabled', false);
         $('#pLastName').prop('disabled', false);
         $('#pEmail').prop('disabled', false);
         $('#pPhoneNumber').prop('disabled', false);

         $('#editProfileBtn').toggle();
         $('#cancelEditingBtn').toggle();
         $('#saveProfileChanges').toggle();
         $('#deleteAccount').toggle();
      })

      $('#cancelEditingBtn').click(function () { // set value and disable all an input field
         $('#infoEditable').slideUp(500);
         $('#pFirstName').val(sessionStorage.getItem("UserFirstName")).prop('disabled', true);
         $('#pLastName').val(sessionStorage.getItem("UserLastName")).prop('disabled', true);
         $('#pEmail').val(sessionStorage.getItem("UserEmail")).prop('disabled', true);
         $('#pPhoneNumber').val(sessionStorage.getItem("UserPhoneNumber")).prop('disabled', true);

         $('#editProfileBtn').toggle();
         $('#cancelEditingBtn').toggle();
         $('#saveProfileChanges').toggle();
         $('#deleteAccount').toggle();
      })

      ///////////////////////
      // update user details
      ///////////////////////
      $('#saveProfileChanges').click(async function () { // update user details, set value this updated values and disable all an input field
         const updateUserDetails = {
            firstName: $('#pFirstName').val(),
            lastName: $('#pLastName').val(),
            email: $('#pEmail').val(),
            phoneNumber: $('#pPhoneNumber').val()
         }

         let url = "/KeepNotes/api/user/updateUser/" + sessionStorage.getItem("UserId");
         console.log("update user details endpoint:- " + url);
         try {
            const response = await fetch(url, {
               method: "PUT",
               headers: { "Content-Type": "application/json" },
               body: JSON.stringify(updateUserDetails)
            });
            const responseData = await response.json();

            if (responseData.status === "success") {
               softAlert(responseData.status, responseData.message, 2000);

               sessionStorage.setItem("UserFirstName", updateUserDetails.firstName);
               sessionStorage.setItem("UserLastName", updateUserDetails.lastName);
               sessionStorage.setItem("UserEmail", updateUserDetails.email);
               sessionStorage.setItem("UserPhoneNumber", updateUserDetails.phoneNumber);

               $('#pFirstName').val(updateUserDetails.firstName).prop('disabled', true);
               $('#pLastName').val(updateUserDetails.lastName).prop('disabled', true);
               $('#pEmail').val(updateUserDetails.email).prop('disabled', true);
               $('#pPhoneNumber').val(updateUserDetails.phoneNumber).prop('disabled', true);

            } else {
               softAlert("danger", responseData.message, 30000);
            }
         } catch (error) {
            console.error("Error updating User Details:", error);
            softAlert("danger", "Details not edited due to same error", 30000);
         }

         $('#editProfileBtn').toggle();
         $('#cancelEditingBtn').toggle();
         $('#saveProfileChanges').toggle();
         $('#deleteAccount').toggle();
      })


      ///////////////
      // delete user
      ///////////////
      $('#deleteAccount').click(async function () { // delete account and go register page
         if (confirm("Are You sure ? You want to delete your account")) { // confirmation
            try {
               const url = "/KeepNotes/api/user/deleteUser/" + sessionStorage.getItem("UserId"); // delete user endpoint
               console.log("delete user endpoint:- " + url);

               const response = await fetch(url, { method: "DELETE" });
               const data = await response.json();
               if (data.status === "success") {
                  $("#profileModal").modal('hide'); // if delete than hide modal
                  sessionStorage.clear();
                  await new Promise(resolve => setTimeout(function () {
                     window.location.href = "/KeepNotes/register";
                     softAlert(data.status, data.message, 2000);
                     sessionStorage.clear();
                     resolve(); // Resolve the Promise
                  }, 2000)); // Wait for 2 seconds
               } else {
                  softAlert("danger", data.message, 30000);
               }
            } catch (error) {
               console.error("Error deleting user:", error);
               softAlert("danger", "user not delete. some error occurred.", 30000);
            }
         }
      })
   })
</script>