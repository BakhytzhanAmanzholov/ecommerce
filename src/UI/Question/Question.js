import s from './Question.module.css'

export const Question = ({...props}) => {
    const {
        question = 'Question',
        answers = [],
        pagesNumber = 1,
        currentPage = 1,
        ...etc
    } = props

    return(
        <div className={s.question} {...etc}>
            <h1 className={s.questionTitle}>
                {question}
            </h1>
            <p className={s.questionPage}>{currentPage} / {pagesNumber}</p>
            <div className="questionSelects">
                {
                    answers?.map(el => (
                        <div key={el.id} className={s.selection}>
                            {el.answer}
                        </div>
                    ))
                }
            </div>
        </div>
    )
}