import './ErrorPage.css'
import {NavLink} from "react-router-dom";

export const ErrorPage = () => {
    return(
        <div className="errorPage" id="errorPage">
            <div className="container">
                <h1>Error! Please, return to <NavLink to={'/'}>MAIN</NavLink> page.</h1>
            </div>
        </div>
    )
}