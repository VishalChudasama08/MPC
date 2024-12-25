<script>
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
               "<div class='card-body pb-0'>" +
               "<h5 class='card-title'>" + note.title + "</h5>" +
               "<p class='card-text mb-2'>" + note.description + "</p>" +
               "<p class='card-text'><small class='text-muted'>" + note.created_date + "</small></p>" +
               "</div>" +
               "<div class='iconDiv row border-0 position-absolute m-0 p-2' style='bottom: -40px;z-index: 1;'>" +
               "<div class='hideIcon col-3'>" +
               "<i class='far fa-edit text-primary' onClick='editNote(" + JSON.stringify(note) + ")' id='showModalBtn' data-bs-toggle='modal' data-bs-target='#noteModal'></i>" +
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

      /////////////////////////////////////////
      $(".hideIcon").hide();

      $(".pin-icon").css({
         "top": "0px",
         "right": "1px",
         "cursor": "pointer"
      });

      $(".iconDiv i").hover(
         function () {
            $(this).css({
               "color": "#007bff", // Highlight color on hover
               "transform": "scale(1.2)", // Slight zoom effect
               "transition": "transform 0.2s ease-in-out",
               "cursor": "pointer"
            });
         },
         function () {
            $(this).css({
               "color": "", // Reset to default
               "transform": "scale(1)", // Reset zoom effect
               "transition": "transform 0.2s ease-in-out"
            });
         }
      );

      $(".card").hover(
         function () {
            $(this).find(".hideIcon").show();
            $(this).css({
               "box-shadow": "-3px 3px 0px rgba(0, 0, 0, 0.2)", // Subtle shadow effect
               "transition": "box-shadow 0.3s ease-in-out"
            });
            $(this)
               .find(".iconDiv") // select iconDiv name tag from this card only 
               .css({
                  "box-shadow": "-3px 3px 0px rgba(0, 0, 0, 0.2)", // Subtle shadow effect
                  "transition": "box-shadow 0.3s ease-in-out"
               })
               .addClass('card-footer');
         },
         function () {
            $(this).find(".hideIcon").hide();
            $(this).css({
               "box-shadow": "", // Reset to default
               "transition": "box-shadow 0.3s ease-in-out"
            });
            $(this)
               .find(".iconDiv")
               .css({
                  "box-shadow": "", // Reset to default
                  "transition": "box-shadow 0.3s ease-in-out"
               })
               .removeClass('card-footer');
         }
      );
      /////////////////////////////////////////////
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

   function editNote(noteString) {
      try {
         const note = typeof noteString === "string" ? JSON.parse(noteString) : noteString;

         // Populate modal fields with note data
         $("#editTitle").val(note.title);
         $("#editDescription").val(note.description);
         $("#editNoteId").val(note.id);
         $("#editMessage").text(""); // Clear any previous messages
      } catch (error) {
         console.error("Error parsing note data:", error);
      }
   }

   /////////////
   // edit note
   ////////////
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