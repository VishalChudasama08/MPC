import React, { useContext } from 'react'
import noteContext from '../context/notes/NoteContext'

function Alert(props) {
    const { alert } = useContext(noteContext)

    return (
        alert.type !== "" && <div className={`alert alert-${alert.type} alert-dismissible fade show py-2 px-3`} style={{
            display: 'flex',
            position: 'fixed', // Use fixed positioning to keep it at the top of the viewport
            top: '5px',
            left: '50%', // Center horizontally
            transform: 'translateX(-50%)', // Adjust horizontal positioning
            justifyContent: 'center',
            zIndex: 1
        }} role="alert"> {/* alert && <div... this si like a condition if true than next code (next code:- && than code like <div class=....) run else not use, here if alert is true (not null) than next code run else (condition false) than next code not run*/}
            {alert.msg}
        </div>
    )
}

export default Alert