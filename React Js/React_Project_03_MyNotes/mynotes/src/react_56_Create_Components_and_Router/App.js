import './App.css';

import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom"; // this is new version not match in video number #56

import Navbar from './components/Navbar';
import About from './components/About';
import Home from './components/Home';

function App() {
  return (
    <>
      <Router>
        <div>
          <Navbar />
          <Routes>
            <Route exact path="/" element={<Home />} />
            <Route exact path="/about" element={<About />} />
          </Routes>
        </div>
      </Router>
    </>
  );
}

export default App;
