    // src/App.js

    import React, {Component} from 'react';
    import LanguagesApp from './components/LanguagesApp.jsx'
    import './App.css'
    import './bootstrap.css'

    class App extends Component {
      render () {
        return (
          <div className="App">
            <LanguagesApp />
          </div>
        );
      }
    }

    export default App;
