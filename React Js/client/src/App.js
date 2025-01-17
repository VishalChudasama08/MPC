import './App.css';
import {
	Route,
	BrowserRouter as Router,
	Routes,
} from "react-router-dom";
import HomePage from './Components/HomePage';
function App() {
	return (
		<Router>
			<div>
				<Routes>
					<Route path='/' element={<HomePage />}></Route>
					<Route path='/' element={<HomePage />}></Route>
				</Routes>
			</div>
		</Router>
	);
}

export default App;
