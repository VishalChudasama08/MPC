//insertAdjacentHTML and remove


let maindiv = document.getElementById("reddiv");

maindiv.insertAdjacentHTML("beforebegin", "<div class='v'>Beforebegin div tag.</div>");
maindiv.insertAdjacentHTML("beforeend", "<div class='v'>Beforeend div tag.</div>");
maindiv.insertAdjacentHTML("afterbegin", "<div class='v'>Afterbegin div tag.</div>");
maindiv.insertAdjacentHTML("afterend", "<div class='v'>Afterend div tag.</div>");


let p = document.getElementById("para");
p.remove();