let p1 = new Promise((resolve, reject) => {
    setTimeout(() => {
        // resolve("value 1");
        reject(new Error("Error")); // new error create error (user created error)
    }, 1000);
})
let p2 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve("value 2");
    }, 2000);
})
let p3 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve("value 3");
    }, 3000);
})

// p1.then((value) => {
//     console.log(value);
// })
// p2.then((value) => {
//     console.log(value);
// })
// p3.then((value) => {
//     console.log(value);
// })

 let promise_all = Promise.all([p1, p2, p3]); //koypan 1 Promise ma error hoy to .all error batave
promise_all.then((value) => {
    console.log(value);
})

let promise_allSettled = Promise.allSettled([p1, p2, p3]); //koy promise ma error hoy to pan badhi promise run thay
promise_allSettled.then((value) => {
    console.log(value);
})

let promise_race = Promise.race([p1, p2, p3]); //je promise southi pehla resolve thay jay te return kare, error hoy to error batave
promise_race.then((value) => {
    console.log(value);
})

let promise_any = Promise.any([p1, p2, p3]); //je promise southi pehla resolve thay jay te return kare, error hoy to pan run thay, badhi promise ma error hoy toj error aave
promise_any.then((value) => {
    console.log(value); //value 2, kem ke value 1 ma error chhe
})

let promise_resolve = Promise.resolve(8);

let promise_reject = Promise.reject(new Error("Hey i am error!"))