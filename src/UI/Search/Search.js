import s from './Search.module.css'

import {Button} from "../Button/Button";
import searchIcon from '../../assets/icons/Search.svg'
import {useDispatch, useSelector} from "react-redux";
import {useEffect, useState} from "react";
import {getProducts} from "../../redux/asyncActions/productsAsyncActions";
import {useNavigate} from "react-router-dom";

export const Search = ({...props}) => {
    const dispatch = useDispatch()
    const products = useSelector(state => state.products)
    const navigate = useNavigate()

    const [search, setSearch] = useState('')

    useEffect(() => {
        dispatch(getProducts())
    }, [])

    const {
        type = 'text',
        placeholder = 'I want...',
        ...etc
    } = props

    const handleSearch = () => {
        const product = products.find(el => el.title.includes(search))
        navigate(`/product/${product?.id}`)
    }

    const handleInputChange = e => {
        setSearch(e.target.value)
    }

    return (
        <div className={s.searchContainer}>
            <input
                type={type}
                placeholder={placeholder}
                autoComplete={'off'}
                list={'suggestions'}
                onChange={handleInputChange}
                {...etc}
            />
            <button
                onClick={handleSearch}
            ><img src={searchIcon} alt="search"/></button>
            <datalist id={'suggestions'}>
                {
                    products?.map(product => (
                        <option key={product.id} value={product.title}>{product.title}</option>
                    ))
                }
            </datalist>
        </div>
    )
}