import React, { useContext, useState } from 'react'
import noteContext from '../context/notes/NoteContext'

const AddNote = () => {
    const { addNote } = useContext(noteContext); // only need addNote useState than get this from useContext hook (present in NoteState.js file)

    const [note, setNote] = useState({ title: "", description: "", tag: "" })
    const [focusedField, setFocusedField] = useState({ title: false, description: false })

    // handle onChange all input
    const onChange = (event) => {
        setNote({ ...note, [event.target.name]: event.target.value })
    }

    // handle submit
    const handleSubmitNote = (event) => {
        event.preventDefault()
        addNote(note)
        setNote({ title: "", description: "", tag: "" });
    }

    const handleFocus = (fieldName) => { // using to showing minimum validation
        setFocusedField({ ...focusedField, fieldName: true })
    }

    return (
        <div>
            <h2>Add a Note</h2>
            <form>
                <div className="mb-3">
                    <label htmlFor="title" className="form-label">Make Title</label>
                    <input type="text" name='title' onChange={onChange} value={note.title} onFocus={() => (handleFocus('title'))} className="form-control" id="title" placeholder="what is note title ?" required />
                    {note.title.length > 0 && note.title.length < 3 && (<small className="text-danger">{"Minimum 3 characters required"}</small>)}
                </div>
                <div className="mb-3">
                    <label htmlFor="description" className="form-label">Enter New Note</label>
                    <textarea name='description' onChange={onChange} value={note.description} className="form-control" id="description" placeholder='what is note description ?' rows="3" required></textarea>
                    {note.description.length > 0 && note.description.length < 5 && <small className="text-danger" data-bs-toggle="tooltip" data-bs-placement="top" title="Tooltip on top">{"Minimum 5 characters required"}</small>}
                </div>
                <div className="mb-3">
                    <label htmlFor="tag" className="form-label">Make Tags</label>
                    <input type="text" name='tag' onChange={onChange} value={note.tag} className="form-control" id="tag" placeholder="what is note tag ?" />
                </div>
                <button type="submit" disabled={note.title.length < 3 || note.description.length < 5} className="btn btn-primary" onClick={handleSubmitNote}>Submit</button>
                {/* if title and description length is not allowed than disable */}
                {/* we all was note this form not submit, we use onClick listener, without submit all work first */}
            </form>
        </div>
    )
}

export default AddNote
