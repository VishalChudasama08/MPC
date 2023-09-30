let p = fetch("https://goweather.herokuapp.com/weather/india"); // p is promise, fetch() finction and this link is free weather api link (find in public-apis on github) this api return cuntry weather and this function return api data in promise

p.then((response) => {
    console.log(response.status); // .status return http status code
    console.log(response.ok); // .ok return boolean , if all are right then true else false, and if the http status code is 200-299 
    // console.log(headers);
    return response.json(); // this method to access data, hear using json() -> using to return javascript object, .text() -> using to return the test on string  
}).then((value2) => {
    console.log(value2); // api ma 2 .then vaparay chhe....
})