//Q-1
class Complex {
    constructor(real_number, imaginary_number) {
        this.real = real_number;
        this.imaginary = imaginary_number;
    }
    add(num) {
        this.real = this.real + num.real;
        this.imaginary = this.imaginary + num.imaginary;
    }

    //Q-5
    get getReal() {
        return this.real;
    }
    get getImaginary() {
        return this.imaginary;
    }
    set setReal(newreal) {
        this.real = newreal;
    }
    set setImaginary(newimaginary) {
        this.imaginary = newimaginary;
    }
}

let a = new Complex(2, 4);
// call constructor and sava number object a, 
// like a.real = 2 and b.imaginary 
let b = new Complex(6, 2);
// sem as b.real = 6 and b.imaginary = 2 
// a and b is object 

a.real = 10;
a.imaginary = 10;
console.log(a.real + " " + a.imaginary);

//Q-2
a.add(b); // b = {real: 6, imaginary: 2}

console.log(`${a.real}+${a.imaginary}i`);

//Q-3
class Human {
    constructor(name, favfood) {
        this.name = name;
        this.favfood = favfood;
    }
    walk() {
        console.log("Human " + this.name + " is walking");
    }
}
class Student extends Human {
    walk() { // this method override on Human class method
        console.log("Student " + this.name + " is walking");
    }
}

let o = new Student("Vishal", "Potato");
o.walk();

//Q-4
console.log(o instanceof Human);