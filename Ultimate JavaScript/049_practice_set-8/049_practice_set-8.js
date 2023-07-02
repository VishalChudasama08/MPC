//Q-1 
function a() {
  alert('CodeWithHarry_Js_ytvideo_#49');
}

//Q-2,3
document.getElementById('google').addEventListener('click', function() {
  window.location = "https://www.google.com";
  win.focus();
})

//Q-4
// const fetchContent = async (url) => {
//   con = await fetch(url);
//   let a = await con.json();
//   return a;
// }
// setInterval(async function(){
//   let url = "https://jsonplaceholder.typicode.com/todos/1";
//   console.log(await fetchContent(url));
// }, 2000);

//Q-5
setInterval(function() {
  document.querySelector("#bulb1").classList.toggle("bulb");
  document.querySelector("#bulb2").classList.toggle("bulb");
}, 400);