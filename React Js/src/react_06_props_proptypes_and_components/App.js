import './App.css';
import Navbar from './components/Navbar';

function App() {
  return (
    <>
      {/* Add Component, this tag add Navbar.js file from component folder*/}
      {/* for add this component need to import Navbar (here import Navbar from './components/Navbar';),  write -> <Navbar than enter vs code add this component import line*/}

      {/* title="Vishal" this is props, set any unick name and given value */}
      <Navbar title="Vishal" aboutText="About us" />

      <Navbar />

      <Navbar title={1} aboutText="About us" />
    </>
  );
}

export default App;
