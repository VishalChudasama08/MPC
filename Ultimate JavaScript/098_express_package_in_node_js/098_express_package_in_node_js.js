// npm init -y
// to create package.json file

// npm install express --save
// install express package file this command this create node_modules folder and package-lock.json file

const express = require('express')
const app = express()
const port = 3000

// this is defrant pages if you write on url it than is showing

app.get('/', (req, res) => { // http://localhost:3000
    res.send('Hello World!')
})
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