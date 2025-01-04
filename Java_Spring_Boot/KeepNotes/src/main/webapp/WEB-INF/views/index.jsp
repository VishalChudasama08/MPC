<jsp:include page="header.jsp" />
<jsp:include page="Navbar.jsp" />
<br>
<h3>Welcome to Keep Notes</h3>
<br>
<p><strong>Keep Notes</strong> is a simple, secure, and user-friendly web application designed to help you organize your notes effectively. Whether you’re capturing ideas, managing tasks, or jotting down important information, Keep Notes provides the perfect platform to manage your thoughts securely.</p>
<br>
<h5><strong>Our Features</strong></h5>
<ul>
   <li><strong>Create and Manage Notes:</strong> Effortlessly create, save, edit, and delete notes.</li>
   <li><strong>Pin and Organize:</strong> Pin important notes and set custom colors to stay organized.</li>
   <li><strong>Secure Account Management:</strong> Your data is safe with secure sign-in and encryption features.</li>
</ul>
<br>
<p>Get started by creating an account, and experience how easy it is to manage and store your notes in a secure environment. Stay organized and access your notes anywhere, anytime.</p>
<br>
<div class="row">
   <span class="col-4"></span>
   <a id="loginButtonIndex" href="/KeepNotes/login" class="col-2 btn btn-primary me-2">Login</a>
   <a id="registerButtonIndex" href="/KeepNotes/register" class="col-2 btn btn-primary">Create A New Account</a>
   <span class="col-4"></span>
</div>
<script>
   if (sessionStorage.getItem("UserName") !== null && sessionStorage.getItem("UserId") !== null) {
      $('#loginButtonIndex').hide();
      $('#registerButtonIndex').hide();
   } else {
      $('#loginButtonIndex').show();
      $('#registerButtonIndex').show();
   }
</script>
<jsp:include page="footer.jsp" />