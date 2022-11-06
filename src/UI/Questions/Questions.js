import s from './Questions.module.css'

export const Questions = ({children, ...props}) => {
    const {
        ...etc
    } = props

    return (
        <div className={s.questions}>
            {children}
        </div>
    )
}