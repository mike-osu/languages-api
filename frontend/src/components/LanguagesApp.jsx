import React, {Component, useState} from 'react'
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom'
import withNavigation from './WithNavigation';
import Languages from './languages'

class WelcomeComponent extends Component {
    render() {
        return <div>
                Welcome!<br />
                Go to <Link to="/languages">Languages</Link>
            </div>
    }
}

class LoginComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            username: 'mike',
            password: ''
        }
        this.handleChange = this.handleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]:event.target.value
            }
        )
    }

    loginClicked() {
        if (this.state.username !== '' && this.state.password !== '') {
            this.props.navigate('/welcome')
        }
    }

    render () {
        return (
            <div>
                Username: <input type="text" name="username" value={this.state.username} onChange={this.handleChange} /><br />
                Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChange} /><br />
                <button onClick={this.loginClicked}>Login</button>
            </div>
        )
    }
}

const token = ''

class LanguagesComponent extends Component {
    state = {
        languages: []
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/v1/languages', {
            method: 'GET',
            mode: 'cors',
            headers: {
                Authorization: "Bearer " + token
            }
        })
        .then(res => res.json())
        .then((data) => {
            this.setState({ languages: data })
        })
        .catch(console.log)
    }      

    render () {
        return (
            <div className="App">
                <Languages languages={this.state.languages} />
            </div>
        );
    }
}

const LoginComponentWithNavigation = withNavigation(LoginComponent);

class LanguagesApp extends Component {
    render() {
        return (
            <div className="LanguagesApp">
                <BrowserRouter>
                    <Routes>
                        <Route path="/" element={<LoginComponentWithNavigation />} />
                        <Route path="/login" element={<LoginComponentWithNavigation />} />
                        <Route path="/welcome" element={<WelcomeComponent />} />
                        <Route path="/languages" element={<LanguagesComponent />} />
                    </Routes>
                </BrowserRouter>
            </div>
        )
    }
}

export default LanguagesApp; 
export { LoginComponent }