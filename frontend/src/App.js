    // src/App.js

    import React, {Component} from 'react';

    class App extends Component {

      state = {
        contacts: []
      }

      componentDidMount() {
        fetch('http://jsonplaceholder.typicode.com/users')
        .then(res => res.json())
        .then((data) => {
          this.setState({ contacts: data })
        })
        .catch(console.log)
      }      

      render () {
        return (
          // JSX to render goes here...
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Mike Acosta</h5>
              <h6 class="card-subtitle mb-2 text-muted">acostmic@oregonstate.edu</h6>
              <p class="card-text">Go Beavs!</p>
            </div>
          </div>          
        );
      }
    }

    export default App;
