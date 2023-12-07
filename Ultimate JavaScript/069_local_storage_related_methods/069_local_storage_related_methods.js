//using local storage to store a data on your local storage, sem like cookies, but this data is not deleted on you want to close google chrome and reload page , it is stil on local storage, if you see this data then goto inpect then application

// Notes:- local storage stora data on only string type data

let key = prompt("Enter Key You Want to set");
let value = prompt("Enter Value You Want to set");

localStorage.setItem(key, value); // set this item's on local storage, use to set item, and replase value (using enter same name)

console.log(`The Value at ${key} is ${localStorage.getItem(key)}`); // using .getitem() to get key of value on local storage

if (key == "red" || key == "blue") { //if key is red or blue then remove it
    localStorage.removeItem(key); // using .removeItem() to remove only this key item
}

if (key == 0) { //if in localStorage any key value is 0 then clear all data on local storage
    localStorage.clear(); // use to clear all data on local storage
}

console.log(localStorage.length); // .length this return number of key on local storage, note:- showing only before(પહેલાં) this line saved all key not, after(પછી) this line save keys

console.log(localStorage.key(0)); // .key(0) this return 0 index numebr key values
console.log(localStorage.key(1)); // .key(1)) this return 1 index numebr key values

localStorage.b = 2; // another way to save data on local storage, key is b nad value is 2
console.log(localStorage.b); // localStorage.b return key of value, here print on console

delete localStorage.b; // using delete to clear this key and its value 