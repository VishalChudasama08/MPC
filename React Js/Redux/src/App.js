import './App.css';

import { Provider } from 'react-redux';
import store from './redux/store';
import CounterMiter from './components/CounterMiter';
import CounterButtons from './components/CounterButtons';
import Navbar from './components/Navbar';
import Home from './components/Home';
import ArrayDisplay from './components/ArrayDisplay';
import ArrayButtons from './components/ArrayButtons';
import ObjectList from './components/ObjectList';
import ObjectForm from './components/ObjectForm';

function App() {
	return (
		<>
			<Provider store={store}>
				<div className='container'>
					<CounterMiter />
					<CounterButtons />
					<hr />
					<ArrayDisplay />
					<ArrayButtons />
					<hr />
					<ObjectList />
					<ObjectForm />

					<Navbar />
					<Home />
				</div>
			</Provider>
		</>
	);
}

export default App;
