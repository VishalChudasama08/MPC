import React from 'react'
import { Link, useNavigate } from 'react-router-dom';

const Navbar = () => {
	const navigate = useNavigate();

	return (
		<>
			<nav className="bg-white dark:bg-gray-900 border-b border-gray-200 dark:border-gray-600">
				<div className="flex flex-wrap items-center justify-between mx-auto p-2">
					<a href="/" className="flex items-center space-x-3 rtl:space-x-reverse">
						<span className="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Vishal</span>
					</a>

					<div className="items-center justify-between hidden w-full md:flex md:w-auto md:order-1" id="navbar-user">
						<ul className="flex flex-col font-medium p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
							<li>
								<Link to="/" className={`block py-2 px-3 bg-blue-700 rounded md:bg-transparent ${window.location.pathname === "/" ? "md:text-blue-700" : "md:hover:text-blue-400"} md:p-0 md:dark:text-blue-500`}>Home</Link>
							</li>
							<li>
								<Link to="/Electronics" className={`block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent ${window.location.pathname === "/Electronics" ? "md:text-blue-700" : "md:hover:text-blue-400"} md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700`}>Electronics</Link>
							</li>
							<li>
								<Link to="/ClothingAccessories" className={`block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent ${window.location.pathname === "/ClothingAccessories" ? "md:text-blue-700" : "md:hover:text-blue-400"} md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700`}>Clothing & Accessories</Link>
							</li>
							<li>
								<Link to="/GroceryGourmetFood" className={`block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent ${window.location.pathname === "/GroceryGourmetFood" ? "md:text-blue-700" : "md:hover:text-blue-400"} md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700`}>Grocery & Gourmet Food</Link>
							</li>
							<li>
								<Link to="/HealthWellness" className={`block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent ${window.location.pathname === "/HealthWellness" ? "md:text-blue-700" : "md:hover:text-blue-400"} md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700`}>Health & Wellness</Link>
							</li>
							<li>
								<Link to="/BeautyPersonalCare" className={`block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent ${window.location.pathname === "/BeautyPersonalCare" ? "md:text-blue-700" : "md:hover:text-blue-400"} md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700`}>Beauty & Personal Care</Link>
							</li>
						</ul>
					</div>

					{/* <!-- User Profile Dropdown menu --> */}
					<div className="flex items-center md:order-2 space-x-3 md:space-x-0 rtl:space-x-reverse">
						<Link to="/Login" className={`block py-2 px-3 font-medium text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent ${window.location.pathname === "/Login" ? "md:text-blue-700" : "md:hover:text-blue-400"} md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700`}>Login</Link>
						<Link to="/Registration" className={`block py-2 px-3 font-medium text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent ${window.location.pathname === "/Registration" ? "md:text-blue-700" : "md:hover:text-blue-400"} md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700`}>Register</Link>

						<button type="button" className="flex text-sm bg-gray-800 rounded-full md:me-0 focus:ring-4 focus:ring-gray-300 dark:focus:ring-gray-600" id="user-menu-button" aria-expanded="false" data-dropdown-toggle="user-dropdown" data-dropdown-placement="bottom">
							<span className="sr-only">Open user menu</span>
							<img className="w-8 h-8 rounded-full" src="/docs/images/people/profile-picture-3.jpg" alt="User profile" />
						</button>
						<div className="z-50 hidden my-4 text-base list-none bg-white divide-y divide-gray-100 rounded-lg shadow dark:bg-gray-700 dark:divide-gray-600" id="user-dropdown">
							<div className="px-4 py-3">
								<span className="block text-sm text-gray-900 dark:text-white">Bonnie Green</span>
								<span className="block text-sm  text-gray-500 truncate dark:text-gray-400">name@flowbite.com</span>
							</div>
							<ul className="py-2" aria-labelledby="user-menu-button">
								<li>
									<a href="/Dashboard" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Dashboard</a>
								</li>
								<li>
									<a href="/Settings" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Settings</a>
								</li>
								<li>
									<a href="/Earnings" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Earnings</a>
								</li>
								<li>
									<Link to="/SignOut" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Sign out</Link>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</nav>

		</>
	)
}

export default Navbar