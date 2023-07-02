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

// pyramid of doom
vishal("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js", function hello(error, v) {
  if (error) {
    console.log(error);
    sendEmergencyMessageToCeo();//this is a just funtion, and if error then run this
    return;
  }
  vishal("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js", function hello(error, v) {
    if (error) {
      console.log(error);
      sendEmergencyMessageToCeo();
      return;
    }
    vishal("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js", function hello(error, v) {
      if (error) {
        console.log(error);
        sendEmergencyMessageToCeo();
        return;
      }
      vishal("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js", function hello(error, v) {
        if (error) {
          console.log(error);
          sendEmergencyMessageToCeo();
          return;
        }
        vishal("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js", function hello(error, v) {
          if (error) {
            console.log(error);
            sendEmergencyMessageToCeo();
            return;
          }
          vishal("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js", function hello(error, v) {
            if (error) {
              console.log(error);
              sendEmergencyMessageToCeo();
              return;
            }
            vishal("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js", function hello(error, v) {
              if (error) {
                console.log(error);
                sendEmergencyMessageToCeo();
                return;
              }
              vishal("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js", function hello(error, v) {
                if (error) {
                  console.log(error);
                  sendEmergencyMessageToCeo();
                  return;
                }
                vishal("https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js", function hello(error, v) {})
              })
            })
          })
        })
      })
    })
  })
}); 
