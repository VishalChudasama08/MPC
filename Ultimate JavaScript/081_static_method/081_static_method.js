// static methos no use karvathi te method ne tej class ma use kari sakay chhe
// tenamate javascript ma <class_name>.<static_method_name>(<argumrnt>)
// pan te static method no use class na object thi kari sakato nathi
class Animal {
    constructor(name) { // use constructor to set name
        this.name = Animal.capitalize(name);
    }
    walk() {
        alert("Animal " + this.name + " is walking")
    }
    static capitalize(name) {
        return name.charAt(0).toUpperCase() + name.substr(1, name.lenght); // aa line ma name mathi te string no pelo character capital kare chhe, je return kare chhe constructor ma tya this.name na save thay chhe
    }
}

let j = new Animal("jack");
j.walk();
// j.capitalize("jack"); //not allowed