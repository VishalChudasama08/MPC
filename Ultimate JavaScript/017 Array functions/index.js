//Array functions
let marks = [30, 40, 50, 60];
console.log(marks, typeof marks, marks.length);

//toString() function 
let a = marks.toString();//changed array to string
console.log(a, typeof a, a.length);

//join() function 
let b = marks.join(" - ");//join element using any simbol, alphabet, number
console.log(b, typeof b, b.length);

//pop() function
let c = marks.pop(); //pop return popped elements,Remove last element
console.log(marks, c, typeof c,);

//shift() function 
let d = marks.shift();//shift return first element, Remove first element(index 0 element)
console.log(marks, d, typeof d);

//unshift()
let e = marks.unshift(20);//unshift ruturn new array length, unshift on first stage(add on first index element)
console.log(marks, e, typeof e, e.length);

//push() function
let f = marks.push(70);//push ruturn new array length, push on last stage(push on last index element)
console.log(marks, f, typeof f, f.length);
