import s from './Input.module.css'
import {useId} from "react"

export const Input = ({...props}) => {
    const generateId = useId()

    const {
        label = '',
        placeholder = '',
        id = generateId,
        type = 'text',
        className = '',
        reverseElements = false,
        ...etc
    } = props.props

    return(
        <div className={s.inputContainer}>
            {(label && !reverseElements) && <label htmlFor={id}>{label}</label>}
            <input className={className && className} id={id} type={type} placeholder={placeholder ? placeholder : (label ? label : '')} {...etc}/>
            {(label && reverseElements) && <label htmlFor={id}>{label}</label>}
        </div>
    )
}