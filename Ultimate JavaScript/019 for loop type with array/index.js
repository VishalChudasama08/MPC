let num = [3, 5, 4, 9, 7, 1, 6];

//simple for loop
for (let i = 0; i < num.length; i++) {
   console.log(num[i]);
}

//forEach loop
console.log("forEach loop");
num.forEach((i) => {
  console.log(i * i, typeof num, typeof i); 
});

//Array.from() //used to convert html collection to array
let a = "Vishal";
let b = Array.from(a);
console.log(a, typeof a, "\n", b, typeof b);

//for...of
for (let i of num) {
   console.log(i);
}

//for...in //used to print array index value
for (let i in num) {
   console.log(i);
}
for (let i in num) {
   console.log(i, ":", num[i]);
}