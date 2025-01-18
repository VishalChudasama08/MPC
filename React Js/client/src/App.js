import './App.css';
import {
	Route,
	BrowserRouter as Router,
	Routes,
} from "react-router-dom";
import HomePage from './Components/HomePage';
import StatusViewer from './Components/Status/StatusViewer';
function App() {
	return (
		<Router>
			<div>
				<Routes>
					<Route path='/' element={<HomePage />}></Route>
					<Route path='/status/:userId' element={<StatusViewer />}></Route>
				</Routes>
			</div>
		</Router>
	);
}

export default App;
