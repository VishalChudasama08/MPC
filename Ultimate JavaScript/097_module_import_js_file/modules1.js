// commonjs modules function

const hello = () => {
    console.log("I am modules1.js file hello() function console log");
}

const ahello = (name) => {
    console.log("I am modules1.js file ahello() function console log. " + name);
}
module.exports = { hello, ahello }; // using mudule.exports , make as exports this js file in ather js file 