import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Product from './components/Product';
import ProductDetail from './components/ProductDetail';
import { Provider } from 'react-redux';
import store from './store/store';

function App() {
	return (
		<>
			<Provider store={store}>
				<BrowserRouter>
					<Navbar />
					<div className='min-h-screen'>
						<Routes>
							<Route exact path='/Electronics' element={<Product />} />
							<Route exact path='/ClothingAccessories' element={<Product />} />
							<Route exact path='/GroceryGourmetFood' element={<Product />} />
							<Route exact path='/HealthWellness' element={<Product />} />
							<Route exact path='/BeautyPersonalCare' element={<Product />} />

							<Route exact path='/ProductDetail' element={<ProductDetail />} />

						</Routes>
					</div>
				</BrowserRouter>
			</Provider>
		</>
	);
}

export default App;

// start json server to work locally on api without database
// npx json-server --watch db.json --port 5050;
// in where db.json present else provide path like -> ...--watch src/db.json... for db.json is present in src folder 
