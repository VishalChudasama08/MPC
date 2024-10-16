import './App.css';
import Alert from './components/Alert';
import Navbar from './components/Navbar';
import About from './components/About';
import TextForm from './components/TextForm';
import React, { useState } from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom"; // npm install react-router-dom@5
// https://v5.reactrouter.com/web/guides/quick-start

function App() {
  const [mode, setMode] = useState('light') // dark than Dark Mode on else dark Mode off
  const toggleDarkMode = () => {
    if (mode === 'light') {
      setMode('dark')
      document.body.style.backgroundColor = "black";
      showAlert("Dark Mode is on", "success")
    } else {
      setMode('light')
      document.body.style.backgroundColor = "white";
      showAlert("Dark Mode is off", "success")
    }
  }

  const [alert, setAlert] = useState(null)

  const showAlert = (massage, type) => {
    setAlert({
      msg: massage,
      type: type
    })
    setTimeout(() => {
      setAlert(null)
    }, 1500);
  }

  return (
    <Router>
      <Navbar title="Vishal" aboutText="About us" modeProp={mode} toggleDarkMode={toggleDarkMode} />
      <Alert alert={alert} />
      <div className={`container text-${mode === 'light' ? 'dark' : 'light'}`}>
        <Switch>
          <Route exact path="/">
            <TextForm modeProp={mode} showAlert={showAlert} />
          </Route>
          <Route exact path="/about">
            <About modeProp={mode} />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
