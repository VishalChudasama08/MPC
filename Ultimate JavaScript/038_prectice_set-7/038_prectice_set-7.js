//Q-1
document.getElementsByTagName("nav")[0].firstElementChild.firstElementChild.style.color = "red";
//nav tag na firstElementChild(na first nag) na firstElementChild(na first nag) ma color red
document.getElementsByTagName("ul")[1].firstElementChild.style.color = "orange";
//bijo ul tag ma ul tag na firstElementChild(na first nag) ma color red

//Q-3
document.getElementsByTagName("ul")[2].firstElementChild.style.color = "green";
document.getElementsByTagName("ul")[2].lastElementChild.style.color = "green";

//Q-4
Array.from(document.getElementsByTagName("li")).forEach((Vishal) => {
  Vishal.style.background = "cyan";
})