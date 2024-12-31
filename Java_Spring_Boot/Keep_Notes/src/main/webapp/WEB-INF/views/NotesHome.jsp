<jsp:include page="header.jsp" />
<jsp:include page="Navbar.jsp" />
<%-- <div>
   <h3>User Info</h3>
   <p>User ID: ${loggedInUser.id}</p>
   <p>User Name: <% out.println(loggedInUser.getFirstName()) %></p>
</div> --%>
<jsp:include page="AddNote.jsp" />

<h3>Pinned Notes</h3>
<div id="pinnedNotesContainer" class='row my-3 p-0'></div>

<h3 class="my-3">Your All Notes</h3>
<div id="allNotes">
   <div id="notesContainer" class='row my-3 p-0'></div>
</div>

<div id="openNoteModal"></div>
<jsp:include page="EditNote.jsp" />
<!-- load note script  -->
<jsp:include page="note_script.jsp" />
<jsp:include page="footer.jsp" />