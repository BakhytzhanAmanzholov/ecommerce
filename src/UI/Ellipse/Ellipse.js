import s from './Ellipse.module.css'

export const Ellipse = ({...props}) => {
    const {
        size = 'md'
    } = props

    return(
        <div className={s.ellipse} data-size={size}></div>
    )
}