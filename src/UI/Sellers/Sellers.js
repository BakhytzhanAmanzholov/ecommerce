import s from './Sellers.module.css'

export const Sellers = ({children, ...props}) => {
    const {

    } = props

    return(
        <div className={s.productSellers}>
            {children}
        </div>
    )
}