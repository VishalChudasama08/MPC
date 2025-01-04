<%@ include file="sessionVariables.jsp" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/KeepNotes">MyNotes</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a id="NotesHomeNavButton" class="nav-link active" href="/KeepNotes/NotesHome">Notes</a>
                </li>
                <li class="nav-item" id="profileButton">
                    <% if (loggedInUser != null) { %>
                        <button class="nav-link active" data-bs-toggle="modal" data-bs-target="#profileModal">Profile</button>
                        <jsp:include page="ProfileModal.jsp" />
                        <jsp:include page="ProfileModal_script.jsp" />
                    <% } else { %>
                        <span id="userNotLogin">User is not logged in or information is not available.</span>
                        <%-- This reload problem solving by create Profile Button and modal by js and put condition sessionStorage.getItem("UserFirstName") !== null than show Profile Button--%>
                    <% } %>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/KeepNotes/About">About Us</a>
                </li>
            </ul>
            <div class="d-flex">
                <a id="loginButton" href="/KeepNotes/login" class="btn btn-outline-primary btn-sm me-2">Login</a>
                <a id="registerButton" href="/KeepNotes/register" class="btn btn-outline-primary  btn-sm">SignUp</a>
                <a id="logoutButton" href="/KeepNotes/logout" class="btn btn-outline-primary  btn-sm me-2" onClick="handleLogout()" >Logout</a>
            </div>
        </div>
    </div>
</nav>
<jsp:include page="preload_script.jsp" />
<div class="container" id="mainContainer">
    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
    </symbol>
    <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
    </symbol>
    </svg>
    <div id="alertDiv"></div>