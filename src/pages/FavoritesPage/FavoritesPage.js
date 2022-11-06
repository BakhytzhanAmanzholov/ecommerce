import './FavoritesPage.css'
import {useSelector} from "react-redux";
import {useLocalStorage} from "../../components/useLocalStorage/useLocalStorage";
import {Products} from "../../UI/Products/Products";
import {Product} from "../../UI/Product/Product";
import {Button} from "../../UI/Button/Button";
import {NavLink} from "react-router-dom";

export const FavoritesPage = () => {
    const {user, token} = useSelector(state => state.auth)

    const [favorites, setFavorites] = useLocalStorage('favorites', [])

    const handleDeleteFromFavorites = (id) => {
        setFavorites(prev => prev.filter(el => el.id !== id))
    }

    return (
        <div className="favoritesPage" id="favoritesPage">
            <div className="container">
                <div className="favoritesPageTitle">
                    <h1>Favorites of {user?.name}</h1>
                </div>
                <section className="favoritesList">
                    {
                        favorites.length > 0 ? <Products>
                            {
                                favorites?.map(product => (
                                    <Product
                                        key={product.id}
                                        id={product.id}
                                        title={product.title}
                                        el={product}
                                    />
                                ))
                            }
                        </Products> : <h1>You have no favorite <NavLink to={'/products'}>products</NavLink> yet!</h1>
                    }

                </section>
            </div>
        </div>
    )
}