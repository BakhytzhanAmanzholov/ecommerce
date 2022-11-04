import s from './Button.module.css'

export const Button = ({children, ...props}) => {
    return(
        <button className={s.button} {...props}>
            {children}
        </button>
    )
}