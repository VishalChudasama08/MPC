class base {
    constructor(name, number) { // use constructor name as method than it is calles to constructor
        console.log("your name is " + name);
        console.log("your number is " + number);
    }

    base(name, number) {  // this is not constructor
        console.log("i am not constructor");
        console.log(name + " and " + number);
    }
    method1() {
        console.log("I am method 1");
    }
    method2() {
        console.log("I am method 2");
    }
}

let ob = new base("Vishal", 8320343610); // constructor argumrnts
ob.method1();
ob.method2();