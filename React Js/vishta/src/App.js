import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Product from './components/Product';
import ProductDetail from './components/ProductDetail';

function App() {
	return (
		<div className="App">
			<Router>
				<Navbar />
				<div>
					<Routes>
						<Route exact path='/Electronics' element={<Product />} />
						<Route exact path='/ClothingAccessories' element={<Product />} />
						<Route exact path='/GroceryGourmetFood' element={<Product />} />
						<Route exact path='/HealthWellness' element={<Product />} />
						<Route exact path='/BeautyPersonalCare' element={<Product />} />

						<Route exact path='/ProductDetail' element={<ProductDetail />} />

					</Routes>
				</div>
			</Router>
		</div>
	);
}

export default App;
