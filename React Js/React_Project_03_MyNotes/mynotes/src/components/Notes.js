import React, { useContext } from 'react'
import noteContext from '../context/notes/NoteContext'
import NoteItem from './NoteItem';

const Notes = () => {
    const { notes, setNotes } = useContext(noteContext); // get notes from noteContext (using useContext hook). notes, setNotes is useState hook declared in NoteState.js file 

    return (
        <div className='row my-3'>
            <h2>Your Notes</h2>
            {notes.map((note) => {
                return <NoteItem note={note} />;
            })}
        </div>
    )
}

export default Notes