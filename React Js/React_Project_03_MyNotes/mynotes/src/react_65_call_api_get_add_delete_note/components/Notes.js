import React, { useContext, useEffect } from 'react'
import noteContext from '../context/notes/NoteContext'
import NoteItem from './NoteItem';
import AddNote from './AddNote';

const Notes = () => {
    const { notes, getAllNotes } = useContext(noteContext); // get notes from noteContext (using useContext hook). notes, addNote,... is useContext hook provided value in NoteState.js file 

    useEffect(() => {
        getAllNotes(); // Fetch all notes when component loads
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []); // Include `getAllNotes` in dependency array if it depends on other variables    

    return (
        <>
            <AddNote />
            <div className='row my-3'>
                <h2>Your Notes</h2>
                {notes.map((note) => {
                    return <NoteItem key={note._id} note={note} />;
                })}
            </div>
        </>
    )
}

export default Notes