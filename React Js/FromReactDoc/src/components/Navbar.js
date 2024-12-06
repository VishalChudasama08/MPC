import React from 'react'

const Navbar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark rounded m-1">
            <div className="container-fluid">
                <a className="navbar-brand" href="/">React.Dev</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            {/* using useLocation hook to change class */}
                            <a className="nav-link active" aria-current="page" href="/useState">useState</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link active" href="/About">About</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}

export default Navbar