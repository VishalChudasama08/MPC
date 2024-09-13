// for given Components name First later is capita this is good 

import React from 'react'

import PropTypes from 'prop-types'
import { Link } from 'react-router-dom'

// Modify with chatGPT because now 'defaultProps' deprecated than use this below code (direct provide default props in component function argument object)
const Navbar = ({ // in App.js file prop not set than this component use this default props
    title = 'vishal',
    aboutText = 'about us',
    modeProp,
    toggleDarkMode
}) => {
    // For Dark Mode
    let darkMode;
    modeProp === 'light' ? darkMode = true : darkMode = false
    // darkMode ? 'darkMode style' : 'lightMode style'
    return (
        <nav className={`navbar navbar-expand-lg py-0 navbar-${darkMode ? 'light border border-1 border-bottom' : 'dark rounded border border-1'}`} style={{ backgroundColor: darkMode ? '' : '#41464b' }}>
            <div className="container-fluid">
                {/* {title} that iu get props value that props name is title (this is set in App.js file this Component tag attribute ) */}
                <Link className="navbar-brand" to="/"><h4 className='m-0'>{title}</h4></Link>
                <button className="navbar-toggler p-0" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <Link className="nav-link" to="/About">{aboutText}</Link>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="/" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Options
                            </a>
                            <ul className={`dropdown-menu p-2 bg-${darkMode ? 'light' : 'dark border'}`} aria-labelledby="navbarDropdown">
                                <li><a className={`dropdown-item bg-${darkMode ? 'light' : 'dark text-light'}`} href="/">Action</a></li>
                                <li><a className={`dropdown-item bg-${darkMode ? 'light' : 'dark text-light'}`} href="/">Another action</a></li>
                                <li><hr className={`dropdown-divider ${darkMode ? '' : 'border'}`} /></li>
                                <li><a className={`dropdown-item bg-${darkMode ? 'light' : 'dark text-light'}`} href="/">Something else here !</a></li>
                            </ul>
                        </li>
                    </ul>

                    <div className="form-check form-switch my-3 me-3">
                        <input className="form-check-input" onClick={toggleDarkMode} type="checkbox" role="switch" id="flexSwitchCheckDefault" />
                        <label className={`form-check-label fw-bold text-${darkMode ? 'dark' : 'light'}`} htmlFor="flexSwitchCheckDefault">Dark Mode</label>
                    </div>
                </div>
            </div>
        </nav>
    )
}

export default Navbar

Navbar.propTypes = {
    title: PropTypes.string.isRequired, // isRequired use to if forgot to set this prop in App.js or defaultProps any, than showing error on console not in page
    aboutText: PropTypes.string
}
