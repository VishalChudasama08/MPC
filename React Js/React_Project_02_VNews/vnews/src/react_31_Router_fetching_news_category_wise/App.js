import './App.css';


import React, { Component } from 'react'
import NavBar from './components/NavBar';
import News from './components/News';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";

export default class App extends Component {
  render() {
    return (
      <div>
        <Router>
          <NavBar />
          <Switch>
            <Route exact path="/"><News key={'science'} pageSize={8} country={'us'} category={'science'} /></Route>

            <Route exact path="/business"><News key={'business'} pageSize={8} country={'us'} category={'business'} /></Route>
            <Route exact path="/entertainment"><News key={'entertainment'} pageSize={8} country={'us'} category={'entertainment'} /></Route>
            <Route exact path="/general"><News key={'general'} pageSize={8} country={'us'} category={'general'} /></Route>
            <Route exact path="/health"><News key={'health'} pageSize={8} country={'us'} category={'health'} /></Route>
            <Route exact path="/science"><News key={'science'} pageSize={8} country={'us'} category={'science'} /></Route>
            <Route exact path="/sports"><News key={'sports'} pageSize={8} country={'us'} category={'sports'} /></Route>
            <Route exact path="/technology"><News key={'technology'} pageSize={8} country={'us'} category={'technology'} /></Route>
          </Switch>
        </Router>
      </div>
    )
  }
}
