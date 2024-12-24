<jsp:include page="header.jsp" />
<jsp:include page="Navbar.jsp" />
<div class="container">
   <jsp:include page="AddNote.jsp" />
   <jsp:include page="FetchNotes.jsp" />
   <script>
      async function deleteNote(noteId) {
         const url = "/api/note/" + noteId;
         console.log(url);

         try {
            const response = await fetch(url, { method: "DELETE" });
            const data = await response.json();
            alert(data.message); // Show success message
            location.reload(true); // reload page for remove deleted note
         } catch (error) {
            console.error("Error deleting note:", error);
         }
      }

      $(document).ready(function () {
         $("#addNoteSubmit").submit(function (event) {
            // event.preventDefault(); // Prevent page reload

            // Collect form data
            const noteData = {
               userId: sessionStorage.getItem("UserId"),
               title: $("#title").val(),
               description: $("#description").val()
            };

            // Make AJAX request
            $.ajax({
               url: "/api/note/addNote",
               type: "POST",
               contentType: "application/json",
               data: JSON.stringify(noteData),
               success: function (response) {
                  if (response.status === "success") {
                     $("#message").text(response.message).css("color", "green");

                     // Clear the form
                     document.getElementById("noteSubmitForm").reset();

                     // Refresh the notes to include the new one
                     fetchAndDisplayNotes();
                  } else {
                     $("#message").text(response.message).css("color", "red");
                  }
               },
               error: function () {
                  $("#message").text("An error occurred while registering.").css("color", "red");
               }
            });
         });

         function fetchAndDisplayNotes() {
            let userId = sessionStorage.getItem("UserId");
            if (!userId) {
               console.error("User ID is missing in session storage.");
               return;
            }
            let url = "/api/note/" + userId;
            console.log(url);

            fetch(url).then(response => {
               if (!response.ok) {
                  throw new Error('Failed to fetch notes: ' + response.statusText);
               }
               return response.json();
            }).then(data => {
               if (!Array.isArray(data)) {
                  throw new Error('Unexpected response format');
               }
               console.log('Fetched data:', data);
               const notesContainer = document.getElementById('notesContainer');
               notesContainer.innerHTML = '';
               data.forEach(note => {
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
                  // onClick={() => { deleteNote(${note.id}); }}
                  // onClick={() => { updateNote(${JSON.stringify(note)}); }}
               });

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

            }).catch(err => {
               console.error('Error fetching notes:', err);
            });
         }

         function editNote(note) {
            console.log(note);
         }
         // Fetch and display notes when the page loads
         window.onload = fetchAndDisplayNotes;
         history.replaceState(null, "", window.location.pathname) // remove url data
      });
   </script>
   <jsp:include page="openAndEditNote.jsp" />
</div>
<jsp:include page="footer.jsp" />