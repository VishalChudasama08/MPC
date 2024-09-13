let p = fetch("https://api.weatherstack.com/current?access_key=eb5f210bba107ebbc413fdfb37dd8a2a&query=india"); 
// let p = fetch("https://goweather.herokuapp.com/weather/india"); // p is promise, fetch() finction and this link is free weather api link (find in public-apis on github) this api return cuntry weather and this function return api data in promise

p.then((response) => {
    console.log(response.status); // .status return http status code
    console.log(response.ok); // .ok return boolean , if all are right then true else false, and if the http status code is 200-299 
    // console.log(headers);
    
    return response.json(); // this method to access data, hear using json() -> using to return javascript object, .text() -> using to return the test on string  
}).then((value2) => {
    console.log(value2); // api no data fetch kare chhe. jeno have aapde jerite use karvo hoy tem kari sakiye

    let apidata = document.getElementById("main");
    apidata.innerHTML = `<pre>${JSON.stringify(value2, null, 2)}</pre>`;
}).catch((error)=>{
    console.error('Error: ', error);
})


/*
First p.than(()=>{}) :-
    pahela .than no use thany chhe te janava mate ke api nu status su chhe. (tukma api okay to chhe ne ?, te sarkhi rite data provide to kari sake tem chhe ne te janva mate) and jo api sarkhi rite working na karti hoy to aaphe pahela .than maj khabar padi jase and tena mate action lae sakasu

Second .than(()=>{}) :-
    Bija .than no upayog api mathia data leva thay chhe 
*/


// Current Weather API Endpoint

// http://api.weatherstack.com/current
//     ? access_key = YOUR_ACCESS_KEY
//     & query = New York
    
// // optional parameters: 

//     & units = m
//     & language = en
//     & callback = MY_CALLBACK