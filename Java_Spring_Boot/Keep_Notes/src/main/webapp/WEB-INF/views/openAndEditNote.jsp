<!-- openAndEditNote.jsp -->
<div class="modal fade" id="noteModal" tabindex="-1" aria-labelledby="noteModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title" id="noteModalLabel">Edit Note</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
         </div>
         <div class="modal-body">
            <form id="editNoteForm">
               <div class="mb-3">
                  <label for="editTitle" class="form-label">Title</label>
                  <input type="text" class="form-control" id="editTitle" name="title" required>
               </div>
               <div class="mb-3">
                  <label for="editDescription" class="form-label">Description</label>
                  <textarea class="form-control" id="editDescription" name="description" rows="4" required></textarea>
               </div>
               <input type="hidden" id="editNoteId">
               <div id="editMessage" class="text-center"></div>
            </form>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="saveNoteChanges">Save Changes</button>
         </div>
      </div>
   </div>
</div>

<script>
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


   $(document).ready(function () {
      $("#saveNoteChanges").click(async function () {
         const updatedNoteData = {
            id: $("#editNoteId").val(),
            title: $("#editTitle").val(),
            description: $("#editDescription").val()
         };

         const url = "/api/note/" + $("#editNoteId").val();
         // console.log(url);
         try {
            const response = await fetch(url, {
               method: "PUT",
               headers: { "Content-Type": "application/json" },
               body: JSON.stringify(updatedNoteData)
            });
            const responseData = await response.json();

            if (responseData.status === "success") {
               $("#editMessage").text(responseData.message).css("color", "green");
               setTimeout(() => {
                  $("#noteModal").modal('hide'); // Close the modal
                  location.reload(true); // Refresh notes
               }, 1000);
            } else {
               $("#editMessage").text(responseData.message).css("color", "red");
            }
         } catch (error) {
            console.error("Error updating note:", error);
            $("#editMessage").text("An error occurred.").css("color", "red");
         }
      });
   });
</script>
