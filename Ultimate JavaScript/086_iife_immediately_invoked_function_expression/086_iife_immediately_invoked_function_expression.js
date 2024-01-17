let a = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(143);
        }, 2000);
    })
}

// let b = await a();
// let c = await a();
// let d = await a(); 
// not allowed because await use only async funtion and the top level bodies of modules

// then showing this 
// let e = async () => {
//     let b = await a();
//     console.log(b);
//     let c = await a();
//     console.log(c);
//     let d = await a();
//     console.log(d);
// }
// e(); 

// make async function in this case function is e, and sholw this 
// but you call funtion e(); then run it, but you make to drect run funtion (immediately invoked funtion) then
// use iife (immediately invoked function expression) 
// it is --> like (<your code>)() first () is your code wrap in () and
// second () is like funtion call iamfuntion() <-- this
// example -->

(async () => {
    let b = await a();
    console.log(b);
    let c = await a();
    console.log(c);
    let d = await a();
    console.log(d);
})();

// in this code 2 second - 2 second run a() finction