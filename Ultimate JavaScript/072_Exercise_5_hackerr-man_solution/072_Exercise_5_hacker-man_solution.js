let a = [
    "Initializing Hack tool...",
    "Connecting to Facebook...",
    "Connecting to server 1...",
    "Connection faild. Retrying...",
    "Connecting to server 2...",
    "Connected Successfully...",
    "Username is vishal...",
    "Trying Brute Force...",
    "200k passwords Tried...",
    "Match not found...",
    "Another 200k passwords Tried...",
    "Match found...",
    "Accessing Account...",
    "Hack Successful."
]

const sleep = async (seconds) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => { resolve(true) }, seconds * 1000)
    })
}

const showHack = async (message) => {
    await sleep(2);
    // console.log(message);
    text.innerHTML = text.innerHTML + message + "<br>" // message showing on body
}


//this is IIFE , aa funtion dayrect (emideatly envoc) run thay jay chhe 
(async () => {
    for (let i = 0; i < a.length; i++) {
        await showHack(a[i]);
    }
})()