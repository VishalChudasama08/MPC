// async funation is return a new promise
async function vishal() {
    let delhiweather = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("32 Deg")
        }, 2000);
    })
    let gujaratweather = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("28 Deg")
        }, 8000);
    })
    console.log("Fetching Delhi Weather Please Wait...");
    let delhiw = await delhiweather; //await no use wait karva thay chhe ahi delhiwather run thay and delhiw ma value aave tya sudhi wait kare chhe, tyar pachhi async function aagad run thya chhe (let delhiw ma value aavi jay tyar pachhi let gujaratw vadi line run thay chhe)
    console.log("Fetching Delhi Weather: " + delhiw);
    console.log("Fetching Gujarat Weather Please wait...");
    let gujaratw = await gujaratweather;
    console.log("Fetching Gujarat Weather: " + gujaratw);
    return [delhiw, gujaratw]
}
const evishal = () => {
    console.log("Hey I Am Evishal And I Am Not Waiting ");
}
console.log("Welcome to Weather Control Room ");
let a = vishal(); //vishal funation ma async no use chhe aelte te jya await chhe tya-tya wait karse
let b = evishal(); //evishal funtion ma async no use nathi karel aetle ae koyni vaet jose nay and run thay jase