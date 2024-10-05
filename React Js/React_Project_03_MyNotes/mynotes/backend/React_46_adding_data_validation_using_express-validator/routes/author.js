const express = require('express');
const User = require('../models/User');
const router = express.Router();
const { body, validationResult } = require('express-validator');

// Create A User using: POSt "/api/author/". Doesn't require Author   
router.post('/', [
    body('name', 'Enter a valid name').isLength({ min: 3 }),
    body('email', 'Enter a valid email').isEmail(),
    body('password', 'Password must be atleast 8 characters').isLength({ min: 8 }),
], (req, res) => {
    // Finds the validation errors in this request and wraps them in an object with handy functions
    const errors = validationResult(req);
    if (!errors.isEmpty()) { // if any field empty or invalid than showing this error with json 
        return res.status(400).json({ errors: errors.array() });
    }
    User.create({
        name: req.body.name,
        email: req.body.email,
        password: req.body.password
    }).then(user => {
        res.json(user)
    }).catch(err => {
        console.log(err)
        const errorMessage = err.errmsg; // Extracting errmsg from the error object
        res.json({ errmsg: errorMessage }); // Sending only the errmsg in the response
    });
})

module.exports = router