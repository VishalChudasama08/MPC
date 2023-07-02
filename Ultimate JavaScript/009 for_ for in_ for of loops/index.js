// simple for loop
let sum = 0;
let n = prompt("Enter number:- ");
n = Number.parseInt(n);
for (let i = 1; i < n; i++) {
   sum += i;
}
console.log("Sum of", n, "numbers is " + sum);

// for in loop
let list = {
  Vishal: 70,
  Ajay: 80,
  Kishan: 75,
  Sagar: 65,
  Parash: 85,
  Sahil: 60,
  Vijay: 80 
}
for (const a in list) {
   console.log("Marks of " + a + " are " + list[a]);
}

// for of loop
for (let v of "AHIR") {
   console.log(v);
}
