import './Header.css'

import {useDispatch, useSelector} from "react-redux";
import {NavLink} from "react-router-dom";

export const Header = () => {
    const dispatch = useDispatch()
    const {user, token} = useSelector(state => state.auth)
    
    return(
        <header className="header" id="header">
            <div className="container">
                <div className="headerBrand">
                    <NavLink to={'/'}>
                        <h1>Brand</h1>
                    </NavLink>
                </div>
                <div className="headerAccount">
                    {
                        token ? <ul>
                            <li>Account</li>
                        </ul> : <ul>
                            <li><NavLink to={'/login'} className={'login'}>Login</NavLink></li>
                            <li><NavLink to={'/registration'} className={'register'}>Registration</NavLink></li>
                        </ul>
                    }
                </div>
            </div>
        </header>
    )
}