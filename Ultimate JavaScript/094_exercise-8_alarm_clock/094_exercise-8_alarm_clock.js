// function number() {
//     let v = parseInt(document.getElementById("time").value) * 1000;

//     sessionStorage.setItem("timeNumber", v);

//     setInterval(function () {
//         let audio = document.getElementById("audioPlayer");
//         audio.onplay();
//         console.log("oned");
//     }, v);
// }

// window.onload = function () {
//     let storedNumber = sessionStorage.getItem("timeNumber");
//     if (storedNumber) {
//         document.getElementById("result").textContent = storedNumber;

//         setInterval(function () {
//             let now = new Date();
//             let date = now.getDate();
//             let hours = now.getHours();
//             let minutes = now.getMinutes();
//             let seconds = now.getSeconds();
//             document.getElementById("clock").innerHTML = hours + ":" + minutes + ":" + seconds;
//             console.log('Interval triggered');
//         }, 1000);

//     }
// }

setInterval(function () {
    let now = new Date();
    let date = now.getDate();
    let hours = now.getHours();
    let minutes = now.getMinutes();
    let seconds = now.getSeconds();
    document.getElementById("clock").innerHTML = hours + ":" + minutes + ":" + seconds;
    console.log('Clock is Raning');
}, 1000);

let v = prompt("Enter Number after ringing alarm clock") * 1000;
console.log(v);
// if (v != 0) {
setTimeout(function () {
    let audio = new Audio('https://commondatastorage.googleapis.com/codeskulptor-demos/DDR_assets/Kangaroo_MusiQue_-_The_Neverwritten_Role_Playing_Game.mp3');
    audio.play().then(() => { // .play() start alarm sound
        console.log("playing...");
        let shouldDismiss = confirm("Alarm is ringing! Would you like to dismiss it?");
        if (shouldDismiss) {
            audio.pause(); // Stop the alarm sound
            console.log("Alarm dismissed by user.");
        }
    }).catch(error => {
        console.error("Error playing audio:", error);
    });
}, v);
// }