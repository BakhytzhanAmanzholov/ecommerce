import s from './Product.module.css'

import activeHeart from '../../assets/icons/ActiveHeart.svg'
import heart from '../../assets/icons/Heart.svg'

import temp from '../../assets/img/productsPage/1667581665159 1.png'
import {NavLink} from "react-router-dom";
import {useLocalStorage} from "../../components/useLocalStorage/useLocalStorage";
import {login} from "../../redux/asyncActions/authAsyncActions";

export const Product = ({...props}) => {
    const {
        id = Math.floor(Math.random() * 10),
        title = 'Product lorem ipsum dolor sit amet',
        product = {},
        number,
        ...etc
    } = props


    const [favorites, setFavorites] = useLocalStorage('favorites', [])

    const handleAddToFavorites = () => {
        if (!favorites.find(el => el.id === product.id)){
            setFavorites(prev => [...prev, product])
        } else {
            setFavorites(prev => prev.filter(el => el.id !== product.id))
        }
    }

    const isFavorite = !!favorites.find(el => el.id === id)


    return(
        <div className={s.product} {...etc}>
            <div className={s.productTop}>
                {
                    isFavorite ?
                        <img src={activeHeart} alt="Favorite" data-favorite={isFavorite} onClick={handleAddToFavorites}/> :
                        <img src={heart} alt="Favorite" data-favorite={isFavorite} onClick={handleAddToFavorites}/>
                }
                <img src={temp} alt="Product"/>
            </div>
            <div className={s.productNumber}>
                <p>{number && number}</p>
            </div>
            <NavLink to={`/product/${id}`} className={s.productBottom}>
                <h3>{title}</h3>
            </NavLink>
        </div>
    )
}