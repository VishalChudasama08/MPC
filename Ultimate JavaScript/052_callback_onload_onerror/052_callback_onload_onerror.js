//Syncronos programing
// let a = prompt("what is your name ?");
// let b = prompt("what is your age ?");
// console.log(a + " is " + b + " years old");

//Asyncronos programing
// console.log("Start");
// setTimeout(function(){
//   console.log("Hey I am last runing but code is before End");
// },3000);
// console.log("End");

//callback

function vishal(src, callback){ //callback minss tema je value aave chhe te koy funtion chhe aa(vishal) funtion ma callback() lakhavathi te(hello) funtion run thay chhe
  let script = document.createElement("script"); //thos line create new script tag
  script.src = src; //script tag na src attribut ma src (funtion argument variable) link add
  
  script.onload = function(){ // .onload event tyare lagu pade jya re script perfectliy load thay jay
    console.log("script loaded with scr is " + src);
    callback(null, " hey i am callback function argument And new script tag is loaded sucsesfully"); //run hello funtion
  }
  
  script.onerror = function(){ //usig .onerror event if any error on script loading
    console.log("Error loading script with src: " + src);
    callback(new Error("src got some error")) //error variable ma je error hse te aavse
  }
  
  document.body.appendChild(script); //body tag to child tag is script tag
}

function hello(error, v){ // v is variable and it value is callback() funtion pased argument.
  if(error){ //error variable ma value hoy to (aetle if condition is right) error console ma aava se and then return(not run funtion after this)
    console.log(error); 
    return;
  }
  alert("Hello World!" + v);
}



//         ****** n ****** 
vishal("https://cd*.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js", hello); 
//vishal is funtion name and link is pased funtion arguments
