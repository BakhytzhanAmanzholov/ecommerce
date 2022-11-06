import './ProductPage.css'
import {NavLink, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {useDispatch, useSelector} from "react-redux";

import heart from '../../assets/icons/Heart.svg'
import temp from '../../assets/img/productsPage/1667581665159 1.png'
import minus from '../../assets/img/productsPage/minus.png'
import plus from '../../assets/img/productsPage/plus.png'
import {Button} from "../../UI/Button/Button";
import {IngredientItem} from "../../UI/IngredientItem/IngredientItem";
import {Seller} from "../../UI/Seller/Seller";
import {Sellers} from "../../UI/Sellers/Sellers";
import {Product} from "../../UI/Product/Product";
import axios from "axios";
import {getProducts} from "../../redux/asyncActions/productsAsyncActions";
import {setProducts} from "../../redux/productsReducer";


export const ProductPage = () => {
    const dispatch = useDispatch()
    const products = useSelector(state => state.products)


    const {id} = useParams()
    const [product, setProduct] = useState({})
    const [counter, setCounter] = useState(1)
    // const []

    const handlePlusCounter = () => setCounter(prevCounter => prevCounter + 1)
    const handleMinusCounter = () => {
        if (counter > 1) setCounter(prevCounter => +prevCounter - 1)
    }

    useEffect(() => {
        dispatch(getProducts())
    }, [])

    useEffect(() => {
        if (products.length > 0) {
            setProduct(products.find(el => +el.id === +id))
        }
    }, [products])

    return (
        <div className={'productPage'}>
            <div className="container">
                <div className="productHead">
                    <div className="productHeadLeft">
                        <img src={temp} alt="Product"/>
                    </div>
                    <div className="productHeadRight">
                        <h1>{product?.title}</h1>
                        <h1><a href={'#productsIngredients'}>Specifications</a></h1>
                        <h1>{product?.subCategory}</h1>
                        <h1>{'35 000'}</h1>
                        <div className="productBuyCounter">
                            <div className="minusCounter">
                                <img src={minus} alt="Minus product" onClick={handleMinusCounter}/>
                            </div>
                            <div className="counter">
                                {counter}
                            </div>
                            <div className="plusCounter">
                                <img src={plus} alt="Plus product" onClick={handlePlusCounter}/>
                            </div>
                        </div>
                        <div className="productBtns">
                            <Button>Add to cart</Button>
                            <Button
                                // data-outline={true}
                            ><img src={heart} alt="Favorite"/></Button>
                        </div>
                    </div>
                </div>
                <div className="ingredientsContainer">
                    <h1>Ingredients</h1>
                    <div className="productsIngredients" id={'productsIngredients'}>
                        <div className="ingredientsLeft">
                            {
                                product?.ingredients?.map((el, i) => (
                                    i < product?.ingredients?.length / 2 && <IngredientItem
                                        key={el.id}
                                        id={el.id}
                                        name={el.name}
                                        healthy={el.healthy}
                                    />
                                ))
                            }
                        </div>
                        <div className="ingredientsRight">
                            {
                                product?.ingredients?.map((el, i) => (
                                    i >= product?.ingredients?.length / 2 && <IngredientItem
                                        key={el.id}
                                        id={el.id}
                                        name={el.name}
                                        healthy={el.healthy}
                                    />
                                ))
                            }
                        </div>
                    </div>
                </div>
                <div className="sellersContainer">
                    <h1>Sellers</h1>
                    <Sellers>
                        {
                            [1, 2, 3, 4, 5].map(seller => (
                                <Seller key={seller}/>
                            ))
                        }
                    </Sellers>
                </div>
                <div className="similarProducts">
                    <h1>Similar products</h1>
                    <div className="products">
                        {
                            [1, 2, 3, 4].map(el => (
                                <Product/>
                            ))
                        }
                    </div>
                </div>
                <div className="anotherBuys">
                    <h1>Another Customers Buy</h1>
                    <div className="products">
                        {
                            [1, 2, 3, 4].map(el => (
                                <Product/>
                            ))
                        }
                    </div>
                </div>
            </div>
        </div>
    )
}