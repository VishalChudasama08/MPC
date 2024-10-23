import './App.css';

import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom"; // this is new version not match in video number #56

import Navbar from './components/Navbar';
import About from './components/About';
import Home from './components/Home';
import NoteState from './context/notes/NoteState';

function App() {
  return (
    <>
      <NoteState> {/* all child components able to access NoteState.js file provided value */}
        <Router>
          <Navbar />
          <div className='container'>
            <Routes>
              <Route exact path="/" element={<Home />} />
              <Route exact path="/about" element={<About />} />
            </Routes>
          </div>
        </Router>
      </NoteState>
    </>
  );
}

export default App;
