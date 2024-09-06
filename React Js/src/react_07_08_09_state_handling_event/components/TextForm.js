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
    const handleClClick = () => {
        let newText = "";
        setText(newText)
    }

    let mybox = document.getElementById("myBox");
    const handleItClick = () => {
        mybox.classList.toggle("fst-italic"); // toggle class
    }
    const handleBoClick = () => {
        mybox.classList.toggle("fw-bold"); // toggle class
    }

    return (
        <>
            <div>
                <h2>{props.heading}</h2>
                <div className='mb-3'>
                    <textarea className='form-control' value={text} onChange={handleOnChange} id="myBox" rows="8" ></textarea>
                </div>
                <button className='btn btn-primary m-1' onClick={handleUpClick}>Upper Case</button>
                <button className='btn btn-primary m-1' onClick={handleLoClick}>Lower Case</button>
                <button className='btn btn-primary m-1' onClick={handleClClick}>Clear</button>
                <button className='btn btn-primary m-1' onClick={handleItClick}>Italic Text</button>
                <button className='btn btn-primary m-1' onClick={handleBoClick}>Bold Text</button>
            </div>
            <div className='my-2'>
                <h4>Your Text Summary:-</h4>
                <p>{text.split(" ").length} words and {text.length} characters</p>
            </div>
        </>
    )
}

export default TextForm