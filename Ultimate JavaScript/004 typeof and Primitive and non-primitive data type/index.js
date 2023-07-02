/* nn bb ss u -- primitive data types in javascript */
/* null,number 
   boolean,bigint
   string,
   undefined*/
let a = "vishal";
let b = 128;
let c = false;
let d = undefined;
let e = null;
let f = BigInt("20")+BigInt("18");
console.log(a,b,c,d,e,f);

console.log(typeof f);
console.log(typeof g);
// non-primitive data types 
const iterm = {
  "vishal": true,
  "anil": false,
  "number": 18,
  "no": undefined
}
console.log(iterm["vishal"]);