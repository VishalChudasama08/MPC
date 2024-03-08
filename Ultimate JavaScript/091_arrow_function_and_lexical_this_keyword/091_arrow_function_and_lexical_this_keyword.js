// normal arrow function
const hello = (name, greeting) => { console.log(name + " " + greeting); }
hello("Vishal", "Good Morning")

// "lexical this" line number 18

const x = {
    namee: "Vishal",
    role: "JS Developer",
    exp: 21,
    show: function () {
        console.log(`The name is ${this.namee}\nThe role is ${this.role}`);
        console.log(this); // this keyword is x object
    },
    any1: () => {
        console.log("i am any1() arrow function");
        console.log(`The name is ${this.namee}\nThe role is ${this.role}`);
        console.log(this); // this keyword is window object not x object, that type this keyword is colled "lexical this" 
    },
    any2: function () {
        console.log("i am normal function");
        any3 = () => {
            console.log("i am any3() arrow function");
            console.log(`The name is ${this.namee}\nThe role is ${this.role}`);
            console.log(this);
        }
        any3()
    },
    any4: function () {
        console.log("i am any4() arrow function");
        console.log(this);
        let v = this;
        function any5() {
            console.log("i am any5() arrow function");
            console.log(`The name is ${v.namee}\nThe role is ${v.role}`);
            console.log(v);
            console.log(this); // this is window object
        }
        any5()
    }
}

console.log(x.namee, x.exp);
x.show() // use normal function then this key word is x object and it mines this.namee is "Vishal", and this.exp is 21

x.any1() // but if use this keyword inner arrow function than that is window object 
x.any4() // sem as if use this keyword like any4() function that is window object, 1 functoin then this function inner function and this inner function use this keyword than this keyword is window object

x.any2(); // solw that inner arrow function use this keyword problem to use like any2() and any5() than this keyword is not window object