let btn = document.getElementById("btn");

let x = function(pointereventobject){ // pointereventobject te variable chhe na lakhiye to pan chaale , lakhiye to tema pointer na badhaaj event object aave(save thay) chhe 
  console.log(pointereventobject);
  console.log(pointereventobject.target); //jena upar click thayu hoy te target tag aave chhe 
  console.log(pointereventobject.type, pointereventobject.clientX, pointereventobject.clientY);
  //.type=>tekevi event thay te darsave
  //.clientX and .clientY x and y axis ma pointer thi kya click thayu te location batave
  alert("Hello World!");
}
let y = function(pointereventobject){
  alert("How are you!");
}

btn.addEventListener('click', x); //if click btn thrn run variable x, minss run funtion(hello world!)

btn.addEventListener('click', y) //if click btn thrn run variable y, minss run funtion(How are you!)

let a = prompt("What is your favorite number?");
if(a == "2"){
  btn.removeEventListener('click', x); //remove Event Listener , je addEventListener ma x variable hoy te addEventListener remove thay chhe
}