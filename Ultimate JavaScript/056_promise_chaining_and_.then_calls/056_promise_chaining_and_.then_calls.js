/*

let p1 = new Promise((resolve, reject) => {
  console.log("p1 Promise Resolved after 1 seconds");
  setTimeout(() => {
    resolve("resolved p1 Promise");
  }, 1000)
})

p1.then((value) => {
  console.log(value); //je resolve thatu hoy te value value ma aave chhe
  let p2 = new Promise((resolve, reject) => {
    console.log("p2 Promise Resolved on 1st .then after 1 seconds");
    setTimeout(() => {
      resolve("resolved p2 Promise");
    }, 1000)
  })
  return p2;
}).then((value) => {
  console.log(value); //2nd .then ni value ma 1st .then ni return value aave chhe
  return new Promise((resolve, reject) => { //return karva mate p2 ni jem variable banavvan narur nathi dayrekc return pan kari shakay chhe
    console.log("p3 Promise Resolved on 2nd .then after 1 seconds");
    setTimeout(() => {
      resolve("resolved p3 Promise");
    }, 1000)
  })
}).then((value) => {
  console.log(value);
  console.log(("Now we are done 3rd .then"));
})
*/



const loadscript = (src) => {
  return new Promise((resolve, reject) => {
    let script = document.createElement("script");
    script.type = "text/javascript";
    script.src = src;
    document.body.appendChild(script);
    script.onload = () => {
      resolve("script has been loaded sucssesfully");
    }
    script.onerror = () => {
      reject(0);
    }
  })
}

let s1 = loadscript("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js");
s1.then((value) => {
  console.log(value);
  return loadscript("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js")
}).then((value) => {
  console.log("Second script ready");
}).catch((error) => {
  console.log("We are sorry but we are having priblems loasding this script");
})