function age() {
  let age = prompt("Eter your age");
  age = Number.parseInt(age);
  console.log(typeof age);
  let p1 = `Your age is ${age}`;
  let p2 = "You can drive";
  let p3 = "You can not drive";
  document.getElementById("p1").innerHTML= p1;
  if (age>18){
document.getElementById("p2").innerHTML= p2;
    }
  else {
document.getElementById("p2").innerHTML= p3;
    }
}
