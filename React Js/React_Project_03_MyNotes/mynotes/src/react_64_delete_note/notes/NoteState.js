import { useState } from "react";
import noteContext from "./NoteContext"; // get context from NoteContext.js file

const NoteState = (props) => {
    const allNotes = [
        {
            "_id": "670a6b71b01b25897d272169c",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera",
            "description": "Video Number 54 Complited.",
            "tag": "Personal",
            "date": "2024-10-12T12:28:43.405Z",
            "__v": 0
        },
        {
            "_id": "670a6ba2901b25897d272169e",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-12T12:29:29.685Z",
            "__v": 0
        },
        {
            "_id": "670d0c34a789eff55056db354",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-14T12:19:22.340Z",
            "__v": 0
        },
        {
            "_id": "670a64b7b01b25897d272169c",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera",
            "description": "Video Number 54 Complited.",
            "tag": "Personal",
            "date": "2024-10-12T12:28:43.405Z",
            "__v": 0
        },
        {
            "_id": "670a6b5a901b25897d272169e",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-12T12:29:29.685Z",
            "__v": 0
        },
        {
            "_id": "670d0c4a7896eff55056db354",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-14T12:19:22.340Z",
            "__v": 0
        },
        {
            "_id": "670a6b7b01b725897d272169c",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera",
            "description": "Video Number 54 Complited.",
            "tag": "Personal",
            "date": "2024-10-12T12:28:43.405Z",
            "__v": 0
        },
        {
            "_id": "670a6ba9018b25897d272169e",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-12T12:29:29.685Z",
            "__v": 0
        },
        {
            "_id": "670d0c4a789e9ff55056db354",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-14T12:19:22.340Z",
            "__v": 0
        }
    ]
    const [notes, setNotes] = useState(allNotes);

    // Add note
    const addNote = ({ title, description, tag }) => { // function call time provide new add note object as argument
        // api call here

        const note = {
            "_id": "680d0c4a789e9ff55056db354",
            "user": "6807e458f1e86ab904462b27",
            "title": title,
            "description": description,
            "tag": tag,
            "date": "2024-10-14T12:19:22.340Z",
            "__v": 0
        };

        setNotes(notes.concat(note)); // that, new add note concat in all notes, concat() => Merge two or more array, not affect to original array, return new array than is merged array, || here new all note's array update in notes state using setNotes
    }

    // Delete note
    const deleteNote = (id) => { // for delete only need note id 
        // api call here

        setNotes(notes.filter((not) => { return not._id !== id })) // filter method condition true than than note allowed else not allowed, it's means condition false than than note remove from all note array 

    }

    // Edit note
    const editNote = () => {

    }

    return (
        <noteContext.Provider value={{ notes, addNote, deleteNote, editNote }}>
            {props.children}
        </noteContext.Provider>
    );
}

export default NoteState;