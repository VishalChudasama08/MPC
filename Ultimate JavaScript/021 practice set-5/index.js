//questuons 1
let arr1 = [12,36,45,87,92,14,54,88]
console.log(arr1)
let a1 = prompt("Enter number")
a1 = Number.parseInt(a1)
arr1.push(a1)
console.log(arr1, "\n")

//questuons 2
let arr2 = [12,36,45,87,92,14,54,88]
console.log(arr2)
let a2;
do {
   a2 = prompt("Enter number")
   a2 = Number.parseInt(a2)
   arr2.push(a2)
} while (a2 != 0);
console.log(arr2, "\n");

//questuons 3
let arr3 = [12,37,45,87,92,17,54,88]
console.log(arr3)
let a3 = arr3.filter((v) => {
  return v % 2 == 0
})
console.log(a3);

let b3 = arr3.filter((v) => {
  return v % 2 != 0
})
console.log(b3, "\n");   

//questuons 4
let arr4 = [12,37,45,87,92,17,54,88]
console.log(arr4)
let a4 = arr4.map((h) => {
  return h * h
})
console.log(a4, "\n");

//questuons 5
let arr5 = [1, 2, 3, 4 ,5 ,6 ,7 ,8 ,9]
console.log(arr5)
let a5 = arr5.reduce((h1 ,h2) => {
  return h1 * h2
})
console.log(a5, "\n");