//setTimeout, setInterval, clearTimeout, clearInterval

alert("Hey, I am simple alert");

let a = setTimeout(function(){
  alert("Hey, I am inside of setTimeout alert and You see after 1.5 seconds.")
}, 1500); //run in 1.5 second
console.log(a); // return setTimeout key


let b = setTimeout(function() {
    alert("Hey, I am inside of setTimeout alert and You see after 0.5 seconds.")
  }, 500);
let c = prompt("Do you wamt to run the setTimeout ? (y/n)");
if (c == "n") {
  clearTimeout(b) //you can enter n then variable b not run
}


const d = (a,b) => {
  console.log("Hey, I am runing "+(a+b)+" setTimeout after 5 second")
}
setTimeout(d, 5000, 6, 4); // you can see after 5 second on console
//arguments 1->is function/function name, 2->is time after run, 3,4,5... -> function arguments


let e = setInterval(function(){
  console.log("Hey, I am setInterval and runing repeatedly after 1 seconds");
}, 1000); //it is look like loop and all sem as setTimeout but hear this time is repeatedly time duration


let f = prompt("Do you wamt to run the setInterval ? (y/n)");
if (f == "n") {
  clearInterval(e) //you can enter n then variable e not run
}