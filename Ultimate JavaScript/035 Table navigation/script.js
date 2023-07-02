let t = document.body.firstElementChild.firstElementChild
console.log(t);
// console.log(t.rows);
// console.log(t.rows[0]);
// console.log(t.rows[1]);
// console.log(t.caption);
console.log(t.tHead);
console.log(t.tHead.firstElementChild);
// console.log(t.Foot); // (undefined) in table not set footer 
console.log(t.tBodies);
console.log(t.rows[1].rowIndex);
console.log(t.rows[2].rowIndex);
let v = document.body.firstElementChild.firstElementChild.firstElementChild.firstElementChild.firstElementChild
console.log(v);
console.log(v.cellIndex);