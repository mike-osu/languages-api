import React, {Component, useState} from 'react'
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom'
import withNavigation from './WithNavigation';
import Languages from './languages'
import AuthenticationService from './AuthenticationService.js';
import HeaderComponent from './Header'
import './style.css'

class WelcomeComponent extends Component {
    render() {
        return <div class="center">
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

        sessionStorage.clear()
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]:event.target.value
            }
        )
    }

    async loginClicked() {
        if (this.state.username !== '' && this.state.password !== '') {
            await AuthenticationService.login(this.state.username, this.state.password).then(() => {
                if (sessionStorage.getItem('token') !== null)
                    this.props.navigate('/welcome')
            })
        }
    }

    render () {
        return (
            <div class="center">
                <table cellPadding="2">
                    <tr>
                        <td><b>Username:</b></td>
                        <td><input type="text" name="username" value={this.state.username} onChange={this.handleChange} /></td>
                    </tr>
                    <tr>
                        <td><b>Password:</b></td>
                        <td><input type="password" name="password" value={this.state.password} onChange={this.handleChange} /></td>
                    </tr>  
                    <tr>
                        <td align='center' colSpan="2"><button onClick={this.loginClicked}>Login</button></td>
                    </tr>                  
                </table>
            </div>
        )
    }
}

class LanguagesComponent extends Component {
    state = {
        languages: []
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/v1/languages', {
            method: 'GET',
            mode: 'cors',
            headers: {
                Authorization: "Bearer " + sessionStorage.getItem('token')
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
                    <HeaderComponent />
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