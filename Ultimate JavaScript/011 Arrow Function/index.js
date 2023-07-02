let a = 2, b = 4, c = 6;
console.log("(2a + 4b)/2 = ",  equation(a, b));
console.log("(2b + 4c)/2 = ", equation(b, c));
console.log("(2c + 4a)/2 = ", equation(c, a));
function equation(x, y) {
  return (2 * x + 4 * y) / 2;
}

console.log("\nUsing Arrow Function");
const sum = (v, g) => {
  return v + g;
};
//Arrow function hamesa pelaj lakhavanu function pachhij calling aave 
let v = sum(100, 43)
console.log(v);
let sums = (d, e, f) => {
  return d + e + f;
};
console.log(sums(100, 20, 3));