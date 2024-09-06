import m2, { b, c, d } from './module2.mjs'; // set any name (here m2) than provide default export data

console.log(m2); // print a value because this is set default 

// for run this line, need to export b,c,d in module2.mjs file, because this is not set export default
// and in see first line than same name (b,c,d) if you change name that not working 
console.log(b);
console.log(c);
console.log(d);


/*
For Run =>
    open new terminal in this folder 
    cd .\src\
    cd .\react_06_props_and_proptypes\
    D:\Happy_Coding\My_Code_In_Github\MPC\React Js\src\react_06_props_and_proptypes> node .\module1.mjs
*/
