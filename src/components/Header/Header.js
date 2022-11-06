import './Header.css'

import {useDispatch, useSelector} from "react-redux";
import {NavLink} from "react-router-dom";
import {Ellipse} from "../../UI/Ellipse/Ellipse";
import heart from '../../assets/icons/Heart.svg'
import cart from '../../assets/icons/icon_cart_.svg'
import consultation from '../../assets/icons/consultation.svg'
import logo from '../../assets/icons/Logo.svg'

export const Header = () => {
    const dispatch = useDispatch()
    const {user, token} = useSelector(state => state.auth)
    
    return(
        <header className="header" id="header">
            <div className="container">
                <div className="headerBrand">
                    <NavLink to={'/'}>
                        <img src={logo} alt="Inner"/>
                    </NavLink>
                </div>
                <div className="headerAccount">
                    {
                        token.accessToken ? <ul className={'account'}>
                            <li><NavLink to={`/user/${user?.id}/consultation-cost`}><img src={consultation} alt="Consultation"/></NavLink></li>
                            <li><NavLink to={`/user/${user?.id}/favorites`}><img src={heart} alt="Favorite"/></NavLink></li>
                            <li><NavLink to={`/user/${user?.id}/cart`}><img src={cart} alt="Cart"/></NavLink></li>
                            <li><NavLink to={`/user/${user?.id || user?.name}`}><Ellipse size={'sm'}/></NavLink></li>
                        </ul> : <ul className={'auth'}>
                            <li><NavLink to={'/login'} className={'login'}>Login</NavLink></li>
                            <li><NavLink to={'/registration'} className={'register'}>Registration</NavLink></li>
                        </ul>
                    }
                </div>
            </div>
        </header>
    )
}