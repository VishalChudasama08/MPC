// on browser console --> alert(document.cookie) => showing all cookies
// set cookies (on browser console) --> document.cookie = "name=vishal8320"


document.cookie = "name=vishal8320"; //set new cookie
document.cookie = "name2=vishal832045";
document.cookie = "name=replare_vishal8320"; //replase name cookie

let key = prompt("Enter Your cookies name");
let value = prompt("Enter Your cookies Value");
document.cookie = `${encodeURIComponent(key)} = ${encodeURIComponent(value)}`;
//ahi encodeURIComponent() function values (je tema mokal vama aavel hoy e, jem ke ahi key and value chhe) ne encode kari nakhe chhe, aano use kar vathi cookie na name and value ma kay pan jemke simbol,caracter,number lakhi sakay chhe kem ke teto encode thay jase, 
//decodeURIComponent() no use kari tene pachhu decode kari sakay chhe, like decodeURIComponent(key) 


console.log(document.cookie) // showing cookies on console