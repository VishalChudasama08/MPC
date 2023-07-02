// # 032
console.log(document.body.firstChild);
console.log(document.body.lastChild);
console.log(document.body.childNodes); 
//it's look like array but it's not array it's group of elements

//document.body.childNodes[0] == document.body.firstChild
// document.body.childNodes.length - 1 == document.body.lastChild

let arr = Array.from(document.body.childNodes); //convert in array
console.log(arr);

// # 033
let a = document.body.firstChild;
// console.log(a.parentNode);
// console.log(a.parentElement);
console.log(a.firstChild.nextSibling);