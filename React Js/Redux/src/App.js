import './App.css';

import { Provider } from 'react-redux';
import store from './redux/store';
import Navbar from './components/Navbar';
import Home from './components/Home';

function App() {
	return (
		<>
			<Provider store={store}>
				<div className='container'>
					<Navbar />
					<Home />
				</div>
			</Provider>
		</>
	);
}

export default App;
