<!-- ProfileModal.jsp -->
<div class="modal fade" id="profileModal" tabindex="-1" aria-labelledby="profileModalLabel" aria-hidden="true">
   <div class="modal-dialog d-flex justify-content-center align-items-center vh-100 my-0">
      <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title" id="profileModalLabel">Hello ${loggedInUser.firstName}</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
         </div>
         <div class="modal-body">
            <p id="infoEditable" style="color: blue;">Now edit your information...</p>
            <form id="profileForm">
               <div class="mb-3">
                  <label for="firstName" class="form-label">First Name</label>
                  <input type="text" class="form-control" id="pFirstName" name="firstName" value="${loggedInUser.firstName}" disabled />
               </div>
               <div class="mb-3">
                  <label for="lastName" class="form-label">Last Name</label>
                  <input type="text" class="form-control" id="pLastName" name="lastName" value="${loggedInUser.lastName}" disabled />
               </div>
               <div class="mb-3">
                  <label for="email" class="form-label">Email </label>
                  <input type="email" class="form-control" id="pEmail" name="email" aria-describedby="emailHelp" value="${loggedInUser.email}" disabled />
               </div>
               <div class="mb-3">
                  <label for="phoneNumber" class="form-label">Phone Number</label><i style="font-size: small;" class="fa-solid fa-info bg-warning-subtle rounded-circle py-1 px-2" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-custom-class="custom-tooltip" data-bs-title="for recovery password and account."></i>
                  <input type="number" class="form-control" id="pPhoneNumber" name="phoneNumber" value="${loggedInUser.phoneNumber}" disabled />
               </div>
            </form>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn text-danger position-absolute start-0" id="deleteAccount">Delete Account</button>
            <button type="button" class="btn btn-outline-info btn-sm" id="editProfileBtn" >Edit Info</button>
            <button type="button" class="btn btn-outline-secondary btn-sm" id="cancelEditingBtn" >Cancel editing</button>
            <button type="button" class="btn btn-outline-primary btn-sm" id="saveProfileChanges">Save Changes</button>
         </div>
      </div>
   </div>
</div>