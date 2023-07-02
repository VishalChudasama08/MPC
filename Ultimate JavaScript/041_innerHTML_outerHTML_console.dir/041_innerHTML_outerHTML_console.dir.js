let s1 = document.getElementById("s");
let x = document.getElementsByTagName('span')[0];
console.log(x); //ruturn as a element
console.dir(x); //return as a object
console.log(document.body.firstChild.nodeName);
console.log(document.body.firstElementChild.nodeName);

console.log(s1.innerHTML); //return s1 id inner all content
s1.innerHTML = "<b> Hey, i am bold</b>" //riplase(set HTML using js) to s1 id all content in inner tag (add and replase code inner html)

console.log(s1.outerHTML) //return s1 is outer all content
s1.outerHTML = "<div id='d' hidden>Hey, i am div. Edit with JavaScript.</div>" //riplase(set HTML using js) to s1 id all content in outer tag (replase as span tag)

console.log(document.body.firstChild.data); //return firstChild all data as text
console.log(document.body.textContent); //return all text content on body...

s2.hidden = false; //hidden = true then hidden and hidden = false then not hidden(show tag) in s2 id tag
d.hidden = false;