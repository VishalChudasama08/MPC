let navbar = document.getElementById("navbar");
navbar.style.color = "red";
// navbar.style.font-weight = "bold";
let card_title = document.querySelectorAll(".c"); // use querySelectorAll then this variable to object (use sem as array but not a array) type and spesify and use all one by one 
console.log(typeof card_title);
card_title[0].style.color = "blue";
card_title[1].style.color = "red";
card_title[2].style.color = "green";
card_title[3].style.color = "yellow";
card_title[4].style.color = "cyan";
card_title[5].style.color = "orange";
card_title[6].style.color = "hotpink";

let b = document.querySelector(".card-b"); //use querySelector to select any element using it's id and class ,,,,
console.log(typeof b);
b.style.color = "red";