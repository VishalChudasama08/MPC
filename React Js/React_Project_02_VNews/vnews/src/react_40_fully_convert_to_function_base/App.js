import './App.css';
import React, { useState } from 'react'
import NavBar from './components/NavBar';
import News from './components/News';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import LoadingBar from 'react-top-loading-bar'

const App = () => {
  let newsPerPage = 12

  // e4e19cdc690c45e5a82a414d018d5d25
  let apiKey = process.env.REACT_APP_VNEWS_API_KEY; // process.env -> use to access local Environment variable
  // REACT_APP_VNEWS_API_KEY -> is variable name see in '.env.local' file. 
  // file location "MPC/React js/.env.local" git ignore this file 

  const [progress, setProgress] = useState(0);

  return (
    <div>
      <Router>
        <NavBar />
        <LoadingBar
          color='#f11946'
          progress={progress}
        />
        <Switch>
          <Route exact path="/"><News apiKey={apiKey} progressBar={setProgress} key={'science'} pageSize={newsPerPage} country={'us'} category={'science'} /></Route>

          <Route exact path="/business"><News apiKey={apiKey} progressBar={setProgress} key={'business'} pageSize={newsPerPage} country={'us'} category={'business'} /></Route>
          <Route exact path="/entertainment"><News apiKey={apiKey} progressBar={setProgress} key={'entertainment'} pageSize={newsPerPage} country={'us'} category={'entertainment'} /></Route>
          <Route exact path="/general"><News apiKey={apiKey} progressBar={setProgress} key={'general'} pageSize={newsPerPage} country={'us'} category={'general'} /></Route>
          <Route exact path="/health"><News apiKey={apiKey} progressBar={setProgress} key={'health'} pageSize={newsPerPage} country={'us'} category={'health'} /></Route>
          <Route exact path="/science"><News apiKey={apiKey} progressBar={setProgress} key={'science'} pageSize={newsPerPage} country={'us'} category={'science'} /></Route>
          <Route exact path="/sports"><News apiKey={apiKey} progressBar={setProgress} key={'sports'} pageSize={newsPerPage} country={'us'} category={'sports'} /></Route>
          <Route exact path="/technology"><News apiKey={apiKey} progressBar={setProgress} key={'technology'} pageSize={newsPerPage} country={'us'} category={'technology'} /></Route>
        </Switch>
      </Router>
    </div>
  )
}

export default App;
