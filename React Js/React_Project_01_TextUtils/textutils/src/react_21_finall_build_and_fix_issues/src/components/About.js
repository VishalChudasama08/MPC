import React from 'react'

export default function About(props) {
    document.title = "Vishal: About"

    // For Dark Mode
    let darkMode;
    props.modeProp === 'light' ? darkMode = true : darkMode = false
    // darkMode ? 'darkMode style' : 'lightMode style'

    return (
        <div className="accordion my-3" id="accordionExample">
            <div className="accordion-item">
                <h2 className="accordion-header" id="headingOne">
                    <button className={`accordion-button collapsed bg-${darkMode ? 'light' : 'dark text-white'}`} type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne" >
                        <h5 className='m-0'>About TextUtils</h5>
                    </button>
                </h2>
                <div id="collapseOne" className={`accordion-collapse collapse show bg-${darkMode ? 'light' : 'dark'}`} aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                    <div className="accordion-body" >
                        <p>
                            TextUtils is a simple yet powerful tool designed to help you manipulate and analyze text efficiently. Whether you need to remove extra spaces, convert text to uppercase or lowercase, capitalize sentences, or style text with bold and italics, TextUtils provides all the functionality you need in one place. It's an ideal solution for content creators, writers, developers, and anyone who works with large amounts of text.
                        </p>
                        <p>
                            With TextUtils, you can also perform advanced operations such as counting words, characters, numbers, and symbols in real-time. The tool also supports email address detection, making it a versatile utility for cleaning up text and performing analysis quickly and accurately.
                        </p>
                    </div>
                </div>
            </div>
            <div className="accordion-item">
                <h2 className="accordion-header" id="headingTwo">
                    <button className={`accordion-button collapsed bg-${darkMode ? 'light' : 'dark text-white'}`} type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" >
                        <h5 className='m-0'>Key Features</h5>
                    </button>
                </h2>
                <div id="collapseTwo" className={`accordion-collapse collapse bg-${darkMode ? 'light' : 'dark'}`} aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                    <div className="accordion-body" >
                        <ul>
                            <li>Convert text to uppercase, lowercase, or capitalize each word.</li>
                            <li>Remove extra spaces or line breaks for cleaner formatting.</li>
                            <li>Count words, characters, symbols, and email addresses instantly.</li>
                            <li>Style text with bold or italics for emphasis.</li>
                            <li>Dark mode support for a better user experience in low-light environments.</li>
                        </ul>
                        <p>
                            TextUtils is a lightweight, browser-based tool, ensuring that all operations are done directly on your device with no need for external servers or data processing.
                        </p>
                    </div>
                </div>
            </div>
            <div className="accordion-item">
                <h2 className="accordion-header" id="headingThree">
                    <button className={`accordion-button collapsed bg-${darkMode ? 'light' : 'dark text-white'}`} type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree" >
                        <h5 className='m-0'>Our Mission</h5>
                    </button>
                </h2>
                <div id="collapseThree" className={`accordion-collapse collapse bg-${darkMode ? 'light' : 'dark'}`} aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                    <div className="accordion-body" >
                        <p>
                            Our mission is to make text processing simpler, faster, and more accessible for everyone. Whether you are editing simple text or performing detailed analysis, TextUtils provides a range of features to meet your needs efficiently.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    )
}
