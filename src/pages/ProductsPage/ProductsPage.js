import './ProductsPage.css'
import {Ellipse} from "../../UI/Ellipse/Ellipse";
import {Button} from "../../UI/Button/Button";
import {useDispatch, useSelector} from "react-redux";
import axios from "axios";
import {Product} from "../../UI/Product/Product";
import {Products} from "../../UI/Products/Products";
import {SearchFilter} from "../../components/SearchFilter/SearchFilter";
import {useEffect} from "react";
import {getProducts} from "../../redux/asyncActions/productsAsyncActions";

export const ProductsPage = () => {
    const dispatch = useDispatch()
    const {token} = useSelector(state => state.auth)
    const products = useSelector(state => state.products)

    useEffect(() => {
        dispatch(getProducts())
    }, [])

    return (
        <div className="productsPage" id="productsPage">
            <div className="container">
                <h1>Products</h1>
                <Ellipse
                    data-color={'purple'}
                    data-blur={'md'}
                />
                <SearchFilter/>
                <Products>
                    {
                        products?.map(product => (
                            <Product
                                key={product.id}
                                id={product.id}
                                title={product.title}
                                el={product}
                            />
                        ))
                    }
                </Products>
            </div>
        </div>
    )
}