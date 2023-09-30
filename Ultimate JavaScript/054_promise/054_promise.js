let p = new Promise(function (resolve, reject) {
  alert("Hello");
  resolve(8); //you cen set any (8)
})

console.log("Hello world!");
if (p) { //if promise is perfectliy run then if is true and resolve() print in console
  console.log(p); // 8
}

/*
promise's
--> eak thi vadhare promise eak sathe run thay chhe, koy be promise's na block eak sathe run thata hoy chhe 
--> resolve ka reject bey mathis koy eak thay chhe
--> resolve thay to je value set kay ri hoy te aape se
--> reject thay to error aape chhe
*/