import s from './Question.module.css'
import {Input} from "../Input/Input";
import axios from "axios";

export const Question = ({...props}) => {
    const {
        id,
        question = 'Question',
        answers = [],
        pagesNumber = 1,
        currentPage = 1,
        setUserAnswers,
        ...etc
    } = props

    const handleSelect = (e, questionId, id) => {
        setUserAnswers(prev => ({...prev, [questionId]: id}))
    }

    return(
        <div className={s.question} {...etc} key={id}>
            <h1 className={s.questionTitle}>
                {question}
            </h1>
            <p className={s.questionPage}>{currentPage} / {pagesNumber}</p>
            <div className={s.questionSelects}>
                {
                    answers?.map((el, i) => (
                        <div
                            key={el.id}
                        >
                            <input
                                id={el.id}
                                type={'radio'}
                                className={s.selection}
                                onChange={e => handleSelect(e, id, el.id)}
                                name={answers + id}
                            />
                            <label htmlFor={el.id}>{el?.answer}</label>
                        </div>
                    ))
                }
            </div>
        </div>
    )
}


{/*{el.answer}*/}
{/*</Input>*/}