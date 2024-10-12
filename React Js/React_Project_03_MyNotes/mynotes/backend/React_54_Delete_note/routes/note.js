const express = require('express')
const router = express.Router();
const Note = require('../models/Note');
const fetchUser = require("../middleware/fetchUser");
const { body, validationResult } = require('express-validator');

////////////////////////////////////////////////////////////////////////////////////
/// ROUTER 1: Get All Notes using: GET "/api/note/fetchAllNotes". Login required ///
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


//////////////////////////////////////////////////////////////////////////////
/// ROUTER 2: Add new Note using: POST "/api/note/addNote". Login required ///
//////////////////////////////////////////////////////////////////////////////
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

//////////////////////////////////////////////////////////////////////////////////////////
/// ROUTER 3: Update Note using: PUT "/api/note/updateNote/:userId". Login required ///
//////////////////////////////////////////////////////////////////////////////////////////
router.put('/updateNote/:userId', fetchUser, async (req, res) => {
    try {
        const { title, description, tag } = req.body;

        const newNote = {} // create new note object for save updated note data

        // if exist than add note data in new note 
        if (title) { newNote.title = title }
        if (description) { newNote.description = description }
        if (tag) { newNote.tag = tag }

        // find the note to be updated and update it 
        let note = await Note.findById(req.params.userId); // get userId from url
        if (!note) { // if note not exist / user not found / userId is wrong / Not match
            return res.status(404).send("Not Found")
        }

        if (note.user.toString() !== req.user.id) { // if another user try to access another user note than
            return res.status(401).send("Not Allowed")
        }

        note = await Note.findByIdAndUpdate(req.params.userId, { $set: newNote }, { new: true }) // update newNote at past note
        res.json({ note })
    } catch (error) {
        console.log(error.message);
        res.status(500).send("Internal Server Error");
    }
})
//////////////////////////////////////////////////////////////////////////////////////////
/// ROUTER 4: Delete Note using: DELETE "/api/note/deleteNote/:userId". Login required ///
//////////////////////////////////////////////////////////////////////////////////////////
router.delete('/deleteNote/:userId', fetchUser, async (req, res) => {
    try {
        // find the note to be updated and update it 
        let note = await Note.findById(req.params.userId); // get userId from url
        if (!note) { // if note not exist / user not found / userId is wrong / Not match
            return res.status(404).send("Not Found")
        }

        if (note.user.toString() !== req.user.id) { // if another user try to access another user note than
            return res.status(401).send("Not Allowed")
        }

        note = await Note.findByIdAndDelete(req.params.userId) // Delete note
        res.json({ "success": "Note Delete successfully", note: note })
    } catch (error) {
        console.log(error.message);
        res.status(500).send("Internal Server Error");
    }
})

module.exports = router