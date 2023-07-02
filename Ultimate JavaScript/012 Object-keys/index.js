// Object.keys().length 
// mark[Object.keys(mark)[i]]
let mark = {
  Vishal : 76,
  bhavesh : 85,
  Nitin : 80
}
for (let i = 0; i < Object.keys(mark).length; i++) {
   console.log("The mark of", Object.keys(mark)[i], "are", mark[Object.keys(mark)[i]]);
}
console.log("\n");
for (const j in mark) {
   console.log("The mark of", j, "are", mark[j],);
}
console.log("\n");

// do while loop
a = 8;
do {
  if ((a != 8) == true) {
     console.log("Try Again");
  } 
  a = prompt("Enter Correct Number:- ");
} while (a != 8);
console.log("Congratulations! it is enter correct number\n"); 

// Arrow function
const mens = (v, w, x, y, z) => {
  return (v + w + x + y + z)/2;
}
console.log("mens is", mens(10, 20, 30, 40, 50), "\n"); 