const express = require('express');
const User = require('../models/User');
const router = express.Router();

// Create A User using: POSt "/api/author/". Doesn't require Author   
router.post('/', (req, res) => {
    console.log(req.body); // request data see in console
    res.send(req.body) // response to send data (here request data send)

    const user = User(req.body);
    user.save() // save request data in mongo 
    // default data save on test database  
})

module.exports = router