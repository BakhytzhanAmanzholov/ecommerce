import s from './Search.module.css'

import {Button} from "../Button/Button";
import search from '../../assets/icons/Search.svg'

export const Search = ({...props}) => {
    const {
        type = 'text',
        placeholder = 'I want...',
        ...etc
    } = props

    return(
        <div className={s.searchContainer}>
            <input
                type={type}
                placeholder={placeholder}
                autoComplete={'off'}
                list={'suggestions'}
                {...etc}
            />
            <button><img src={search} alt="search"/></button>
            <datalist id={'suggestions'}>
                <option value="One">One choice</option>
                <option value="Two">Two choice</option>
                {/*<option value="Two">Two choice</option>*/}
            </datalist>
        </div>
    )
}