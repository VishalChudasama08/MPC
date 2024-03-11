// commonjs modules

// if you use CommonJs Modules than, check package.json file and remove this line "type": "module",

// require("<js_file_location>") write to use this js file in this file

// const v = require("./modules1.js");
// v.hello(); // using this use modules1.js
// v.ahello("Hello I am Vishal"); // using this use modules1.js

// const { hello, ahello } = require("./modules1.js");
// hello();
// ahello("Hello I am Vishal");



// ES6 modules

// if you run ES6 modules than, check package.json file and add this line "type": "module", if package.json file not found than run this commond "npm init -y" on terminal sem diretry

import vishal, { any1, any2 } from "./modules2.js"; // if function is default export than this not cover on {} couns
vishal();
any1();
any2("Hello")