const express = require('express');
const User = require('../models/User');
const router = express.Router();
const { body, validationResult } = require('express-validator');

// Create A User using: POSt "/api/author/createUser". Doesn't require log-in    
router.post('/createUser', [
    body('name', 'Enter a valid name').isLength({ min: 3 }),
    body('email', 'Enter a valid email').isEmail(),
    body('password', 'Password must be atleast 8 characters').isLength({ min: 8 }),
], async (req, res) => {
    // Finds the validation errors in this request and wraps them in an object with handy functions
    const errors = validationResult(req);
    if (!errors.isEmpty()) { // if any field empty or invalid than showing this error with json 
        return res.status(400).json({ errors: errors.array() });
    }

    // Check whether the user with this email exists already 
    try {
        let user = await User.findOne({ email: req.body.email });
        if (user) {
            return res.status(400).json({ error: "Sorry a user with this email is already exists " });
        }
        user = await User.create({
            name: req.body.name,
            email: req.body.email,
            password: req.body.password
        })
        res.json(user) // send response to user (user info)
    } catch (error) {
        console.log(error.message);
        res.status(500).send("Some Error occured")
        const errorMessage = error.errmsg; // Extracting errmsg from the error object
        res.json({ errmsg: errorMessage }); // Sending only the errmsg in the response
    }
})

module.exports = router