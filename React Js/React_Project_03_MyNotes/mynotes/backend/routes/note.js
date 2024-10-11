const express = require('express')
const router = express.Router();
const Note = require('../models/Note');
const fetchUser = require("../middleware/fetchUser");
const { body, validationResult } = require('express-validator');

////////////////////////////////////////////////////////////////////////////////////
/// ROUTER 1: Get All Notes using: GET "/api/auth/fetchAllNotes". Login required ///
////////////////////////////////////////////////////////////////////////////////////
router.get('/fetchAllNotes', fetchUser, async (req, res) => {
    try {
        const note = await Note.find({ user: req.user.id })
        res.json(note)
    } catch (error) {
        console.log(error.message);
        res.status(500).send("Internal Server Error");
    }

})


////////////////////////////////////////////////////////////////////////////////////
/// ROUTER 2: Add new Note using: POST "/api/auth/addNote". Login required ///
////////////////////////////////////////////////////////////////////////////////////
router.post('/addNote', fetchUser, [
    body('title', 'Enter a valid title').isLength({ min: 3 }),
    body('description', 'description must be atleast 5 characters').isLength({ min: 5 }),
], async (req, res) => {
    // if there are error, return Bas request and the error
    const errors = validationResult(req);
    if (!errors.isEmpty()) { // if any field empty or invalid than showing this error with json 
        return res.status(400).json({ errors: errors.array() });
    }

    try {
        const { title, description, tag } = req.body;

        const note = new Note({ user: req.user.id, title, description, tag })
        const saveNote = await note.save()
        res.send(saveNote)
    } catch (error) {
        console.log(error.message);
        res.status(500).send("Internal Server Error");
    }

})

module.exports = router