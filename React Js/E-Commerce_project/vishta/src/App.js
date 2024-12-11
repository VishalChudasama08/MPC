import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Product from './components/Product';
import ProductDetail from './components/ProductDetail';

function App() {
	return (
		<>
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
		</>
	);
}

export default App;
