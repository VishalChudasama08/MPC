import { useState } from "react";
import noteContext from "./NoteContext"; // get context from NoteContext.js file

const NoteState = (props) => {
    const host = "http://localhost:5000";
    const [notes, setNotes] = useState([]);

    const getAllNotes = async () => {
        try {
            const response = await fetch(`${host}/api/note/fetchAllNotes`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'auth-token': 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiNjcwN2U0NThmMWU4NmFiOTA0NDYyYjI3In0sImlhdCI6MTcyODY0NDgxMn0.58SKZk0mxVXIoks-0E-7lBxHjuYp4nCkO5GEno4eY_U',
                },
            });

            const notesData = await response.json();
            // console.log("Fetched notes:", notesData);

            setNotes(notesData); // Assuming setNotes updates your state with the notes
        } catch (error) {
            console.error("Error fetching notes:", error.message);
        }
    };

    // Add note
    const addNote = async ({ title, description, tag }) => { // function call time provide new add note object as argument
        // api call here
        try {
            const response = await fetch(`${host}/api/note/addNote`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'auth-token': 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiNjcwN2U0NThmMWU4NmFiOTA0NDYyYjI3In0sImlhdCI6MTcyODY0NDgxMn0.58SKZk0mxVXIoks-0E-7lBxHjuYp4nCkO5GEno4eY_U',
                },
                body: JSON.stringify({ title, description, tag })
            });

            const newNote = await response.json();
            // console.log("Fetched notes:", notesData);

            // client side: add note with than note showing in screen (run wen client fill and submit form)
            setNotes(notes.concat(newNote))// that, new add note concat in all notes, concat() => Merge two or more array, not affect to original array, return new array than is merged array, || here new all note's array update in notes state using setNotes
        } catch (error) {
            console.error("Error fetching notes:", error.message);
        }

    }

    // Delete note
    const deleteNote = async (id) => { // for delete only need note id 
        // api call here
        try {
            const response = await fetch(`${host}/api/note/deleteNote/${id}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                    'auth-token': 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiNjcwN2U0NThmMWU4NmFiOTA0NDYyYjI3In0sImlhdCI6MTcyODY0NDgxMn0.58SKZk0mxVXIoks-0E-7lBxHjuYp4nCkO5GEno4eY_U',
                },
            });
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
        } catch (error) {
            console.error("Error fetching notes:", error.message);
        }

        // client side: delete note and remove from screen (run wen client click delete icon)
        setNotes(notes.filter((not) => { return not._id !== id })) // filter method condition true than than note allowed else not allowed, it's means condition false than than note remove from all note array
    }

    // Edit note
    const editNote = ({ id, title, description, tag }) => {
        // api call here

        // client side: edit note and showing than new note in screen (run wen client click edit icon)
        notes.forEach((note) => {
            if (note._id === id) {
                note.title = title
                note.description = description
                note.tag = tag
            }
        })
    }

    return (
        <noteContext.Provider value={{ notes, getAllNotes, addNote, deleteNote, editNote }}>
            {props.children}
        </noteContext.Provider>
    );
}

export default NoteState;