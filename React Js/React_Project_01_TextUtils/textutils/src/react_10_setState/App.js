import './App.css';
import Navbar from './components/Navbar';
import NewContent from './components/NewContent';
import TextForm from './components/TextForm';

function App() {
  return (
    <>
      <Navbar title="Vishal" aboutText="About us" />
      <NewContent />
    </>
  );
}

export default App;
