import React, {Component} from 'react'
import {Link} from 'react-router-dom'

class HeaderComponent extends Component {
    render() {
        return(
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div><a href="https://oregonstate.edu/" className="navbar-brand" target="_blank">Oregon State</a></div>
                    <ul class="navbar-nav">
                        <li>
                            <Link className="nav-link" to="/languages">Languages</Link>
                        </li>
                    </ul>
                    <ul class="navbar-nav navbar-collapse justify-content-end">
                        <li>
                            <Link className="nav-link" to="/">Login</Link>
                        </li>
                    </ul>
                </nav>
            </header>
    )}
}

export default HeaderComponent