let box = document.getElementsByClassName("box")
let id1 = document.getElementById("id1")
let id2 = document.getElementById("id2")
let sp1 = document.getElementsByClassName("sp1")

console.log(id1);
console.log(id1.matches(".vishal")); // use matches to matching. 
//#id1 tag ma .vishal (name no class) nathi aetele false thase
console.log(id1.matches(".box")); // #id1 tag ma .box (name no class) chhe aetele true return thase

console.log(sp1.closest("#sp1"));

console.log(id1.contains(sp1));
console.log(sp1.contains(sp1));
console.log(sp1.contains(id1));