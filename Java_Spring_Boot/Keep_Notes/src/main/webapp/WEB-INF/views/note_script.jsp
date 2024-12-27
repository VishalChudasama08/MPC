<script>
   async function openNote(noteString) {
      try {
         const note = await typeof noteString === "string" ? JSON.parse(noteString) : noteString;

         let createdDate = note.created_date.slice(0, 10).split('-');
         let formatCreateDateAndTime = note.created_date.slice(11, 16) + ", " + createdDate[2] + "-" + createdDate[1] + "-" + createdDate[0];
         let formatEditDate = "";
         if (note.created_date !== note.updated_date) {
            let updatedDate = note.updated_date.slice(0, 10).split('-');
            formatEditDateAndTimeElement = "<br><small id='noteUpdatedDate'>Edit at " + note.updated_date.slice(11, 16) + ", " + updatedDate[2] + "-" + updatedDate[1] + "-" + updatedDate[0] + "</small>";
         }

         const openNoteModal = document.getElementById('openNoteModal');
         openNoteModal.innerHTML = '<!-- OpenNote.jsp -->' +
            '<div class="modal fade" id="openFullNoteModal" tabindex="-1" aria-labelledby="fullNoteModalLabel" aria-hidden="true">' +
            '<div class="modal-dialog">' +
            '<div class="modal-content">' +
            '<div class="modal-body">' +
            '<div class="iconDiv row border-0 m-0 p-2">' +
            '<div class="col-3 d-flex justify-content-center align-items-center">' +
            '<i class="far fa-edit text-primary" onClick="editNote(' + note.id + ')"></i>' +
            '</div>' +
            '<div class="col-3 d-flex justify-content-center align-items-center">' +
            '<i class="fa-solid fa-palette text-primary"></i>' +
            '</div>' +
            '<div class="col-3 d-flex justify-content-center align-items-center">' +
            '<i onClick="deleteNote(' + note.id + ')" class="far fa-trash-alt text-danger"></i>' +
            '</div>' +
            '<div class="col-3 d-flex justify-content-center align-items-center" style="direction: rtl;">' +
            '<button type="button" class="btn-close btn-primary btn-sm" data-bs-dismiss="modal" aria-label="Close" style="height: 5px;"></button>' +
            '</div>' +
            '</div>' +
            '<h5 id="noteTitle">' + note.title + '</h5>' +
            '<p id="noteDescription">' + note.description + '</p>' +
            '<small><h6>Note Details:</h6></small>' +
            '<p><small id="noteCreateDate">Create at ' + formatCreateDateAndTime + '</small>' + formatEditDateAndTimeElement + '</small></p>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
         formatEditDateAndTimeElement = "";
         $(document).ready(await function () {
            $("#openFullNoteModal").modal('show');
            <jsp:include page="style.jsp" />
         })
      } catch (error) {
         console.error("Error parsing note data:", error);
      }
   }

   //////////////////
   // fetch all note
   //////////////////
   async function fetchAndDisplayNotes() {
      let userId = sessionStorage.getItem("UserId");
      if (!userId) {
         console.error("User ID is missing in session storage.");
         document.getElementById('notesContainer').innerHTML = "<p>Please log in to view notes.</p>";
         return;
      }

      let url = "/api/note/" + userId; // fetch all note endpoint
      console.log("fetch all note endpoint:- " + url);

      try {
         const response = await fetch(url);
         if (!response.ok) {
            if (response.status === 404) { // Specific check for 404
               const errorText = await response.text();
               // Handle "No notes found" as a special case
               document.getElementById('notesContainer').innerHTML = "<p>" + errorText + "</p>"; // No error class needed
               return; // Stop further processing, no need to throw an error
            } else {
               // For other errors (not 404), throw the error to be caught below
               const errorText = await response.text();
               throw new Error(errorText);
            }
         }

         const allNotes = await response.json();

         if (!Array.isArray(allNotes)) {
            throw new Error('Unexpected response format: Expected an array.');
         }
         console.log('Fetched data: ', allNotes);

         const notesContainer = document.getElementById('notesContainer');
         notesContainer.innerHTML = ''; // Clear previous content

         if (allNotes.length === 0) { // for this use no any notes than 
            notesContainer.innerHTML = "<p>No notes found.</p>";
            return;
         }

         allNotes.forEach(note => {
            notesContainer.innerHTML +=
               "<div class='col-lg-3 col-md-4 col-sm-6 p-0 mt-0' style='margin-bottom:36px;'>" +
               "<div class='card m-1 position-relative'>" +
               "<span class='hideIcon pin-icon position-absolute rounded-start text-warning my-2 px-2'>" +
               "<i class='fa-solid fa-thumbtack'></i>" +
               "</span>" +
               "<div class='card-body pb-0' onClick='openNote(" + JSON.stringify(note) + ")'>" +
               "<h6 class='card-title'>" + note.title + "</h6>" +
               "<p class='card-text mb-2'>" + note.description + "</p>" +
               "</div>" +
               "<div class='iconDiv row border-0 position-absolute m-0 p-2' style='bottom: -40px;z-index: 1;'>" +
               "<div class='hideIcon col-3'>" +
               "<i class='far fa-edit text-primary' onClick='editNote(" + note.id + ")'></i>" +
               "</div>" +
               "<div class='hideIcon col-3'>" +
               "<i class='fa-solid fa-palette text-primary'></i>" +
               "</div>" +
               "<div class='hideIcon col-3'>" +
               "<i onClick='deleteNote(" + note.id + ")' class='far fa-trash-alt text-danger'></i>" +
               "</div>" +
               "</div>" +
               "</div>" +
               "</div>";
         });
      } catch (error) {
         console.error("Error fetching notes:", error); // Only log *actual* errors
         document.getElementById('notesContainer').innerHTML = "<p class='error'>An error occurred while loading notes.</p>"; // Generic error message for unexpected errors
      }

      <jsp:include page="style.jsp" />
   }

   ////////////
   // add note 
   ////////////
   $("#addNoteSubmit").submit(async function (event) {
      event.preventDefault(); // Prevent page reload

      try {
         // Collect form data
         const noteData = {
            userId: sessionStorage.getItem("UserId"),
            title: $("#title").val(),
            description: $("#description").val()
         };

         // Make AJAX request
         const response = await $.ajax({
            url: "/api/note/addNote", // add new note endpoint
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(noteData),
         });

         if (response.status === "success") {
            softAlert(response.status, response.message, 2000);

            $("#title").val("");
            $("#description").val("");

            fetchAndDisplayNotes(); // re-fetch note for showing new added note 
         } else {
            softAlert("danger", response.message, 30000);
         }
      } catch (error) {
         console.error("Error during note submission:", error);
         softAlert("danger", "An error occurred while adding the note.", 30000);
      }
      history.replaceState(null, "", window.location.pathname) // remove url data
   });

   /////////////
   // edit note
   /////////////
   async function editNote(id) {
      $("#openFullNoteModal").modal('hide');
      $("#noteModal").modal('show');
      try {
         let url = "/api/note/" + id; // fetch this note endpoint
         console.log("fetch this note endpoint:- " + url);

         const response = await fetch(url, { method: "POST", headers: { "Content-Type": "application/json" } });
         if (!response.ok) {
            if (response.status === 404) { // Specific check for 404
               const errorText = await response.text();
               // Handle "No notes found" as a special case
               document.getElementById('notesContainer').innerHTML = "<p>" + errorText + "</p>"; // No error class needed
               return; // Stop further processing, no need to throw an error
            } else {
               // For other errors (not 404), throw the error to be caught below
               const errorText = await response.text();
               throw new Error(errorText);
            }
         }

         const note = await response.json();

         // Populate modal fields with note data
         $("#editTitle").val(note.title);
         $("#editDescription").val(note.description);
         $("#editNoteId").val(note.id);
         $("#editMessage").text(""); // Clear any previous messages
      } catch (error) {
         console.error("Error fetching notes:", error); // Only log *actual* errors
      }
   }

   $("#saveNoteChanges").click(async function () {
      const updatedNoteData = {
         id: $("#editNoteId").val(),
         title: $("#editTitle").val(),
         description: $("#editDescription").val()
      };

      const url = "/api/note/" + $("#editNoteId").val(); // edit note endpoint
      console.log("edit note endpoint:- " + url);
      try {
         const response = await fetch(url, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(updatedNoteData)
         });
         const responseData = await response.json();

         if (responseData.status === "success") {
            softAlert(responseData.status, responseData.message, 2000);
            setTimeout(() => {
               $("#noteModal").modal('hide'); // Close the modal

               fetchAndDisplayNotes(); // re-fetch all note
            }, 200);
         } else {
            softAlert("danger", responseData.message, 30000);
         }
      } catch (error) {
         console.error("Error updating note:", error);
         softAlert("danger", "Note not edited due to same error", 30000);
      }
   });

   ///////////////
   // delete note
   ///////////////
   async function deleteNote(noteId) {
      $("#openFullNoteModal").modal('hide'); // if delete from open full note modal than hide modal first
      const url = "/api/note/" + noteId; // delete note endpoint
      console.log("delete note endpoint:- " + url);

      try {
         const response = await fetch(url, { method: "DELETE" });
         const data = await response.json();
         softAlert(data.status, data.message, 2000); // Show success message

         fetchAndDisplayNotes(); // re-fetch note for remove deleted note
      } catch (error) {
         console.error("Error deleting note:", error);
         softAlert("danger", data.message, 30000);
      }
   }

   $(document).ready(function () {
      function toggleAddNoteButtonDisability() {
         // boolean 
         const allFieldsFilled = $("#title").val() !== '' && $("#description").val() !== '';

         $("#addNoteSubmitButton").prop("disabled", !allFieldsFilled); // Enable if all fields are filled
      }

      // Attach event listeners to all input fields
      $("#title, #description").on('input', function () {
         toggleAddNoteButtonDisability();
      });

      // on page load
      toggleAddNoteButtonDisability();

      // Fetch and display notes when the page loads
      window.onload = fetchAndDisplayNotes;
   });
</script>