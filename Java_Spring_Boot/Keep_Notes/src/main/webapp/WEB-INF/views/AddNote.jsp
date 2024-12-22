<div>
   <h2 class='my-4'>Add a Note</h2>
   <div id="message"></div>
   <form id="addNoteSubmit">
      <div class="mb-3">
         <label for="title" class="form-label">Make Title</label>
         <input type="text" name='title' onChange={onChange} class="form-control" id="title" placeholder="what is note title ?" required />
         <%-- {note.title.length > 0 && note.title.length < 3 && (<small class="text-danger">{"Minimum 3 characters required"}</small>)} --%>
      </div>
      <div class="mb-3">
         <label for="description" class="form-label">Enter New Note</label>
         <textarea name='description' onChange={onChange} class="form-control" id="description" placeholder='what is note description ?' rows="3" required></textarea>
         <%-- {note.description.length > 0 && note.description.length < 5 && <small class="text-danger" data-bs-toggle="tooltip" data-bs-placement="top" title="Tooltip on top">{"Minimum 5 characters required"}</small>} --%>
      </div>
      <%-- disabled={note.title.length < 3 || note.description.length < 5} --%>
      <button type="submit" class="btn btn-primary" onClick={handleSubmitNote}>Submit</button>
   </form>
</div>
<script>
   $(document).ready(function() {
      $("#addNoteSubmit").submit(function(event) {
         event.preventDefault(); // Prevent page reload
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
            success: function(response) {
               if (response.status === "success") {
                  $("#message").text(response.message).css("color", "green");
               } else {
                  $("#message").text(response.message).css("color", "red");
               }
            },
            error: function() {
               $("#message").text("An error occurred while registering.").css("color", "red");
            }
         });
      });
   });
</script>