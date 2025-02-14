import './App.css';
import {
	BrowserRouter as Router,
	Routes,
	Route,
} from "react-router-dom";
import HomePage from './Components/HomePage';
import StatusViewer from './Components/Status/StatusViewer';
import { Provider } from 'react-redux';
import { store } from './Redux/Store';
function App() {
	return (
		<Router>
			<Provider store={store}>
				<Routes>
					<Route path='/' element={<HomePage />}></Route>
					<Route path='/status/:userId' element={<StatusViewer />}></Route>
				</Routes>
			</Provider>
		</Router>
	);
}

export default App;
