let a = prompt("Enter any number:-");
// prompt bijane apva mahiti lese
// prompt ae 1 function chhe jeno uptog kar vathi popap aave chhe. jema kaepan lakhiye te ahi let a ma save thay chhe. 
// alert("what is your age?");
// alert popap dwara koy suchna, ke koy mahiti mate alert kari sakay chhe.
// tema khali ok j thay chhe.
console.log("typeof a is", typeof a);
a = Number.parseInt(a);
// type casting string to int 
console.log("a = Number.parseInt(a) then typeof a is", typeof a);
if (a/2 == 0) {
   console.log("Even Number");
}
else if (a%2 == 1) {
   console.log("Odd Number");
}
else {
   alert("Not a Number");
}
 
let b = prompt("Enter Number only 8:- ");
//prompt is typeof string 
switch (b='8') {
   case '8' :
      console.log("Number is 8");
      break;
   default :
      alert("Please Enter 8");
      break;
}
let c = prompt("what your age?");
console.log("You can", (c>=20 ? "drive" : "Not drive"));

// confirm()
let x;
let r = confirm("press button of your choice");
if (r == true) {
   x = "you pressed ok!";
}
else {
  x = "you pressed cancel!";
}
