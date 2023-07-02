let age = prompt("What your age ?");
age = Number.parseInt(age);
//console.log(typeof age);
if (age>10 && age<20) {
   console.log("Your age lies between 10 and 20");
}
else {
   console.log("Your age doesn't lies between 10 and 20");
}


//age = Number.toString(age);
// type casting number to string 
//console.log(typeof age);
switch (age) {
   case 11:
      console.log("Your Age is 11");
      break;
   case 12:
      console.log("Your Age is 11");
      break;
   case 13:
      console.log("Your Age is 13");
      break;
   case 14:
      console.log("Your Age is 14");
      break;
   case 15:
      console.log("Your Age is 15");
      break;
   case 16:
      console.log("Your Age is 16");
      break;
   case 17:
      console.log("Your Age is 17");
      break;
   case 18:
      console.log("Your Age is 18");
      break;
   case 19:
      console.log("Your Age is 19");
      break;
   default:
      console.log("Enter between 11 to 19");
      break;
}


let a = age>18 ? "You can drive" : "You can not drive";
console.log(a);