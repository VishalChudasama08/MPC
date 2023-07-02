//practice 1
console.log("it\'s okay");

//practice 2
const sentence = 'The quick brown fox jumps over the lazy dog.';
const word = 'fox2';

console.log(sentence.includes (word));

console.log(`The word "${word}" ${sentence.includes (word) ? 'is' : 'is not'} in the sentence`);

//practice 3
let a = "CodeWithVishal";
console.log(a);
console.log(a.toUpperCase());
console.log(a.toLowerCase());

//practice 4
let str1 = "Please give Rs 1000";
let amount1 = Number.parseInt(str1.slice("Please give Rs".length));//aatli length sivay nu
console.log(amount1, typeof amount1);

let str2 = "Please give Rs 1000";
let amount2 = Number.parseInt(str2.slice(15,21));//index 15 thi 20 (21-1)
console.log(amount2, typeof amount2);