import s from './Seller.module.css'
import {Button} from "../Button/Button";

export const Seller = () => {
    const sellerName = 'name'
    const cost = 1231

    const city = 'Atyrau'
const date = '9 November'
    return(
        <div className={s.seller}>
            <div className={s.sellerLeft}>
                <h3>{sellerName}</h3>
                <p>otzivy</p>
                <p>{cost}</p>
            </div>
            <div className={s.sellerRight}>
                <p>{city}</p>
                <p>{date}</p>
                <Button>
                    Select
                </Button>
            </div>
        </div>
    )
}