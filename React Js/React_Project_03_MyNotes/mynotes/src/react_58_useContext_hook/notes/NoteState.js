import { useState } from "react";
import noteContext from "./NoteContext"; // get context from NoteContext.js file

const NoteState = (props) => {
    const obj = {
        "name": "Vishal",
        "id": "V2"
    }

    const [state, setState] = useState(obj); // create useState hook for obj object

    const update = () => {
        setTimeout(() => {
            setState({
                "name": "VVVVVVVVV",
                "id": "V8"
            })
        }, 3000)
    }
    return (
        <noteContext.Provider value={{ state, update }}>
            {props.children}
        </noteContext.Provider>
    );
}

export default NoteState;