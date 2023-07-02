let marks = [75, 85, 95, true, "okay"];
console.log(marks);
console.log(marks[0]);
console.log(marks[1]);
console.log(marks[2]);
console.log(marks[3]);
console.log(marks[4]);
console.log(marks[5]);//not different
console.log("marks length is " + marks.length);

marks[0] = 76;
marks[5] = false;
marks[6] = "not okay";
console.log(marks);
console.log("typeof array " + typeof marks);
console.log("marks length is " + marks.length);
//Array are mutable, Array can be changed
//String are anmutable, String can be not changed