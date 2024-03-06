{
    let a = 2; // let is block level scope
    var b = 3; // var is global level scope
}
// console.log(a); // a variable is block level scope
console.log(b); // b variable is global scope

let d = 8;

function gv() {
    let c = 4;
    console.log(d);
    console.log(c); // c variable is function scope sem as block
}
gv();
// console.log(c);
console.log(d);