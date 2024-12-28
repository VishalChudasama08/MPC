<jsp:include page="header.jsp" />
<jsp:include page="Navbar.jsp" />
<jsp:include page="AddNote.jsp" />
<div id="pinnedNotes">
<h3>Pinned <i class='fa-solid fa-thumbtack text-warning'></i></h3>
<div id="pinnedNote">
</div>
</div>
<div>
   <h3 class="my-3">Your Notes</h3>
   <div id="notesContainer" class='row my-3 p-0'></div>
</div>
<div id="openNoteModal"></div>
<jsp:include page="EditNote.jsp" />
<!-- load note script  -->
<jsp:include page="note_script.jsp" />
<jsp:include page="footer.jsp" />