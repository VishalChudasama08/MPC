let a = {
    name: "Vishal",
    language: "JavaScript",
    run: () => { //run is method
        alert("self run");
    }
}

console.log(a);

let p = {
    run: () => {
        alert("run");
    }
}

a.__proto__ = p; //set a prototype p
a.run();

p.__proto__ = {
    name2: "Jackie"
}

console.log(a.name2); // ahi pahela a object ma name2 gotse tya nay made etle a no prototype p (line number 11) chhe tethi tema gotse pan tya pan name2 nathi etle te , p na prototype (line number 20) ma gote chhe tya name2 jackie chhe te console ma print thay chhe, aa rite prototype ek pachhi chein banave chhe  