import React, { Component } from 'react';
import './App.css';


import Header from './components/components.header/Header';
import Main from './components/components.main/Main';

class App extends Component {
  render() {
    return (
        <div>
            <Header />
            <Main />
        </div>
    );
  }
}

export default App;
