import { useState } from "react";
import noteContext from "./NoteContext"; // get context from NoteContext.js file

const NoteState = (props) => {
    const host = "http://localhost:5000";
    const [notes, setNotes] = useState([]);
    const [alert, setAlert] = useState({ type: "", msg: "" })
    // setAlert(null)

    const showAlert = (type, massage) => {
        setAlert({
            type: type,
            msg: massage
        })
        setTimeout(() => {
            setAlert({ type: "", msg: "" })
        }, 1500);
    }

    // get all notes
    const getAllNotes = async () => {
        try {
            const response = await fetch(`${host}/api/note/fetchAllNotes`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'auth-token': localStorage.getItem('UserToken'),
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
                    'auth-token': localStorage.getItem('UserToken'),
                },
                body: JSON.stringify({ title, description, tag })
            });

            const newNote = await response.json();
            // console.log("Fetched notes:", notesData);

            // client side: add note with than note showing in screen (run wen client fill and submit form)
            setNotes(notes.concat(newNote))// that, new add note concat in all notes, concat() => Merge two or more array, not affect to original array, return new array than is merged array, || here new all note's array update in notes state using setNotes
            showAlert("success", "New note added successfully.")
        } catch (error) {
            console.error("Error fetching notes:", error.message);
            showAlert("danger", "New note not added")
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
                    'auth-token': localStorage.getItem('UserToken'),
                },
            });
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            showAlert("warning", "Note deleted successfully.")
        } catch (error) {
            console.error("Error fetching notes:", error.message);
            showAlert("danger", "Note not deleted")
        }

        // client side: delete note and remove from screen (run wen client click delete icon)
        setNotes(notes.filter((not) => { return not._id !== id })) // filter method condition true than than note allowed else not allowed, it's means condition false than than note remove from all note array
    }

    // Edit note
    const editNote = async (updatedNote) => {
        let id = updatedNote._id
        let title = updatedNote.eTitle
        let description = updatedNote.eDescription
        let tag = updatedNote.eTag
        // api call here
        try {
            const response = await fetch(`${host}/api/note/updateNote/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'auth-token': localStorage.getItem('UserToken'),
                },
                body: JSON.stringify({ title, description, tag })
            });
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            showAlert("success", "Note edited successfully.")
        } catch (error) {
            console.error("Error fetching notes:", error.message);
            showAlert("danger", "Note not edited.")
        }

        let newNotes = JSON.parse(JSON.stringify(notes))
        // client side: edit note and showing than new note in screen (run wen client click edit icon)
        for (let index = 0; index < newNotes.length; index++) {
            const element = newNotes[index];
            if (element._id === id) {
                newNotes[index].title = title
                newNotes[index].description = description
                newNotes[index].tag = tag
                break
            }
        }
        setNotes(newNotes)
    }

    return (
        <noteContext.Provider value={{ notes, getAllNotes, addNote, deleteNote, editNote, alert, showAlert }}>
            {props.children}
        </noteContext.Provider>
    );
}

export default NoteState;