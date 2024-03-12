// npm init -y
// to create package.json file

// npm install express --save
// install express package file this command this create node_modules folder and package-lock.json file

// npm i -g nodemon
// install nodemon           ( ** nodemon is not working use node and re-run js file ** )
// use this command to not reload server reqcvaed 
// js file edit karine save karite pachhi output jova mate te "node 098_express_package_in_node_js" thi run kar vanu hoy chhe (code runner thi aaj thay chhe), 
// have ghani-ghani file save karine server reload karvu pade chhe (js file run karvipade chhe) pan have aa commad use kari ne nodemon install karya pchhi jya js file run karvani hoy tyare 
// command ma "node <file_name>" ma node nijgyaye nodemon lakhava nu -> "nodemon <file_name>"
// jethi have js file edit karine save kariye to server outomaticly reload thay jaychhe

// ( ** nodemon is not working use node and re-run js file ** )

// run this file and create server using this command in vs code terminal 
// node "Ultimate JavaScript\098_express_package_in_node_js\098_express_package_in_node_js.js"

// click on this link on terminal to, you go on webpage
// Example app listening on port http://localhost:3000

// then on url write sem as -> "/index" (http://localhost:3000/index) and press enter to open 098_express_package_in_node_js.html file 

const express = require('express')
const path = require('path')
const app = express()
const port = 3000

// this is defrant pages if you write on url it than is showing

app.get('/', (req, res) => { // http://localhost:3000 // default open this page

    // ************** write your server site javascript here **************

    console.log(req.query); // req.query is url query after site url in this case -> "?vishal" (http://localhost:3000/?vishal) this showing on your server site (in this case on my vs code terminal => { vishal: '' } ), more exapmle -> http://localhost:3000/?name=vishal -> { name: 'vishal' }
    // this is not working on other page like 098_express_package_in_node_js.html,about,contect because on this page js code on write this line -> console.log(req.query)

    res.send('Hello World!')
})
app.get('/index', (req, res) => { // http://localhost:3000/contact
    res.sendFile(path.join(__dirname, './098_express_package_in_node_js.html'))
})
// write on url ending this -> "/about" that you go this pages 
app.get('/about', (req, res) => { // http://localhost:3000/about
    res.send('About')
})
app.get('/contact', (req, res) => { // http://localhost:3000/contact
    res.send('Contact!')
})
app.get('/map', (req, res) => { // http://localhost:3000/map
    res.send('Map')
})

app.listen(port, () => {
    console.log(`Example app listening on port http://localhost:${port}`)
})