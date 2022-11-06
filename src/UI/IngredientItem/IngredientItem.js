import s from './IngredientItem.module.css'

import heart from "../../assets/icons/Heart.svg";

import healthyIcon from '../../assets/icons/healthy.svg'
import unhealthyIcon from '../../assets/icons/unhealthy.svg'

export const IngredientItem = ({...props}) => {
    const {
        id,
        name,
        healthy
    } = props

    return(
        <div className={s.ingredientsItem}>
            <p>{name}</p>
            {
                healthy ?
                    <img src={healthyIcon} alt="Ingredient"/> :
                    <img src={unhealthyIcon} alt="Ingredient"/>
            }
        </div>
    )
}