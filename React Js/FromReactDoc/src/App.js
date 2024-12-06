import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import UseStateHook from './components/UseStateHook';
import Home from './components/Home'

function App() {
	return (
		<>
			<Router>
				<Navbar />
				{/* <CursorMove /> */}
				<UseStateHook />
				<Routes>
					<Route exact path='/About' element={<Home />} />
				</Routes>
			</Router>
		</>
	);
}

export default App;
