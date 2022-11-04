import s from './Form.module.css'

export const Form = ({children, ...props}) => {
    return(
        <form {...props}>
            {children}
        </form>
    )
}