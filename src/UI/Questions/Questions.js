import s from './Questions.module.css'
import {Button} from "../Button/Button";
import {useState} from "react";

export const Questions = ({children, ...props}) => {
    const {
        currentPage = 1,
        setCurrentPage,
        pagesNumber = 1,
        handleQuestionsSubmit,
        ...etc
    } = props


    const handleNextPage = () => setCurrentPage(prevPage => prevPage + 1)
    const handlePrevPage = () => {if (currentPage > 1) setCurrentPage(prevPage => prevPage - 1)}


    return (
        <div className={s.questions}>
            {children}
            <div className={s.questionBtns}>
                {currentPage !== 1 && <Button
                    onClick={handlePrevPage}
                >Prev</Button>}
                {currentPage !== pagesNumber && <Button
                    onClick={handleNextPage}
                >Next</Button>}
                {currentPage === pagesNumber && <Button
                    onClick={handleQuestionsSubmit}
                >Save</Button>}
            </div>
        </div>
    )
}