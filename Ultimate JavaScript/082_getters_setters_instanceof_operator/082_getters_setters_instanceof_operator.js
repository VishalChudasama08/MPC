class Animal {
    constructor(n) {
        this.name = n;
    }
    fly() { // simple method
        alert("Mai ud nahi rha");
    }
    // get is get method key word and getname is thid method name
    // use get than write in method to return class variables 
    get getname() {
        return this.name;
    }
    // this is set method, argumrnt is recwied
    // this is set class variable value
    set setname(newname) {
        this.name = newname
    }
}

class Rebbit extends Animal {
    eating() {
        console.log("Rebbit is eating...");
    }
}
let a = new Animal("Vishal");
a.fly(); // method call
console.log(a.getname); // getname is getter
// call get method to return variable value
a.setname = "Jack"; // setname is setter 
// use direct like this

// note:- on getter and setter useing time not use brecat ()

let r = new Rebbit();
let b = 40;
let d = {
    naem: "vishal",
    id: "08"
}

// use instanceog to chack if this variable & object is class object or not if this is class object than return true else false
console.log(a instanceof Animal);
console.log(r instanceof Animal); // true because Rabbit inharit Animal class
console.log(r instanceof Rebbit);
console.log(d instanceof Animal);
console.log(b instanceof Animal);