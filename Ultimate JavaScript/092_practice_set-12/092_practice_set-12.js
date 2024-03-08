// Q-1 print hello word using IIFE ()()
const a = async (text) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(text)  // this promise return text useing setTimeout after 2second 
        }, 2000)
    })
};

(
    async () => {
        let b = await a("hello World") // b store return value 
        console.log(b);
    }
)()

// Q-2 get array values average using spread operator
function sum(a, b, c, d, e, f) {
    return a + b + c + e + f;
}
let d = [8, 6, 5, 4, 3, 2]
console.log("Average is " + (sum(...d) / 6));

// Q-3
const e = async (text, n) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(text)  // this promise return text useing setTimeout after 2second 
        }, 1000 * n)
    })
};
(
    async () => {
        let f = await e("hey, I am Qusetion-3", 3) // f store return value 
        console.log(f);

    }
)()

// Q-4 simple Interest 
function simpleInterest(p, r, t) {
    return (p * r * t) / 100;
}
console.log(simpleInterest(10000, 5, 1));
// 10000 rupees koye ne 5% na vyaje 1 month mate aapela hoy...