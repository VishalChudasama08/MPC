let arr = [12, 11, 30, 99, 55, 10]
// array.map() function
let a = arr.map((value, index, array) => {
  console.log(value, index, array)
  return value + index
})
console.log(a);

const okay = (value, index, array) => {
  console.log(value, index, array)
  return value + index
}
let b = arr.map(okay) // okay is sem as calling function name
console.log(b, "\n")

//array.filter() function
let arr2 = [11, 22, 33, 44, 55, 66]
console.log(arr2)
let a2 = arr2.filter((v) => {
  return v>35 //35 kar ta mota chhe te a2 ma new array tarike sev thase
});
console.log(a2);

const vi = (c) => {
  return c<35 // this is a function
} // return c < 35 value 
let b2 = arr2.filter(vi) //vi is sem as calling function name
console.log(b2, "\n") 

//array.reduce() function
let arr3 = [1,2,3,4,5,6,7,8,9]
let a3 = arr3.reduce((h1, h2) => {
  return h1 + h2 //ahi h1=1 and h2=2 then h1+h2=3, h1=3 and h2=3 then h1+h2=9, h1=9 and h2=4...... last h1=36 and h2=9, h1+h2=45
});
console.log(a3)

const v2 = (h1, h2, h3) => {
  return h1 + h2 + h3
}
let b3 = arr3.reduce(v2)
console.log(b3)