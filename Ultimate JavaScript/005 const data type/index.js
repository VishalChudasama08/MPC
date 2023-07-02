let a = "vishal";
let b = 8;
console.log(a+b);
// string and number ne + kari sakay chhe 
console.log(typeof (a+b));
// type string g j rahe chhe

const v = {
  surname: "chudasama",
  name: "vishal",
}

console.log(v);
console.log(v["surname"] + " " + v["name"]);
// const v ne print kar va


v['rollnumber'] = 08;
// const v ni values ma umero kari sakay chhe.
console.log(v);
console.log(v.rollnumber); //in console print onliy rollnumber

v['name'] = "G";
// const v ni values ne badali sakay chhe.
console.log(v);
console.log(v.name);

v = 28;
// v const chhe te ne bhadali sakato nathi