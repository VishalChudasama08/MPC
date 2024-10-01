// for given Components name First later is capita this is good 

import React from 'react'

import PropTypes from 'prop-types'
import { Link } from 'react-router-dom'

const Navbar = (props) => { // props argument is react props 
    return (
        <nav className={`navbar navbar-expand-lg py-0 navbar-${props.modeProp === 'light' ? 'light' : 'dark rounded border border-1'}`} style={{ backgroundColor: props.modeProp === 'light' ? '' : '#41464b' }}>
            <div className="container-fluid">
                {/* {props.title} that iu get props value that props name is title (this is set in App.js file this Component tag attribute ) */}
                <Link className="navbar-brand" to="/">{props.title}</Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <Link className="nav-link" to="/About">{props.aboutText}</Link>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="/" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown
                            </a>
                            <ul className={`dropdown-menu p-2 bg-${props.modeProp === 'light' ? 'light' : 'dark border'}`} aria-labelledby="navbarDropdown">
                                <li><a className={`dropdown-item bg-${props.modeProp === 'light' ? 'light' : 'dark text-light'}`} href="/">Action</a></li>
                                <li><a className={`dropdown-item bg-${props.modeProp === 'light' ? 'light' : 'dark text-light'}`} href="/">Another action</a></li>
                                <li><hr className={`dropdown-divider ${props.modeProp === 'light' ? '' : 'border'}`} /></li>
                                <li><a className={`dropdown-item bg-${props.modeProp === 'light' ? 'light' : 'dark text-light'}`} href="/">Something else here</a></li>
                            </ul>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link disabled" href="/" tabindex="-1" aria-disabled="true">Disabled</a>
                        </li>
                    </ul>

                    <div className="form-check form-switch my-3 me-3">
                        <input className="form-check-input" onClick={props.toggleDarkMode} type="checkbox" role="switch" id="flexSwitchCheckDefault" />
                        <label className={`form-check-label fw-bold text-${props.modeProp === 'light' ? 'dark' : 'light'}`} htmlFor="flexSwitchCheckDefault">Dark Mode</label>
                    </div>

                    <form className="d-flex">
                        <input className="form-control me-2" style={{ backgroundColor: props.modeProp === 'light' ? '' : '#6c757d', color: props.modeProp === 'light' ? 'black' : 'white' }} type="search" placeholder="Search" aria-label="Search" />
                        <button className="btn btn-outline-success" type="submit">Search</button>
                    </form>
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

Navbar.defaultProps = { // in App.js file prop not set than this set default props
    title: "vishal",
    aboutText: "about us"
}
