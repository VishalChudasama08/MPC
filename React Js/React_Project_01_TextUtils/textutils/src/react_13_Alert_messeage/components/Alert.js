import React from 'react'

function Alert(props) {
    const capitalize = (text) => {
        let lower = text.toLowerCase()
        return lower.charAt(0).toUpperCase() + lower.slice(1);
    }
    return (
        props.alert && <div className="alert alert-warning alert-dismissible fade show" role="alert"> {/* props.alert && <div... this si like a condition if true than next code (next code:- && than code like <div class=....) run else not use, here if props.alert is true (not null) than next code run else (condition false) than next code not run*/}
            <strong className='me-3'>{capitalize(props.alert.type)}</strong> {props.alert.msg}
        </div>
    )
}

export default Alert