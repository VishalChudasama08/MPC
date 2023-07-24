let p1 = new Promise((resolve, reject) => {
    alert("Hey I am not resolved")
    setTimeout(() => {
        resolve(1);
    }, 2000)
});
p1.then(() => {
    console.log("Hurray");
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(8);
        }, 4000);
    })
}).then((value) => { //value is return value
    console.log(value);
})
p1.then(() => {
    console.log("Congratulation this promise is now resolved")
})
