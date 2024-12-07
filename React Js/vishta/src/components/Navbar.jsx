import React from 'react'
import { Link } from 'react-router-dom';

const Navbar = () => {
	return (
		<nav className="navbar navbar-expand-lg navbar-dark bg-dark border-bottom border-white">
			<div className="container-fluid">
				<Link className="navbar-brand" to="/">Vishta</Link>
				<button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span className="navbar-toggler-icon"></span>
				</button>
				<div className="collapse navbar-collapse" id="navbarSupportedContent">
					<ul className="navbar-nav me-auto mb-2 mb-lg-0">
						<li className="nav-item">
							{/* using useLocation hook to change class */}
							<Link className="nav-link active" to="/Electronics">Electronics</Link>
						</li>
						<li className="nav-item">
							<Link className="nav-link active" to="/ClothingAccessories">Clothing & Accessories</Link>
						</li>
						<li className="nav-item">
							<Link className="nav-link active" to="/GroceryGourmetFood">Grocery & Gourmet Food</Link>
						</li>
						<li className="nav-item">
							<Link className="nav-link active" to="/HealthWellness">Health & Wellness</Link>
						</li>
						<li className="nav-item">
							<Link className="nav-link active" to="/BeautyPersonalCare">Beauty & Personal Care</Link>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	)
}

export default Navbar