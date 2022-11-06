import s from './Ellipse.module.css'

export const Ellipse = ({...props}) => {
    const {
        size = 'md',
        ...etc
    } = props

    return(
        <div className={s.ellipse} data-size={size} {...etc}/>
    )
}