import './QuestionsPage.css'
import {Ellipse} from "../../UI/Ellipse/Ellipse";
import axios from "axios";
import {useDispatch, useSelector} from "react-redux";
import {getQuestions} from "../../redux/asyncActions/questionsAsyncActions";
import {useEffect, useState} from "react";
import {Question} from "../../UI/Question/Question";

export const QuestionsPage = () => {
    const dispatch = useDispatch()
    const questions = useSelector(state => state.questions)

    const [pages, setPages] = useState(1)
    const [currentPage, setCurrentPage] = useState(1)

    const handleNextPage = () => setCurrentPage(prevPage => prevPage + 1)
    const handlePrevPage = () => {if (currentPage > 1) setCurrentPage(prevPage => prevPage - 1)}

    useEffect(() => {
        dispatch(getQuestions())
    }, [])

    console.log(questions)


    return(
        <div className="questionsPage" id="questionsPage">
            <div className="container">
                <div className="questionsPageLeft">
                    <h1>Answer several questions</h1>
                    <div className="questions">
                        {
                            questions?.map((question, i) => (
                                <Question
                                    key={question.id}
                                    question={question.question}
                                    answers={question.answers}
                                    pagesNumber={questions?.length}
                                    currentPage={currentPage}
                                    data-shown={i + 1 === currentPage}
                                />
                            ))
                        }
                    </div>
                </div>
                <div className="questionsPageRight">
                    <Ellipse
                        size={'xl'}
                    />
                </div>
            </div>
        </div>
    )
}