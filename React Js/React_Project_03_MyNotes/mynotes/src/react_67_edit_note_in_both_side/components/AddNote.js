import React, { useContext, useState } from 'react'
import noteContext from '../context/notes/NoteContext'

const AddNote = () => {
    const { addNote } = useContext(noteContext); // only need addNote useState than get this from useContext hook (present in NoteState.js file)

    const [note, setNote] = useState({ title: "", description: "", tag: "" })

    // handle onChange all input
    const onChange = (event) => {
        setNote({ ...note, [event.target.name]: event.target.value })
    }

    // handle submit
    const handleSubmitNote = (event) => {
        event.preventDefault()
        addNote(note)
    }
    return (
        <div>
            <h2>Add a Note</h2>
            <form>
                <div className="mb-3">
                    <label htmlFor="title" className="form-label">Make Title</label>
                    <input type="text" name='title' onChange={onChange} className="form-control" id="title" placeholder="what is note title ?" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="description" className="form-label">Enter New Note</label>
                    <textarea name='description' onChange={onChange} className="form-control" id="description" placeholder='what is note description ?' rows="3" required></textarea>
                </div>
                <div className="mb-3">
                    <label htmlFor="tag" className="form-label">Make Tags</label>
                    <input type="text" name='tag' onChange={onChange} className="form-control" id="tag" placeholder="what is note tag ?" />
                </div>
                <button type="submit" className="btn btn-primary" onClick={handleSubmitNote}>Submit</button>
            </form>
        </div>
    )
}

export default AddNote
