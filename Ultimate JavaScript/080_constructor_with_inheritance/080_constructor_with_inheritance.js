class Base {
    // constructor() {
    //     console.log("I am Base class constructor with 0 argument");
    // }
    constructor(name) { // super keyword this aahi argumrnt aave chhe
        console.log(`I am Base class constructor with 1 argument is ${name}`);
    }
}
class Derived extends Base {
    // jo derived class ma 1 pan constructor na hoy to aa rite javascript engin autometically construcotr call kare chhe, jethi super key word ma jetli argument hoy te super class na constructor ma jay chhe 
    // constructor(...argument){
    //     super(...argument)
    // }
    // constructor() {
    //     console.log("I am Derived class constructor with 1 argument");
    // }
    constructor(name) {
        super(name); // if base class constructor, recvest any argumrnt than use super keyword, else not use super keyword
        console.log(`I am Derived class constructor with 1 argument is ${name}`);
    }
}

// let v = new Derived(); // Base class 0 argument constructor calling, if 1 agrument constructor is not comment than it is error

let v = new Derived("Vishal"); // if any class 0 argument constructor pregent than this is error, 
// comment 0 argumrnt constructor then first run base class constructor call but you not set super(<argumrnt>) than this is error, autometically calling work only on if derived class not set any constructor
// second run derived class constructor 