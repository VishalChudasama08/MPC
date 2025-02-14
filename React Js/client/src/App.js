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
import Signin from './Components/Register/Signin';
import SignUp from './Components/Register/SignUp';
function App() {
	return (
		<Router>
			<Provider store={store}>
				<Routes>
					<Route path='/' element={<HomePage />}></Route>
					<Route path='/status/:userId' element={<StatusViewer />}></Route>
					<Route path='/signin' element={<Signin />}></Route>
					<Route path='/signup' element={<SignUp />}></Route>
				</Routes>
			</Provider>
		</Router>
	);
}

export default App;
