import './App.css';

import { Provider } from 'react-redux';
import store from './store/Store';
import ReduxApi from './components/ReduxApi';

function App() {
	return (
		<>
			<Provider store={store}>
				<ReduxApi />
			</Provider>
		</>
	);
}

export default App;

// json server start command 
// npx json-server --watch src/db.json --port 5000
// here --watch than provide path of your json file 
