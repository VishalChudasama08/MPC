let v = prompt("Enter The Number:- ");
v = Number.parseInt(v);
console.log("While loop");
let i = 0, j = 0;
while (i < v) {
   console.log(i);
   i++;
}
console.log("Do While loop");
 do {
   console.log(j);
   j++;
}while (j < v)