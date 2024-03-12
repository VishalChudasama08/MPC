// http://regexr.com for more in regular expressions

// on string you match any type of pattern (yes, any any pattern any, type of text) using regular expressions

// ex. if you match like -> ( new line start with "0" number and "a" caracter) on big paragraph, then this possible using regular expression

const regux = /very/g; // this is regular expressions
const string = "Vishal is very very very nice aawesome nice very very good boy";
// const text = string.replace(any, "VERY");  // if use this line than only first 'very' is replace In 'VERY'
const text = string.replace(regux, "VERY"); // useing regux variable to replace all 'very' in 'VERY'
console.log(text);