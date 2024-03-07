function init() {
    var name = "Vishal";
    function display() {
        //display is inner funtion, and this is closure 
        console.log(name);
    }
    name = "Droid"
    return display;
}

let v = init(); // init() funtion return a display funtion, in this case variable v is display function 
v(); // v is display function chhe, tethi v() call karta display funtion call thase je ma name variable console ma print thay chhe
// aa run thatu hoy tyare v functin ma je init function na variable hoy teno refrense hoy chhe (variable ni value nay) 


function returnFunc() {
    const x = () => {
        let a = 1
        console.log(a);
        const y = () => {
            let a = 2
            console.log(a);
            const z = () => {
                let a = 3
                console.log(a);
            }
            z()
        }
        y()
    }
    return x;
}

let a = returnFunc() // returnFunc() function return x() funtion (not call x() funtion) in a variable then a is function type variable now call it like a()
a() // a() call first x() then x() funtion call y() and y() call z()