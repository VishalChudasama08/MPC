<!-- OpenNote.jsp -->
<div class="modal fade" id="openFullNoteModal" tabindex="-1" aria-labelledby="fullNoteModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-body">
            <h5 class="card-header" id="noteTitle"></h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            <p class="card-text mb-2" id="noteDescription"></p>
            <p class="card-text"><small class="text-muted" id="noteCreateDate"></small></p>
            <div class="iconDiv row border-0 position-absolute m-0 p-2" style="bottom: -40px;z-index: 1;">
               <div class="col-3">
                  <i class="far fa-edit text-primary" onClick="editNote(JSON.stringify(note))" data-bs-toggle="modal" data-bs-target="#noteModal"></i>
               </div>
               <div class="col-3">
                  <i class="fa-solid fa-palette text-primary"></i>
               </div>
               <div class="col-3">
                  <i onClick="deleteNote(note.id)" class="far fa-trash-alt text-danger"></i>
               </div>
            </div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
         </div>
      </div>
   </div>
</div>