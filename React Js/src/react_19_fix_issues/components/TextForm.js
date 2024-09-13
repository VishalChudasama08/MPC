import React, { useState } from 'react'

const TextForm = (props) => {
    document.title = "Vishal: Home"

    const [text, setText] = useState('')
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
    const handleSpClick = () => {
        let str = '';
        text.split(' ').forEach(element => { if (element !== '') { str += element + ' ' } });
        setText(str);
        props.showAlert("Removed extra spaces", "success")
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

    // Text Counter
    let str1 = ""
    let str2 = ""
    let spaces = 0;
    let words = 0;

    const regex = /^[^\s]+@gmail\.com$/; // regular expression
    let gmail = 0

    text.split(/\s+/).forEach(element => {
        if (element !== '') {
            if (regex.test(element)) {
                gmail++
                words = words + (element.split(regex).length + 1) // split(regex).length => split where if found any symbol or number be present => example-> vishal8chudasama@gmail.com -> split(regex).length = 3 + 1 = total words = 4
                // console.log(element.split(regex));
                // console.log(element.split(regex).length);

            } else if (element.match(/[a-zA-Z]/g)) { // if any character found than true
                element.replace(/[^a-zA-Z]+/g, ' ').split(' ').forEach(ele => { if (ele !== '') { words++ } });
                // replace : જે માં અક્ષરો હોય નય તે ને replace કરે છે ' ' (whitespace) થી 
            }
            if (element.includes("\n")) {
                str1 += element.replace("\n", " ")
                str2 += element.replace("\n", "")
            } else {
                str1 += element + ' '
                str2 += element
            }
            spaces++
        } else {
            spaces++
        }
    });
    // console.log('str1=> ' + str1);
    // console.log('str2=> ' + str2);

    // let words = str1.split(' ').length - 1
    // let words = str1.match(/[a-zA-Z]/g).length
    let number = str1.match(/[0-9]/g) == null ? 0 : str1.match(/[0-9]/g).length
    let symbols = str2.match(/[^a-zA-Z0-9\s]/g) == null ? 0 : str2.match(/[^a-zA-Z0-9\s]/g).length
    let characters = str2.length - symbols;
    let newline = text.match(/\n/g) == null ? 0 : text.match(/\n/g).length;
    spaces = spaces - 1
    /* words, number, characters, (symbols == null ? 0 : symbols.length), newline, spaces, gmail */

    // For Dark Mode
    let darkMode;
    props.modeProp === 'light' ? darkMode = true : darkMode = false
    // darkMode ? 'darkMode style' : 'lightMode style'

    return (
        <>
            <div>
                <h2>{props.heading}</h2>
                <div className='mb-3'>
                    <textarea className='form-control' style={{ backgroundColor: darkMode ? '' : '#51575b', color: darkMode ? 'black' : 'white' }} value={text} onChange={handleOnChange} id="myBox" rows="8" placeholder='Enter Your Text Here...'></textarea>
                </div>
                <button className='btn btn-primary m-1' disabled={text.length === 0} onClick={handleUpClick}>Upper Case</button>
                <button className='btn btn-primary m-1' disabled={text.length === 0} onClick={handleLoClick}>Lower Case</button>
                <button className='btn btn-primary m-1' disabled={text.length === 0} onClick={handleCaClick}>Capitalize Text</button>
                <button className='btn btn-primary m-1' disabled={text.length === 0} onClick={handleSpClick}>Remove extra space</button>
                <button className='btn btn-primary m-1' disabled={text.length === 0} onClick={handleClClick}>Clear</button>
                <button className='btn btn-primary m-1' disabled={text.length === 0} onClick={handleItClick}>Italic Text</button>
                <button className='btn btn-primary m-1' disabled={text.length === 0} onClick={handleBoClick}>Bold Text</button>
                <button className='btn btn-success m-1' disabled={text.length === 0} onClick={handleCopy}>Copy Clipboard</button>
            </div>
            <div className='my-2'>
                <h4 style={{ display: 'inline' }}>Text Counter :- </h4>

                <p> {words} words , {characters} characters, {number} numbers, {symbols} symbols, {newline} newlines, {spaces} spaces and {gmail} gmail founds</p>
            </div>
        </>
    )
}

export default TextForm
