class Employee {
    constructor(name) {
        this.name = name;
    }
    login() {
        console.log(`${this.name} has login`);
    }
    logout() {
        console.log(`${this.name} has logged out`);
    }
    requestLeaves(leaves) {
        console.log(`${this.name} has requested ${leaves} leaves`);
    }
}

class Programmer extends Employee {
    requestCoffee(x) {
        console.log(`${this.name} has requested ${x} coffees`);
    }
    requestLeaves(leaves) { // sem name method in inharitance, this is method overriding
        super.requestLeaves(leaves); // use super key-word to call perent class method,constructor. 
        // on method calling  like this super.<method name with argument> => super.requestLeaves(4)
        // on consturctor calling like super(<constructor arguments>) => super(name)
        console.log("One extra is granted (only for programmer)");
    }
}

let vishal = new Programmer("Vishal");
vishal.login();
vishal.requestCoffee(2);
vishal.requestLeaves(10); // Please give me 10 leaves for my wedding ☺☻
vishal.logout();