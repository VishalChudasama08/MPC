<div>
   <h2 class='my-4'>Add a Note</h2>
   <form id="addNoteSubmit">
      <div class="mb-3">
         <label for="title" class="form-label">Make Title</label>
         <input type="text" name='title' class="form-control" id="title" placeholder="what is note title ?" required />
         <%-- {note.title.length > 0 && note.title.length < 3 && (<small class="text-danger">{"Minimum 3 characters required"}</small>)} --%>
      </div>
      <div class="mb-3">
         <label for="description" class="form-label">Enter New Note</label>
         <textarea name='description' class="form-control" id="description" placeholder='what is note description ?' rows="3" required></textarea>
         <%-- {note.description.length > 0 && note.description.length < 5 && <small class="text-danger" data-bs-toggle="tooltip" data-bs-placement="top" title="Tooltip on top">{"Minimum 5 characters required"}</small>} --%>
      </div>
      <%-- disabled={note.title.length < 3 || note.description.length < 5} --%>
      <button type="submit" id="addNoteSubmitButton" class="btn btn-primary">Save</button>
   </form>
</div>