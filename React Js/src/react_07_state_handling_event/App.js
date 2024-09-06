import './App.css';
import Navbar from './components/Navbar';
import TextForm from './components/TextForm';

function App() {
  return (
    <>
      <Navbar title="Vishal" aboutText="About us" />
      <div className='container mt-2'>
        <TextForm heading="Enter Text to analyze below:" />
      </div>
    </>
  );
}

export default App;
