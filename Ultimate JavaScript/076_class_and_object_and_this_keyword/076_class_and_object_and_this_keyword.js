class RailwayForm {
    submit() {
        alert(this.name + ": Your form is Submitted for train number is " + this.train);
    }
    cancel() {
        alert(this.name + ": Your form is Cancelled for train number is " + this.train);
    }
    fill(yourname, trainnumber) {
        this.name = yourname;
        this.train = trainnumber;
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