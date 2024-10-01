import './App.css';
import Navbar from './components/Navbar';
import NewContent from './components/NewContent';
import TextForm from './components/TextForm';
import React, { useState } from 'react';

function App() {
  const [mode, setMode] = useState('light') // dark than Dark Mode on else dark Mode off
  const toggleDarkMode = () => {
    if (mode === 'light') {
      setMode('dark')
      document.body.style.backgroundColor = "black";
    } else {
      setMode('light')
      document.body.style.backgroundColor = "white";
    }
  }
  return (
    <>
      <Navbar title="Vishal" aboutText="About us" modeProp={mode} toggleDarkMode={toggleDarkMode} />
      <div className={`container text-${mode === 'light' ? 'dark' : 'light'}`}>
        <TextForm modeProp={mode} />
        <NewContent modeProp={mode} />
      </div>
    </>
  );
}

export default App;
