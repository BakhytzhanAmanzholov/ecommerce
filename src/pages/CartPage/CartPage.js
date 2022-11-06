import './CartPage.css'
import {useSelector} from "react-redux";
import {useLocalStorage} from "../../components/useLocalStorage/useLocalStorage";
import {Product} from "../../UI/Product/Product";
import {Products} from "../../UI/Products/Products";
import {Button} from "../../UI/Button/Button";
import {NavLink} from "react-router-dom";
import axios from "axios";

export const CartPage = () => {
    const {user, token} = useSelector(state => state.auth)

    const [cart, setCart] = useLocalStorage('cart', [])

    const handleDeleteFromCart = (id) => {
        setCart(prev => prev.filter(el => el.id !== id))
    }

    const handleBuyClick = () => {
        const temp = []
        for (let prod of Object.values(cart)) {
            for (let num = 0; num < prod.number; num++) {
                temp.push(prod.selectedSeller)
            }
        }

        axios.post('https://hackathon-2022-app.herokuapp.com/api/users/buy', {ids: temp}, {
            headers: {
                'Authorization': `Bearer ${token.accessToken}`
            }
        })
            .then(res => {
                setCart([])
            })
    }

    return (
        <div className="cartPage" id="cartPage">
            <div className="container">
                <div className="cartPageTitle">
                    <h1>Cart of {user?.name}</h1>
                </div>
                <section className="cartList">
                    {
                        cart?.length > 0 ? <Products>
                            {
                                cart?.map(product => (
                                    <Product
                                        key={product.id}
                                        id={product.id}
                                        title={product.title}
                                        number={product.number}
                                        el={product}
                                        onClick={() => handleDeleteFromCart(product.id)}
                                    />
                                ))
                            }
                        </Products> : <h1>You have no <NavLink to={'/products'}>products</NavLink> in cart yet!</h1>
                    }
                </section>
                <section className="cartBtns">
                    {cart?.length > 0 && <Button
                        onClick={handleBuyClick}
                    >
                        Buy
                    </Button>}
                </section>
            </div>
        </div>
    )
}