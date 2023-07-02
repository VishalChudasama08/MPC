//className and classList
let id_para1 = document.getElementById("paragraph1");
let id_para2 = document.getElementById("paragraph2");
let id_para3 = document.getElementById("paragraph3");

id_para1.className = "first"; //change old class and add this class 

let v = id_para3.classList; //return all class name
console.log(v);
document.write(v);

id_para2.classList.remove("second"); //remove class

id_para2.classList.add("second"); //add class

id_para2.classList.toggle("gray"); //toggle class jo hoy to remove na hoy to add

let a = id_para3.classList.contains("g_y"); //return true if class is exist
console.log(a);