const connectToMongo = require('./db');
const express = require('express')

connectToMongo();

const app = express()
const port = 5000

app.use(express.json()) // use to send json request 

// Available Routes 
app.use('/api/author', require('./routes/author'))
app.use('/api/notes', require('./routes/notes'))

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})

/* 
**************** For Run *****************

first command :- Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
than second command :- nodemon .\index.js

like this -->
PS D:\Happy_Coding\My_Code_In_Github\MPC\React Js\React_Project_03_MyNotes\mynotes\backend> Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
>> nodemon .\index.js

*/