import React, { useContext, useEffect, useState, useRef } from 'react'
import noteContext from '../context/notes/NoteContext'
import NoteItem from './NoteItem';
import AddNote from './AddNote';

const Notes = () => {
    const { notes, getAllNotes } = useContext(noteContext); // get notes from noteContext (using useContext hook). notes, addNote,... is useContext hook provided value in NoteState.js file 

    useEffect(() => {
        getAllNotes(); // Fetch all notes when component loads
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []); // Include `getAllNotes` in dependency array if it depends on other variables 

    const toggleModal = useRef(null);

    const [note, setNote] = useState({ _id: "", eTitle: "", eDescription: "", eTag: "" })

    const updateNote = (currentNote) => {
        toggleModal.current.click()
        setNote({ _id: currentNote._id, eTitle: currentNote.title, eDescription: currentNote.description, eTag: currentNote.tag })
    }

    // handle onChange all input
    const onChange = (event) => {
        setNote({ ...note, [event.target.name]: event.target.value })
    }

    // handle edit note
    const handleEditNote = (event) => {
        toggleModal.current.click()
        console.log("updating", note);

        event.preventDefault()
    }

    return (
        <>
            <AddNote />

            {/* <!-- Button trigger modal --> */}
            <button type="button" ref={toggleModal} className="btn btn-primary d-none" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Launch demo modal
            </button>

            {/* <!-- Modal --> */}
            <div className="modal fade" id="exampleModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="exampleModalLabel">Edit Note</h5>
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            <form>
                                <div className="mb-3">
                                    <label htmlFor="eTitle" className="form-label">Edit Title</label>
                                    <input type="text" name='eTitle' onChange={onChange} value={note.eTitle} className="form-control" id="eTitle" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="eDescription" className="form-label">Edit New Note</label>
                                    <textarea name='eDescription' onChange={onChange} value={note.eDescription} className="form-control" id="eDescription" rows="3"></textarea>
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="eTag" className="form-label">Edit Tags</label>
                                    <input type="text" name='eTag' onChange={onChange} value={note.eTag} className="form-control" id="eTag" />
                                </div>
                            </form>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" className="btn btn-primary" onClick={handleEditNote}>Save changes</button>
                        </div>
                    </div>
                </div>
            </div>

            <div className='row my-3'>
                <h2>Your Notes</h2>
                {notes.map((note) => {
                    return <NoteItem key={note._id} updateNote={updateNote} note={note} />;
                })}
            </div>
        </>
    )
}

export default Notes