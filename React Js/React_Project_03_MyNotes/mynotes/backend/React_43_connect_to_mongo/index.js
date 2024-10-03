const connectToMongo = require('./db');
const express = require('express')

connectToMongo();

const app = express()
const port = 3000

app.get('/', (req, res) => {
    res.send('Hello Vishal')
})

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})

/* 
For Run ==>
first command :- Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
than second command :- nodemon .\index.js

like this -->
PS D:\Happy_Coding\My_Code_In_Github\MPC\React Js\React_Project_03_MyNotes\mynotes\backend> Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
>> nodemon .\index.js

*/