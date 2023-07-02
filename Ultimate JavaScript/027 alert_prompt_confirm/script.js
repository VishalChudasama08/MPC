//alert
alert("Hello! I am alert box");
//prompt
let a = prompt("Enter your name: ", "Vishal");
//confirm
let b = confirm("Your name is Vishal ?");
a = "Vishal";
if (b == true) {
   document.write("Your name is ",a);
} else {
   a = prompt("Enter your name: ");
   document.write("Your name is ",a);
}