console.clear()//clear console
console.log("This is a console.log")
console.error("This is a console.error, show on red background color in console")
console.assert(5>55)//assertion is false, show: assertion failed
console.assert(55>5)//assertion is true
obj = {
  a: 1,
  b: 2,
  c: 3,
  d: 4
}
console.table(obj)
console.warn("This is a warning⚠️")
console.info("This is a information")
console.time("any word")
console.timeEnd("any word")
console.time()
console.time("forLoop")
for (let i = 0; i < 3; i++) {
   console.log(i);
}
console.timeEnd("forLoop")
console.time("forLoop")
let i = 0
while (i<3) {
   console.log(i);
   i++;
}
console.timeEnd("forLoop")
console.log(console)