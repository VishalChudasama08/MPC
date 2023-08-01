setTimeout(() => {
    console.log("Hacking wifi.... Please wait... ");
}, 1000)
// console.log(vishal); //this line showing error
try { //try this code if any error then run catch error code but not stoping all code runing
    console.log(vishal); //koy line ma error hoy to te pachhi no code run thato nathi tene rokava (error pachhi no code run karva) tene try catch ma lakhay
}
//try ma error hoy toj catch run thay chhe 
catch (error) { //error lakhelu chhe te variable chhe tya koy pan name lakhisakhay te ma error save tahy chhe
    console.log(error + "\n This is Error Hand using try catch");
}
try {
    setTimeout(() => {        
        console.log(hahahaaa); // ahi error aavse kem ke aa line 1second pachhi run thase aetle aema try catch nay thay
    }, 1000)
} catch (error) {
    console.log(error + "error not hand");
}
setTimeout(() => {
    console.log("Fetching username and password... Please wait...");
}, 2000)
setTimeout(() =>{
    console.log("Haking vishal,s instagram id... Please wait...");
}, 3000)
