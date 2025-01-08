<script>
   $(document).ready(function () {
      if (sessionStorage.getItem("UserId") !== null) {
         console.log("profile okay");

         let profileContent = document.getElementById("profileContent");
         profileContent.innerHTML = '<button class="nav-link active" data-bs-toggle="modal" data-bs-target="#profileModal">Profile</button>' +
            '<!-- ProfileModal.jsp -->' +
            '<div class="modal fade" id="profileModal" tabindex="-1" aria-labelledby="profileModalLabel" aria-hidden="true">' +
            '<div class="modal-dialog d-flex justify-content-center align-items-center vh-100 my-0">' +
            '<div class="modal-content">' +
            '<div class="modal-header">' +
            '<h5 class="modal-title" id="profileModalLabel">User Details</h5>' +
            '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>' +
            '</div>' +
            '<div class="modal-body">' +
            '<p id="infoEditable" style="color: blue;">Now edit your information...</p>' +
            '<form id="profileForm">' +
            '<div class="mb-3">' +
            '<label for="firstName" class="form-label">First Name</label>' +
            '<input type="text" class="form-control" id="pFirstName" name="firstName" value="' + sessionStorage.getItem("UserName") + '" disabled />' +
            '</div>' +
            '<div class="mb-3">' +
            '<label for="lastName" class="form-label">Last Name</label>' +
            '<input type="text" class="form-control" id="pLastName" name="lastName" value="' + sessionStorage.getItem("UserLastName") + '" disabled />' +
            '</div>' +
            '<div class="mb-3">' +
            '<label for="email" class="form-label">Email </label>' +
            '<input type="email" class="form-control" id="pEmail" name="email" aria-describedby="emailHelp" value="' + sessionStorage.getItem("UserEmail") + '" disabled />' +
            '</div>' +
            '<div class="mb-3">' +
            '<label for="phoneNumber" class="form-label">Phone Number</label><i style="font-size: small;" class="fa-solid fa-info bg-warning-subtle rounded-circle py-1 px-2" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-custom-class="custom-tooltip" data-bs-title="for recovery password and account."></i>' +
            '<input type="number" class="form-control" id="pPhoneNumber" name="phoneNumber" value="' + sessionStorage.getItem("UserPhoneNumber") + '" disabled />' +
            '</div>' +
            '</form>' +
            '</div>' +
            '<div class="modal-footer">' +
            '<button type="button" class="btn text-danger position-absolute start-0" id="deleteAccount">Delete Account</button>' +
            '<button type="button" class="btn btn-outline-info btn-sm" id="editProfileBtn" >Edit Info</button>' +
            '<button type="button" class="btn btn-outline-secondary btn-sm" id="cancelEditingBtn" >Cancel editing</button>' +
            '<button type="button" class="btn btn-outline-primary btn-sm" id="saveProfileChanges">Save Changes</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';

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
            $('#pFirstName').val(sessionStorage.getItem("UserName")).prop('disabled', true);
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

            let url = "/api/user/updateUser/" + sessionStorage.getItem("UserId");
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

                  sessionStorage.setItem("UserName", updateUserDetails.firstName);
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
                  const url = "/api/user/deleteUser/" + sessionStorage.getItem("UserId"); // delete user endpoint
                  console.log("delete user endpoint:- " + url);

                  const response = await fetch(url, { method: "DELETE" });
                  const data = await response.json();
                  if (data.status === "success") {
                     $("#profileModal").modal('hide'); // if delete than hide modal
                     sessionStorage.clear();
                     await new Promise(resolve => setTimeout(function () {
                        window.location.href = "/register";
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
      }
   })
</script>