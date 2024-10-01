import React, { useState } from 'react'

const TextForm = (props) => {
    const [text, setText] = useState('Enter Text Here...')
    // this is 'State', if use State than import it 
    // use for write a component 
    // first is variable (any name, here than is text)
    // second is function. use for set first variable value and more (any name, here than is setText)
    // setText("new Text"); // correct way to change text
    // in useState() argument is set variable type like in this 'text' is String type 
    // if useState(false) than that boolean type
    // if useState({
    //      name: 'vishal',
    //      age: 23
    // }) than that is object 


    const handleOnChange = (event) => {
        setText(event.target.value) // event.target.value -> without this user not edit/add/remove text in textarea tag
    }

    const handleUpClick = () => {
        let newText = text.toUpperCase()
        setText(newText)
        props.showAlert("Text Converted to UpperCase", "success")
    }
    const handleLoClick = () => {
        let newText = text.toLowerCase()
        setText(newText)
        props.showAlert("Text Converted to LowerCase", "success")
    }
    const handleClClick = () => {
        let newText = "";
        setText(newText)
        props.showAlert("Text is Clear", "success")
    }

    let mybox = document.getElementById("myBox");
    const handleItClick = () => {
        mybox.classList.toggle("fst-italic"); // toggle class
        props.showAlert("Text Converted to Italic", "success")
    }
    const handleBoClick = () => {
        mybox.classList.toggle("fw-bold"); // toggle class
        props.showAlert("Text Converted to bold", "success")
    }
    const handleCaClick = () => {
        let words = text.split(" ");
        let capitalize = "";
        for (let index = 0; index < words.length; index++) {
            let word = words[index];
            let lower = word.toLowerCase()
            capitalize += lower.charAt(0).toUpperCase() + lower.slice(1) + " "
        }
        setText(capitalize);
        props.showAlert("Text Converted to Capitalize", "success")
    }
    const handleCopy = () => {
        mybox.classList.toggle("fw-bold"); // toggle class
        let copyText = document.getElementById('myBox');
        copyText.select();
        navigator.clipboard.writeText(copyText.value);
        props.showAlert("Text Copy in clipboard successfully", "success")
    }

    return (
        <>
            <div>
                <h2>{props.heading}</h2>
                <div className='mb-3'>
                    <textarea className='form-control' style={{ backgroundColor: props.modeProp === 'light' ? '' : '#51575b', color: 'white' }} value={text} onChange={handleOnChange} id="myBox" rows="8" ></textarea>
                </div>
                <button className='btn btn-primary m-1' onClick={handleUpClick}>Upper Case</button>
                <button className='btn btn-primary m-1' onClick={handleLoClick}>Lower Case</button>
                <button className='btn btn-primary m-1' onClick={handleCaClick}>Capitalize Text</button>
                <button className='btn btn-primary m-1' onClick={handleClClick}>Clear</button>
                <button className='btn btn-primary m-1' onClick={handleItClick}>Italic Text</button>
                <button className='btn btn-primary m-1' onClick={handleBoClick}>Bold Text</button>
                <button className='btn btn-primary m-1' onClick={handleCopy}>Copy Clipboard</button>
            </div>
            <div className='my-2'>
                <h4>Your Text Summary:-</h4>
                <p>{text.split(" ").length} words and {text.length} characters</p>
            </div>
        </>
    )
}

export default TextForm
