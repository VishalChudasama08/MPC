import { useState } from "react";
import noteContext from "./NoteContext"; // get context from NoteContext.js file

const NoteState = (props) => {
    const allNotes = [
        {
            "_id": "670a6b7b01b25897d272169c",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera",
            "description": "Video Number 54 Complited.",
            "tag": "Personal",
            "date": "2024-10-12T12:28:43.405Z",
            "__v": 0
        },
        {
            "_id": "670a6ba901b25897d272169e",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-12T12:29:29.685Z",
            "__v": 0
        },
        {
            "_id": "670d0c4a789eff55056db354",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-14T12:19:22.340Z",
            "__v": 0
        },
        {
            "_id": "670a6b7b01b25897d272169c",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera",
            "description": "Video Number 54 Complited.",
            "tag": "Personal",
            "date": "2024-10-12T12:28:43.405Z",
            "__v": 0
        },
        {
            "_id": "670a6ba901b25897d272169e",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-12T12:29:29.685Z",
            "__v": 0
        },
        {
            "_id": "670d0c4a789eff55056db354",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-14T12:19:22.340Z",
            "__v": 0
        },
        {
            "_id": "670a6b7b01b25897d272169c",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera",
            "description": "Video Number 54 Complited.",
            "tag": "Personal",
            "date": "2024-10-12T12:28:43.405Z",
            "__v": 0
        },
        {
            "_id": "670a6ba901b25897d272169e",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-12T12:29:29.685Z",
            "__v": 0
        },
        {
            "_id": "670d0c4a789eff55056db354",
            "user": "6707e458f1e86ab904462b27",
            "title": "Dasera saturday",
            "description": "Bakend Express Js part is Done",
            "tag": "Personal",
            "date": "2024-10-14T12:19:22.340Z",
            "__v": 0
        }
    ]
    const [notes, setNotes] = useState(allNotes);

    return (
        <noteContext.Provider value={{ notes, setNotes }}>
            {props.children}
        </noteContext.Provider>
    );
}

export default NoteState;