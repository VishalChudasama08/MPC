const express = require('express');
const User = require('../models/User');
const router = express.Router();
const { body, validationResult } = require('express-validator');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const fetchUser = require("../middleware/fetchUser");

const JWT_Secret = 'ThisIsJWTSecretString'

//////////////////////////////////////////////////////////////////////////////////////////
/// ROUTER 1: Create A User using: POST "/api/auth/createUser". Doesn't require log-in ///
//////////////////////////////////////////////////////////////////////////////////////////
router.post('/createUser', [
    body('name', 'Enter a valid name').isLength({ min: 3 }),
    body('email', 'Enter a valid email').isEmail(),
    body('password', 'Password must be atleast 8 characters').isLength({ min: 8 }),
], async (req, res) => {
    let success = false;
    // Finds the validation errors in this request and wraps them in an object with handy functions
    const errors = validationResult(req);
    if (!errors.isEmpty()) { // if any field empty or invalid than showing this error with json 
        success = false;
        return res.status(400).json({ success, errors: errors.array() });
    }

    // Check whether the user with this email exists already 
    try {
        let user = await User.findOne({ email: req.body.email });
        if (user) {
            success = false;
            return res.status(400).json({ success, error: "Sorry a user with this email is already exists " });
        }

        const salt = await bcrypt.genSalt(10); // create salt
        const secretPassword = await bcrypt.hash(req.body.password, salt); // crypt and add salt

        user = await User.create({
            name: req.body.name,
            email: req.body.email,
            password: secretPassword // save crypted password in mongo
        })

        const data = {
            user: {
                id: user.id
            }
        }
        const jwtToken = jwt.sign(data, JWT_Secret); // 
        // console.log(jwtToken);
        success = true
        res.json({ success, jwtToken }); // send response to jsonwebtoken 

    } catch (error) {
        console.log(error.message);
        res.status(500).send("Internal Server Error");
        const errorMessage = error.errmsg; // Extracting errmsg from the error object
        res.json({ errmsg: errorMessage }); // Sending only the errmsg in the response
    }
})


///////////////////////////////////////////////////////////////////////////////////////////////////////
/// ROUTER 2: User Log-in (user Authenticate) using: POST "/api/auth/login". Doesn't require log-in ///
///////////////////////////////////////////////////////////////////////////////////////////////////////
router.post('/login', [
    body('email', 'Enter a valid email').isEmail(),
    body('password', 'Password cannot be blank').exists(),
], async (req, res) => {
    let success = false;
    // If there are errors than, return Bad request and the errors 
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        return res.status(400).json({ errors: errors.array() });
    }

    const { email, password } = req.body; // get email and password from request body (than is user login time enter email or password. not from database)

    try {
        let user = await User.findOne({ email }); // match email (because email is unique) and get user from database (mongodb)

        if (!user) { // if user not exist than
            success = false
            return res.status(400).json({ success, err: "Please try to login with correct credentials" });
        }

        const passwordCompare = await bcrypt.compare(password, user.password);
        if (!passwordCompare) { // if passwordCompare not match than
            success = false
            return res.status(400).json({ success, err: "Please try to login with correct credentials" });
        }

        const payload = {
            user: {
                id: user.id // get user id from mongo 
            }
        }
        const jwtToken = jwt.sign(payload, JWT_Secret); // sign
        success = true
        // console.log(jwtToken);
        res.json({ success, jwtToken }) // response to send jwtToken

    } catch (error) {
        console.log(error.message);
        res.status(500).send("Internal Server Error");
    }
})


//////////////////////////////////////////////////////////////////////////////////
/// ROUTER 3: Get login detail using: POST "/api/auth/getUser". Login required ///
//////////////////////////////////////////////////////////////////////////////////
router.post('/getUser', fetchUser, async (req, res) => { // User login is required. This endpoint authenticates the user using the fetchUser middleware (from middleware/fetchUser.js) and fetches the logged-in user's details.
    try {
        // let userId = ;
        console.log(req.user); // Check what req.user contains

        const user = await User.findById(req.user.id).select("-password");
        // findById -> use for which user data fetch 
        // selected -> use for selected user fields if any field not needed than provide it on argument (here -password not needed)
        if (!user) {
            return res.status(404).send({ error: "User not found" });
        }

        res.send(user); // all done than send user details
    } catch (error) {
        console.log(error.message);
        res.status(500).send("Internal Server Error");
    }

})
module.exports = router