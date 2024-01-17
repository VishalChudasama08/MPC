let array1 = [3, 5];

let a1 = array1[0];
let a2 = array1[1]; // this is simple method to get array value and sava as new variable 

console.log(a1, a2);

// destructuring assingment

// but if array is bigg size and you make sem as then use destructuring to got it

let [b1, b2] = array1; // in this line a2 is 3 and b2 is 5
// this is destructuring assingment
console.log(b1, b2);

let array2 = [3, 5, 7, 9, 11, 13, 15]; // add more value then

let [f1, f2] = array2; // only get value on first and secend number as f1 and f2
console.log(f1, f2);

// Spread Operator

let [...h1] = array2; // there dot (...) is spread operator
// use - array to object, 
// note - use spread operator inside [] and {} only if use inside () then this is syntax error
console.log(h1, "type is " + typeof h1);

let [c1, c2, c3, ...c4] = array2;
// ...c4 in c4 is new object and is value is avoed first 3 and then all value add on c4 object
console.log(c1, c2, c3, c4, "type is " + typeof c4);

// if to make as not add some value then create object then 
let [d1, d2, , , ...d3] = array2; // in this case 7, 9 not add on d3
console.log(d1, d2, d3, "type is " + typeof d3);

let [, , g1, , g2, , g3] = array2;
console.log(g1, g2, g3); // 7, 11, 15

function sum(i1, i2, i3) {
    return i1 + i2 + i3;
}
console.log(sum(...array2)); // use spread operator with object and array then
// this same as argument 
// if in object and array vlaue is many then use first values

// deatructuring and spread use same as object
// but in array then use []
// and object then use {}

let { o1, o2 } = { o1: "v", o2: 8 };
console.log(o1, o2);



let object1 = {
    namev: "Vishal",
    number: 83203,
    age: 21,
    vilage: "kotadiya"
}

console.log(object1);

console.log({ ...object1, namev: "another", age: 12 }); // use this type to chenge value, if first write spread operator and then write changes 

// more information abaut spread operator then visit :- https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_synt

// more for destructuring