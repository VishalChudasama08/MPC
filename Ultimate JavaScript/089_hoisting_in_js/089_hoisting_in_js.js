console.log(a); // a not initialige but it is automaticaly initialege 
// use var then hoisting variable it minse variable initialige automaticaly, in this case run var a = 8 then declaretion 
// this is not work on let, hoisting work only var to declaretion variable only 
one()
function one() {
    console.log("Run One Funtion");
}

var a = 8;
console.log(a);