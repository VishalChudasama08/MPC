function ruls() {
  v = "snake water gun game";
  document.getElementById("scriptdiv").innerHTML = v;
  /* not using becose it's good{ 
    //first click so ruls in div(#scriptdiv) tag
    //second clink not so ruls}
  */
}

function main() {
  let user = prompt("               Geuss Between snake, water, gun\n                             ENTER ONLY FOR :-\n       Snake for s,        Water for w,        Gun for g");

  let random = (Math.floor(Math.random() * 3));
  let cpu = ["s", "w", "g"][random];
  let result;

  if (cpu == user) {
    result = "Both are sem";
  }
  else if (cpu == "s" && user == "g") {
    result = "You are Wineer";
  }
  else if (cpu == "s" && user == "w") {
    result = "PC is Wineer";
  }
  else if (cpu == "w" && user == "s") {
    result = "You are Wineer";
  }
  else if (cpu == "w" && user == "g") {
    result = "PC is Wineer";
  }
  else if (cpu == "g" && user == "w") {
    result = "You are Wineer";
  }
  else if (cpu == "g" && user == "s") {
    result = "PC is Wineer";
  }
  else {
    result = "Nobody";
  }
  let pc = cpu.toUpperCase();
  let you_are = user.toUpperCase();
  if (!(user == 's' || user == 'S' || user == 'w' || user == 'W' || user == 'g' || user == 'G')) {
    alert("ENTER ONLY FOR :-\nSnake for s,\t\tWater for w,\t\tGun for g");
  } else {
    document.getElementById("scriptdiv").innerHTML = "PC :- <strong>" + pc + "</strong><br>You :- <strong>" + you_are + "</strong><br>Result :- <strong>" + result + "</strong>";
  }
}
//of one lock to start the so retry button