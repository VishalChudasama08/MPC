<div>
   <h2 class='my-4'>Add a Note</h2>
   <form id="addNoteSubmit">
      <div class="mb-3">
         <label for="title" class="form-label">Make Title</label>
         <input type="text" name='title' class="form-control" id="title" placeholder="what is note title ?" required />
      </div>
      <div class="mb-3">
         <label for="description" class="form-label">Enter New Note</label>
         <textarea name='description' class="form-control" id="description" placeholder='what is note description ?' rows="3" required></textarea>
      </div>
      <button type="submit" id="addNoteSubmitButton" class="btn btn-primary">Save</button>
   </form>
</div>