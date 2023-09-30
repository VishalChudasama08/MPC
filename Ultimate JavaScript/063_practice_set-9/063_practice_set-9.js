const loadscript = async (src) => {
    return new Promise((resolve, reject) => {
        let script = document.createElement("script");
        script.src = src;
        script.onload = () => {
            resolve(src + " Done success")
        }
        document.head.append(script)
    })
}

// problem Number 1
// let a = loadscript('https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js');
// a.then((value) => {
//     console.log(value);
// })

// problem Number 2
// const main2 = async () => {
//     console.log(new Date().getMilliseconds());
//     let a = await loadscript('https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js');
//     console.log(a);
//     console.log(new Date().getMilliseconds());
// }
// main2();

// problem number 3
// let p = () => {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             reject(new Error("Please this is not acceptable"))
//         }, 3000)
//     })
// }
// let a = async () => {
//     try {
//         let c = await p();
//         console.log(c);
//     }
//     catch (error) {
//         console.log("This error has been handled");
//     }
// }
// a();


// problem number 4
let p1 = async () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(10);
        }, 2000)
    })
}
let p2 = async () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(10);
        }, 1000)
    })
}
let p3 = async () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(10);
        }, 3000)
    })
}

const run = async () => {
    console.time("run"); // timeEnd()

    // let a1 = await p1();
    // let a2 = await p2();
    // let a3 = await p3();
    // console.log(a1, a2, a3);
    // uper code using await, consume more time but this lower code is faster then this 
    let a1 = p1();
    let a2 = p2();
    let a3 = p3();
    let a1a2a3 = await Promise.all([a1, a2, a3]);
    console.log(a1a2a3);

    console.timeEnd("run"); // time() to timeEnd() find run time
}

run();