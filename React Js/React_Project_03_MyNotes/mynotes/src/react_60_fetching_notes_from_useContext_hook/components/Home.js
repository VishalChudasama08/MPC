import React, { useContext } from 'react'
import noteContext from '../context/notes/NoteContext'

const Home = () => {
    const { notes, setNotes } = useContext(noteContext); // get notes from noteContext (using useContext hook). notes, setNotes is useState hook declared in NoteState.js file 

    return (
        <div>
            <h2>Add a Note</h2>
            <form>
                <div className="mb-3">
                    <label htmlFor="exampleFormControlInput1" className="form-label">Email address</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1" placeholder="name@example.com" />
                </div>
                <div className="mb-3">
                    <label htmlFor="exampleFormControlTextarea1" className="form-label">Example textarea</label>
                    <textarea className="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
            <h2>Your Notes</h2>
            {notes.map((note) => {
                return note.title;
            })};
        </div>
    )
}

export default Home