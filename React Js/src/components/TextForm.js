import React, { useState } from 'react'

const TextForm = (props) => {
    const [text, setText] = useState('Enter Text Here...')
    // this is 'State', for use first import it 
    // and writ in component 
    // setText("new Text"); // correct way to change text

    const handleOnChange = (event) => {
        setText(event.target.value) // without this user not edit/add/remove text in textarea tag
    }

    const handleUpClick = () => {
        let newText = text.toUpperCase()
        setText(newText)
    }
    const handleLoClick = () => {
        let newText = text.toLowerCase()
        setText(newText)
    }

    return (
        <div>
            <h2>{props.heading}</h2>
            <div className='mb-3'>
                <textarea className='form-control' value={text} onChange={handleOnChange} id="myBox" rows="8" ></textarea>
            </div>
            <button className='btn btn-primary m-1' onClick={handleUpClick}>Convert to Upper Case</button>
            <button className='btn btn-primary m-1' onClick={handleLoClick}>Convert to Lower Case</button>
        </div>
    )
}

export default TextForm