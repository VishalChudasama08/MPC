class RailwayForm {
    submit() { // javascript class method ma private, protectad,... and return value no use thato nathi
        alert(this.name + ": Your form is Submitted for train number is " + this.train); // you can use dayrect this.<variable name> , js ma variable alag this declare karvo padto nathi, aamaj declare and use thay chhe
    }
    cancel() {
        alert(this.name + ": Your form is Cancelled for train number is " + this.train);
    }
    fill(yourname, trainnumber) {
        this.name = yourname;
        this.train = trainnumber;
    }

    name() { //no return type, dayrect ruturn value
        return this.name;
    }
}

let vishalform = new RailwayForm(); //create new vishalform class object  

let geetasform = new RailwayForm();
let geetasform2 = new RailwayForm();

vishalform.fill("Vishal", 8);
vishalform.submit();

geetasform.fill("Geeta", 7);
geetasform.submit();
geetasform.cancel();

geetasform2.fill("Geeta", 8);
geetasform2.submit();

console.log(vishalform.name);
