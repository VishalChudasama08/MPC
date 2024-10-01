import './App.css';
import React, { Component } from 'react'
import NavBar from './components/NavBar';
import News from './components/News';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import LoadingBar from 'react-top-loading-bar'

export default class App extends Component {
  newsPerPage = 12

  // e4e19cdc690c45e5a82a414d018d5d25
  apiKey = process.env.REACT_APP_VNEWS_API_KEY; // process.env -> use to access local Environment variable
  // REACT_APP_VNEWS_API_KEY -> is variable name see in '.env.local' file. 
  // file location "MPC/React js/.env.local" git ignore this file 

  state = {
    progress: 0
  }

  setProgress = (updatedProgress) => {
    this.setState({ progress: updatedProgress })
  }

  render() {
    return (
      <div>
        <Router>
          <NavBar />
          <LoadingBar
            color='#f11946'
            progress={this.state.progress}
          />
          <Switch>
            <Route exact path="/"><News apiKey={this.apiKey} progressBar={this.setProgress} key={'science'} pageSize={this.newsPerPage} country={'us'} category={'science'} /></Route>

            <Route exact path="/business"><News apiKey={this.apiKey} progressBar={this.setProgress} key={'business'} pageSize={this.newsPerPage} country={'us'} category={'business'} /></Route>
            <Route exact path="/entertainment"><News apiKey={this.apiKey} progressBar={this.setProgress} key={'entertainment'} pageSize={this.newsPerPage} country={'us'} category={'entertainment'} /></Route>
            <Route exact path="/general"><News apiKey={this.apiKey} progressBar={this.setProgress} key={'general'} pageSize={this.newsPerPage} country={'us'} category={'general'} /></Route>
            <Route exact path="/health"><News apiKey={this.apiKey} progressBar={this.setProgress} key={'health'} pageSize={this.newsPerPage} country={'us'} category={'health'} /></Route>
            <Route exact path="/science"><News apiKey={this.apiKey} progressBar={this.setProgress} key={'science'} pageSize={this.newsPerPage} country={'us'} category={'science'} /></Route>
            <Route exact path="/sports"><News apiKey={this.apiKey} progressBar={this.setProgress} key={'sports'} pageSize={this.newsPerPage} country={'us'} category={'sports'} /></Route>
            <Route exact path="/technology"><News apiKey={this.apiKey} progressBar={this.setProgress} key={'technology'} pageSize={this.newsPerPage} country={'us'} category={'technology'} /></Route>
          </Switch>
        </Router>
      </div>
    )
  }
}
