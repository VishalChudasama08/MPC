class Animal {
    constructor(name, color) {
        this.name = name;
        this.color = color;
    }
    run() {
        console.log(this.name + " is running!");
    }
    shout() {
        console.log(`${this.name} is shouting`);
    }
}

class Monkey extends Animal {
    eating() {
        console.log(`${this.name} is eating bananas`);
    }
}

let m = new Monkey("chimpaji", "black");
m.run();
m.shout();
m.eating();