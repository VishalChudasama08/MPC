<jsp:include page="header.jsp" />
<jsp:include page="Navbar.jsp" />
<jsp:include page="AddNote.jsp" />
<div>
   <h2 class="my-3">Your Notes</h2>
   <div id="notesContainer" class='row my-3 p-0'></div>
</div>
<div id="openNoteModal"></div>
<jsp:include page="EditNote.jsp" />
<!-- load note script  -->
<jsp:include page="note_script.jsp" />
<jsp:include page="footer.jsp" />