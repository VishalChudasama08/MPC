let divf = document.getElementById("fdiv")
let divs = document.getElementById("sdiv")
let a = divf.getAttribute("class"); //tag ma class attribute ni value return kare chhe
document.write(a);

console.log(divf.hasAttribute("class")); //check attribute hsa existing then true else false
console.log(divf.hasAttribute("size")); //check attribute hsa existing then true else false

divf.setAttribute("hidden", "true"); //setAttribute use to set any Attribute
console.log(divs.getAttribute("class"));
divs.setAttribute("class", "Chudasama Vishal") //remove if Attribute value is exiting and then set this attribute
console.log(divs.getAttribute("class"));

divs.removeAttribute("style"); //use to remove Attribite

console.log(divs.dataset) //get all data- use and created attribute
console.log(divs.dataset.vishal) //get value
console.log(divs.dataset.any)
console.log(divs.dataset.boolian)
console.log(divs.dataset.number)