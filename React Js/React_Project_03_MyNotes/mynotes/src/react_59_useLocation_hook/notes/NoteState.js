import noteContext from "./NoteContext"; // get context from NoteContext.js file

const NoteState = (props) => {
    return (
        <noteContext.Provider value={{}}>
            {props.children}
        </noteContext.Provider>
    );
}

export default NoteState;