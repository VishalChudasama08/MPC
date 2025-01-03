<script>
   if (sessionStorage.getItem("UserName") == null && sessionStorage.getItem("UserId") == null) {
      window.location.href = "/KeepNotes/login";
   }

   // const loggedInUser = {
   //    id: "${loggedInUser.id}",
   //    firstName: "${loggedInUser.firstName}",
   //    lastName: "${loggedInUser.lastName}",
   //    email: "${loggedInUser.email}",
   //    password: "${loggedInUser.password}",
   //    phoneNumber: "${loggedInUser.phoneNumber}",
   //    createDate: "${loggedInUser.createDate}"
   // };
   // console.log(loggedInUser);
   // console.log(loggedInUser.firstName);
   // console.log("loggedInUser");
   // console.log("loggedInUser.firstName");

   async function pinNote(note) {
      note.pinned = !note.pinned;// Update the pinned status in the note object

      // update in database
      let url = "/KeepNotes/api/note/pin/" + note.id + "/pinned?pinned=" + note.pinned;
      console.log(url);

      try {
         const response = await fetch(url, { method: "PUT" });
         const data = await response.json();

         // swap icon on current open modal
         const modalPin = document.getElementById('pin' + note.id)
         if (modalPin !== null) {
            if (note.pinned) {
               modalPin.innerHTML = "<i class='fa-solid text-warning fa-ban' onclick='pinNote(" + JSON.stringify(note) + ")' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='Unpin note'></i>";
            } else {
               modalPin.innerHTML = "<i class='fa-solid fa-thumbtack text-warning' onclick='pinNote(" + JSON.stringify(note) + ")' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='Pin note'></i>";
            }
         }

         // update in UI
         createNoteCard(note);

         softAlert(data.status, data.message, 1500); // Show success message
      } catch (error) {
         console.error("Error where set note background-color:", error);
         softAlert("danger", "Error when trying to set note color ", 30000);
      }
   }

   function setNoteBGC(note, color) {
      // update in UI
      note.bg_color = color;
      createNoteCard(note);

      let thisModal = '#modal' + note.id;
      $(thisModal).css("background-color", color);

      // update in db
      updateBGCinDB(note.id, color);
   }
   async function updateBGCinDB(id, color) {
      let url = "/KeepNotes/api/note/bgColor/" + id + "/color?color=" + color;
      console.log("update bg color endpoint:- ", url);

      try {
         const response = await fetch(url, { method: "PUT" });
         const data = await response.json();
         softAlert(data.status, data.message, 1500); // Show success message
      } catch (error) {
         console.error("Error where set note background-color:", error);
         softAlert("danger", "Error when trying to set note color ", 30000);
      }
   }
   function getColorPaletteElement(note) {
      console.log("normal note: ", note);
      console.log("stringify note: ", JSON.stringify(note));

      return "<!-- color Palette start -->" +
         "<ul class='dropdown-menu p-2' aria-labelledby='dropdownMenuButton" + note.id + "'>" +
         "<div class='d-flex'>" +
         "<li class='p-1 me-1 border border-danger rounded-circle d-flex justify-content-center align-items-center' onclick='setNoteBGC(" + JSON.stringify(note) + ", ``)' style='width: 30px;height: 30px;'>" +
         "<i class='fa-solid fa-droplet-slash' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='Default'></i>" +
         "</li>" +
         "<li class='me-1 d-flex justify-content-center align-items-center'>" +
         "<span class='border border-danger rounded-circle' type='button' onclick='setNoteBGC(" + JSON.stringify(note) + ", `springgreen`)' style='background-color:springgreen;width: 30px;height: 30px;'></span>" +
         "</li>" +
         "<li class='me-1 d-flex justify-content-center align-items-center'>" +
         "<span class='border border-danger rounded-circle' type='button' onclick='setNoteBGC(" + JSON.stringify(note) + ", `darkolivegreen`)' style='background-color:darkolivegreen;width: 30px;height: 30px;'></span>" +
         "</li>" +
         "<li class='me-1 d-flex justify-content-center align-items-center'>" +
         "<span class='border border-danger rounded-circle' type='button' onclick='setNoteBGC(" + JSON.stringify(note) + ", `coral`)' style='background-color:coral;width: 30px;height: 30px;'></span>" +
         "</li>" +
         "<li class='me-1 d-flex justify-content-center align-items-center'>" +
         "<span class='border border-danger rounded-circle' type='button' onclick='setNoteBGC(" + JSON.stringify(note) + ", `slateblue`)' style='background-color:slateblue;width: 30px;height: 30px;'></span>" +
         "</li>" +
         "<li class='me-1 d-flex justify-content-center align-items-center'>" +
         "<span class='border border-danger rounded-circle' type='button' onclick='setNoteBGC(" + JSON.stringify(note) + ", `goldenrod`)' style='background-color:goldenrod;width: 30px;height: 30px;'></span>" +
         "</li>" +
         "<li class='me-1 d-flex justify-content-center align-items-center'>" +
         "<span class='border border-danger rounded-circle' type='button' onclick='setNoteBGC(" + JSON.stringify(note) + ", `greenyellow`)' style='background-color:greenyellow;width: 30px;height: 30px;'></span>" +
         "</li>" +
         "<li class='me-1 d-flex justify-content-center align-items-center'>" +
         "<span class='border border-danger rounded-circle' type='button' onclick='setNoteBGC(" + JSON.stringify(note) + ", `violet`)' style='background-color:violet;width: 30px;height: 30px;'></span>" +
         "</li>" +
         "<li class='me-1 d-flex justify-content-center align-items-center'>" +
         "<span class='border border-danger rounded-circle' type='button' onclick='setNoteBGC(" + JSON.stringify(note) + ", `deepskyblue`)' style='background-color:deepskyblue;width: 30px;height: 30px;'></span>" +
         "</li>" +
         "<li class='d-flex justify-content-center align-items-center'>" +
         "<span class='border border-danger rounded-circle' type='button' onclick='setNoteBGC(" + JSON.stringify(note) + ", `slategray`)' style='background-color:slategray;width: 30px;height: 30px;'></span>" +
         "</li>" +
         "</div>" +
         "</ul>" +
         "<!-- color Palette end -->";
   }
   async function openNote(nId) {

      try {
         let url = "/KeepNotes/api/note/" + nId; // fetch this note endpoint
         console.log("fetch this note endpoint for open note:- " + url);

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

         console.log("modal note data: ", JSON.stringify(note));


         let formatCreateDateAndTime = note.created_date[3] + ":" + note.created_date[4] + ", " + note.created_date[2] + "-" + note.created_date[1] + "-" + note.created_date[0];
         let formatEditDate = "";
         let formatEditDateAndTimeElement = "";
         if (note.created_date !== note.updated_date) {
            formatEditDateAndTimeElement = "<br><small id='noteUpdatedDate'>Edit at " + note.updated_date[3] + ":" + note.updated_date[4] + ", " + note.updated_date[2] + "-" + note.updated_date[1] + "-" + note.updated_date[0] + "</small>";
         }

         let pin_tooltip = "";
         if (note.pin_icon === "ban") {
            pin_tooltip = "Unpin note";
         } else {
            pin_tooltip = "Pin note";
         }
         // Format the description for HTML rendering
         const formattedDescription = note.description.replace(/\n/g, "<br>");

         const openNoteModal = document.getElementById('openNoteModal');
         openNoteModal.innerHTML = "<!-- OpenNote.jsp -->" +
            "<div class='modal fade' id='openFullNoteModal' tabindex='-1' aria-labelledby='fullNoteModalLabel' aria-hidden='true'>" +
            "<div class='modal-dialog modal-dialog-scrollable d-flex justify-content-center align-items-center vh-100 my-0'>" +
            "<div class='modal-content' id='modal" + note.id + "' style='background-color:" + note.bg_color + ";'>" +
            "<div class='icons modal-header row m-0 p-3'>" +
            "<div class='col-2 d-flex justify-content-center align-items-center'>" +
            "<i class='far fa-edit text-primary' onclick='editNote(" + note.id + ")' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='Edit note'></i>" +
            "</div>" +
            "<div class='col-2 d-flex justify-content-center align-items-center'>" +
            "<i class='fa-solid fa-palette text-primary' id='dropdownMenuButton" + note.id + "' data-bs-toggle='dropdown' aria-expanded='false' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='Set color'></i>" +
            getColorPaletteElement(note) +
            "</div>" +
            "<div class='col-2 d-flex justify-content-center align-items-center'>" +
            "<i class='far fa-trash-alt text-danger' onclick='deleteNote(" + note.id + ")' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='Delete this note'></i>" +
            "</div>" +
            "<div class='col-2 d-flex justify-content-center align-items-center' id='pin" + note.id + "'>" +
            "<i class='fa-solid fa-" + note.pin_icon + " text-warning' onclick='pinNote(" + JSON.stringify(note) + ")' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='" + pin_tooltip + "'></i>" +
            "</div>" +
            "<div class='col-4 d-flex justify-content-center align-items-center' style='direction: rtl;'>" +
            "<button type='button' class='btn-close btn-primary btn-sm' data-bs-dismiss='modal' aria-label='Close' style='height: 5px;'></button>" +
            "</div>" +
            "</div>" +
            "<div class='modal-body'>" +
            "<h5 id='noteTitle'>" + note.title + "</h5>" +
            "<p id='noteDescription'>" + formattedDescription + "</p>" +
            "<small><h6>Note Details:</h6></small>" +
            "<p><small id='noteCreateDate'>Create at " + formatCreateDateAndTime + "</small>" + formatEditDateAndTimeElement + "</small></p>" +
            "</div>" +
            "</div>" +
            "</div>" +
            "</div";
         formatEditDateAndTimeElement = "";
         formatCreateDateAndTime = "";
         $(document).ready(await function () {
            $("#openFullNoteModal").modal('show');
            <jsp:include page="style.jsp" />
         })

      } catch (error) {
         console.error("Error fetching notes:", error); // Only log *actual* errors
      }
   }

   function createNoteCard(note) {
      let noteExist = document.getElementById('note' + note.id);
      if (noteExist) {
         noteExist.remove(); // if this not card exist than remove it 
      }

      let bgColor = "";
      if (note.bg_color !== null || note.bg_color !== '') { // if bg color not set or null than
         bgColor = note.bg_color;
      }
      note.bg_color = bgColor;

      let goHere = document.getElementById('notesContainer');
      let pinIcon = "thumbtack";

      if (note.pinned) {
         goHere = document.getElementById('pinnedNotesContainer');
         pinIcon = "ban";
      }
      note = { ...note, "pin_icon": pinIcon }
      // console.log("edited note data: " + JSON.stringify(note));

      let pin_tooltip = "";
      if (note.pin_icon === "ban") {
         pin_tooltip = "Unpin note";
      } else {
         pin_tooltip = "Pin note";
      }

      // Format the description for HTML rendering
      const formattedDescription = note.description.replace(/\n/g, "<br>");

      goHere.innerHTML += "<div class='col-lg-3 col-md-4 col-sm-6 p-0 mt-0' id='note" + note.id + "' style='margin-bottom:36px;'>" +
         "<div class='icons card m-1 position-relative'>" +
         "<span class='hideIcon pin-icon position-absolute rounded-start my-2 px-2'>" +
         "<i class='fa-solid fa-" + note.pin_icon + " text-warning' onclick='pinNote(" + JSON.stringify(note) + ")' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='" + pin_tooltip + "'></i>" +
         "</span>" +
         "<div class='card-body pb-0 rounded' id='card" + note.id + "' style='background-color: " + note.bg_color + ";' onclick='openNote(" + note.id + ")'>" +
         "<h6 class='card-title'>" + note.title + "</h6>" +
         "<p class='card-text mb-2'>" + formattedDescription.split(/\s+/).slice(0, 30).join(' ') + "</p>" +
         "</div>" +
         "<div class='iconDiv row border-0 position-absolute m-0 p-2' style='bottom: -40px;z-index: 1;'>" +
         "<div class='hideIcon col-4'>" +
         "<i class='far fa-edit text-primary' onclick='editNote(" + note.id + ")' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='Edit note'></i>" +
         "</div>" +
         "<div class='hideIcon col-4'>" +
         "<i class='fa-solid fa-palette text-primary' id='dropdownMenuButton" + note.id + "' data-bs-toggle='dropdown' aria-expanded='false' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='Set color'></i>" +
         getColorPaletteElement(note) +
         "</div>" +
         "<div class='hideIcon col-4'>" +
         "<i onclick='deleteNote(" + note.id + ")' class='far fa-trash-alt text-danger' data-bs-toggle='tooltip' data-bs-placement='top' data-bs-delay='{`show`:500, `hide`:100}' data-bs-title='Delete this note'></i>" +
         "</div>" +
         "</div>" +
         "</div>" +
         "</div>";
   }

   //////////////////
   // fetch all note
   //////////////////
   async function fetchAndDisplayNotes() {
      let userId = sessionStorage.getItem("UserId");
      if (!userId) {
         console.error("User ID is missing in session storage.");
         document.getElementById('notesContainer').innerHTML = "<p>Please log in to view notes.</p>";
         if (alert("Please log in to view notes.")) {
            window.location.href = "/KeepNotes/login";
         }
         return;
      }

      let url = "/KeepNotes/api/note/" + userId; // fetch all note endpoint
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

         const pinnedContainer = document.getElementById('pinnedNotesContainer');
         pinnedContainer.innerHTML = ''; // Clear previous content

         if (allNotes.length === 0) { // for this use no any notes than 
            notesContainer.innerHTML = "<p>No notes found.</p>";
            return;
         }

         allNotes.forEach(note => {
            createNoteCard(note);
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
            "userId": sessionStorage.getItem("UserId"),
            "title": $("#title").val(),
            "description": $("#description").val()
         };

         // Make AJAX request
         const response = await $.ajax({
            url: "/KeepNotes/api/note/addNote", // add new note endpoint
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(noteData),
         });

         if (response.status === "success") {
            console.log("Add New Note at endpoint:- " + "/KeepNotes/api/note/addNote", noteData);
            softAlert(response.status, response.message, 2000);

            $("#title").val("");
            $("#description").val("");
            $("#addNoteSubmitButton").prop("disabled", true); // make disable button

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
         let url = "/KeepNotes/api/note/" + id; // fetch this note endpoint
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

      const url = "/KeepNotes/api/note/" + $("#editNoteId").val(); // edit note endpoint
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
         softAlert("danger", "Note not edited due to some error", 30000);
      }
   });

   ///////////////
   // delete note
   ///////////////
   async function deleteNote(noteId) {
      $("#openFullNoteModal").modal('hide'); // if delete from open full note modal than hide modal first

      try {
         const url = "/KeepNotes/api/note/" + noteId; // delete note endpoint
         console.log("delete note endpoint:- " + url);

         const response = await fetch(url, { method: "DELETE" });
         const data = await response.json();
         softAlert(data.status, data.message, 2000); // Show success message

         let noteExist = document.getElementById('note' + noteId);
         if (noteExist) { noteExist.remove(); } // if this not card exist than remove it
      } catch (error) {
         console.error("Error deleting note:", error);
         softAlert("danger", "note not delete. some error occurred.", 30000);
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