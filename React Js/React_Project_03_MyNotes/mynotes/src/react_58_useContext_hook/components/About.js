import React, { useContext, useEffect } from 'react'
import noteContext from '../context/notes/NoteContext'

const About = () => {
    const a = useContext(noteContext); // use useContext hook to access (get) NoteState.js file Provided value  

    useEffect(() => { // using useEffect hook for a
        a.update() // call NoteState.js file function form this file using useContext
        // eslint-disable-next-line
    }, [])
    return (
        <div>
            This is About.<br />
            NoteState.js file obj value is <br />
            Name: {a.state.name}, Id: {a.state.id}
        </div>
    )
}

export default About