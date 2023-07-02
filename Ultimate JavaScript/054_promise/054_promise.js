let promise = new Promise(function(resolve, reject){
  alert("Hello");
  resolve(8); //you cen set any (8)
})

console.log("Hello world!");
if (promise) { //if promise is perfectliy run then if is true and resolve() print in console
  console.log(promise);
}