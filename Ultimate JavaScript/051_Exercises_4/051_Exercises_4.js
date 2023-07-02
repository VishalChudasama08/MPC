
setInterval(function() {
  let a = new Date();
  let hours = a.getHours();
  let minutes = a.getMinutes();
  let seconds = a.getSeconds();
  let suffix = "";
  
  let dn = a.getDay();
  let date = a.getDate();
  let month = a.getMonth() + 1;
  let year = a.getFullYear();
  let dayname;
  
  if (hours >= 12) {
    suffix = "PM";
    if (hours > 12) {
      hours -= 12;
    }
  } else {
    suffix = "AM";
    if (hours == 0) {
      hours = 12;
    }
  }
  
  switch (dn) {
    case 1:
      dayname = "Monday";
      break;
    case 2:
      dayname = "Tuesday";
      break;
    case 3:
      dayname = "Wednesday";
      break;
    case 4:
      dayname = "Thursday";
      break;
    case 5:
      dayname = "Friday";
      break;
    case 6:
      dayname = "Seturday";
      break;
    case 7:
      dayname = "Sunday";
      break;
  }
  
  document.getElementById("time").innerHTML = hours + ":" + minutes + ":" + seconds + " <span class='subscript'>"+suffix+"</span>";
  document.getElementById("date").innerHTML = dayname + " " + date + "/" + month + "/" + year;
}, 1000);
