import s from './Product.module.css'

import heart from '../../assets/icons/Heart.svg'

import temp from '../../assets/img/productsPage/1667581665159 1.png'
import {NavLink} from "react-router-dom";

export const Product = ({...props}) => {
    const {
        id = Math.floor(Math.random() * 10),
        title = 'Product lorem ipsum dolor sit amet',
        isFavorite = false,
        ...etc
    } = props

    return(
        <div className={s.product}>
            <div className={s.productTop}>
                <img src={heart} alt="Favorite" data-favorite={isFavorite}/>
                <img src={temp} alt="Product"/>
            </div>
            <NavLink to={`/product/${id}`} className={s.productBottom}>
                <h3>{title}</h3>
            </NavLink>
        </div>
    )
}