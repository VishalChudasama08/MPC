/* 
* all are sem as local storage but, session storage is work on curunt page, 
* if you reload page this not clear but you open sem page on new tab the this value is clear delete session storage 
* view session sorage then open inspect element on web page -> application -> storage (right side) -> session storage
*/
sessionStorage.setItem("name", "vishal"); //set value
sessionStorage.setItem("name2", "nitin");
sessionStorage.removeItem("name2"); //remove perticular item
console.log(sessionStorage.getItem("name")); // get item value
sessionStorage.clear(); //clear all session values