// delete 
console.log("delete method");
let a = [1, 2, 3, 4, 5];
console.log(a, a.length);
delete a[0];//not change array length
console.log(a, a.length);

//concat()
console.log("concat method");
let b = [1, 2, 3, 4, 5];
let c = [6, 7, 8, 9, 10];
let d = [11, 12, 13, 14, 15];
let e = b.concat(c,d);//not change array, return a new array
console.log(e, e.length);
console.log(b);
console.log(c);
console.log(d);

//sort()
console.log("sort method");
let compare = (x, y) => {
  return x - y;
}
let comparee = (x, y) => {
  return y - x;
}
let f = [2, 22, 7, 56, 999, 1003, 143, 8, 6, 10, 28, 76, 555];
console.log(f);
console.log(f.sort());
console.log(f.sort(compare));//using compare funtion sort asending order
console.log(f.sort(comparee));//using comparee funtion sort desending order

//reverse()
console.log("reverse method");
let g = [1, 2, 3, 4, 5];
console.log(g);
let h = g.reverse();//changed original array, and return new array
console.log(g);
console.log(h);

//splice()
console.log("splice method");
let i = [11, 22, 33, 4, 5, 88, 99, 00];
console.log(h);
let j = i.splice(3, 2, 44, 55, 66, 77);//ahi 3 index value thi 2 steps sudhini value delet caro and tya 44, 55,... umero
//splice change original array and return deleted value 
console.log(i);
console.log(j);

//slice()
console.log("slice method");
let k = [3, 6, 9, 10, 11, 12, 15];
console.log(k);
console.log(k.slice(3,5)); //not changed oroginal array, return declarated step (ahi index 3 thi 4 sudhini value, 5 nay levana tenathi 1 ochhi)
console.log(k);