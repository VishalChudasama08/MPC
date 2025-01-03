<script>
   let pathName = window.location.pathname.split('/')[2];
   document.title += " - " + pathName ? pathName : "Index";
   function handleLogout() {
      sessionStorage.clear();
   }
   if (sessionStorage.getItem("UserName") !== null && sessionStorage.getItem("UserId") !== null) {
      $('#loginButton').hide();
      $('#registerButton').hide();
   } else {
      $('#profileButton').hide();
      $('#logoutButton').hide();
   }

   function softAlert(type, message, time) {
      let svgTypes = ["check-circle-fill", "exclamation-triangle-fill"]
      let svgType = type === 'success' ? svgTypes[0] : svgTypes[1];
      let svg = '<svg class="bi flex-shrink-0 me-2" width="18" height="18" role="img" aria-label="' + type.charAt(0).toUpperCase() + type.slice(1) + ':"><use xlink:href="#' + svgType + '"/></svg>';
      document.getElementById('alertDiv').innerHTML += '<div id="thisIsAlert" class="alert alert-' + type + ' alert-dismissible d-flex align-items-center fade show py-2 px-3" role="alert" style="display: flex; position: fixed; top: 5px; left: 50%; transform: translateX(-50%); justify-content: center; z-index: 1;">' + svg + '<div>' + message + '</div></div>';

      $('#thisIsAlert').slideDown(200);
      setTimeout(() => { // remove alert tag after 1.5 second
         $('#thisIsAlert').slideUp(200);
         $('#thisIsAlert').remove();
      }, time);
   }

   document.addEventListener('DOMContentLoaded', function () {
      // Find all elements with data-bs-toggle="tooltip"
      var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));

      // Initialize Bootstrap Tooltip for each element
      tooltipTriggerList.forEach(function (tooltipTriggerEl) {
         new bootstrap.Tooltip(tooltipTriggerEl);
      });
   });
</script>