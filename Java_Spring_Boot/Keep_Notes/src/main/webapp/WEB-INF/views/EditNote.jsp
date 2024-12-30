<!-- EditNote.jsp -->
<div class="modal fade" id="noteModal" tabindex="-1" aria-labelledby="noteModalLabel" aria-hidden="true">
   <div class="modal-dialog d-flex justify-content-center align-items-center vh-100 my-0">
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
            </form>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary btn-sm" id="saveNoteChanges">Save Changes</button>
         </div>
      </div>
   </div>
</div>