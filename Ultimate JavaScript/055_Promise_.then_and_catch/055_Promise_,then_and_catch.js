let p1 = new Promise((resolve, reject) => {
  console.log("p1 Promise is pending");
  setTimeout(() => {
    console.log("I am p1 Promise and I am resolved");
    resolve(true);
  }, 2000);
})

let p2 = new Promise((resolve, reject) => {
  console.log("p2 Promise is pending");
  setTimeout(() => {
    console.log("I am p1 Promise and I am rejected");
    reject(new Error("I am same error!"))
  }, 2000);
})

//To get the value
p1.then((value) => {
  console.log(value);
})

p1.then(alert);


//To catch the errors
p2.catch((error) => {
  console.log("some error accurred in p2");
})
p2.catch(alert);


p2.then((value) => {
  console.log(value);
}, (error) => {
  console.log(error);
})