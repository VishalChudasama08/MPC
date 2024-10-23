import React from 'react'

import { Link, useLocation } from "react-router-dom";

const Navbar = () => {
    let location = useLocation(); // useLocation is hook. present in react-router-dom package. using to work on url 
    React.useEffect(() => {
        // console.log(location);
        console.log(location.pathname); // .pathname to get url (not full url)
    }, [location]);
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <div className="container-fluid">
                <Link className="navbar-brand" to="/">MyNotes</Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            {/* using useLocation hook to change class */}
                            <Link className={`nav-link ${location.pathname === "/" ? "active" : ""}`} aria-current="page" to="/">Home</Link>
                        </li>
                        <li className="nav-item">
                            <Link className={`nav-link ${location.pathname === "/About" ? "active" : ""}`} to="/About">About</Link>
                        </li>
                    </ul>
                    <form className="d-flex">
                        <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                        <button className="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    )
}

export default Navbar