import './Products.css'

export const Products = ({children, ...props}) => {
    const {

    } = props

    return(
        <div className="products" id="products">
            {children}
        </div>
    )
}