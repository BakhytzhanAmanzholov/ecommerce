import s from './IngredientItem.module.css'

import heart from "../../assets/icons/Heart.svg";

export const IngredientItem = ({...props}) => {
    const {
        id,
        name,
        healthy
    } = props

    return(
        <div className={s.ingredientsItem}>
            <p>{name}</p>
            <img src={heart} alt="Ingredient"/>
        </div>
    )
}