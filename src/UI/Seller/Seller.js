import s from './Seller.module.css'
import {Button} from "../Button/Button";

export const Seller = ({...props}) => {
    const {
        id,
        seller = 'Seller',
        price = 0,
        delivery,
        ...etc
    } = props

    return(
        <div className={s.seller} {...etc}>
            <div className={s.sellerLeft}>
                <h3>{seller.name}</h3>
                {/*<p>otzivy</p>*/}
                <p>{price}</p>
            </div>
            <div className={s.sellerRight}>
                {/*<p>{city}</p>*/}
                <p>{delivery}</p>
                <Button
                    data-outline={true}
                >
                    Select
                </Button>
            </div>
        </div>
    )
}