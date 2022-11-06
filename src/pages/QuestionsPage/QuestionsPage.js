import './QuestionsPage.css'
import {Ellipse} from "../../UI/Ellipse/Ellipse";
import axios from "axios";
import {useDispatch, useSelector} from "react-redux";
import {getQuestions} from "../../redux/asyncActions/questionsAsyncActions";
import {useEffect, useState} from "react";
import {Question} from "../../UI/Question/Question";
import {Questions} from "../../UI/Questions/Questions";
import {useNavigate} from "react-router-dom";

export const QuestionsPage = () => {
    const dispatch = useDispatch()
    const {token} = useSelector(state => state.auth)
    const questions = useSelector(state => state.questions)
    const navigate = useNavigate()

    const [currentPage, setCurrentPage] = useState(1)

    const [userAnswers, setUserAnswers] = useState({})
    const handleQuestionsSubmit = () => {
        axios.post('https://hackathon-2022-app.herokuapp.com/api/survey', {
            ids: Object.values(userAnswers) || []
        }, {
            headers: {
                'Authorization': `Bearer ${token.accessToken}`
            }
        })
            .then(res => {
                if (res.status === 200 || res.status === 201){
                    navigate('/')
                }
            })
    }

    useEffect(() => {
        dispatch(getQuestions())
    }, [])


    return (
        <div className="questionsPage" id="questionsPage">
            <div className="container">
                <div className="questionsPageLeft">
                    <h1>Answer several questions</h1>
                    <Questions
                        currentPage={currentPage}
                        setCurrentPage={setCurrentPage}
                        pagesNumber={questions?.length}
                        handleQuestionsSubmit={handleQuestionsSubmit}
                    >
                        {
                            questions?.map((question, i) => (
                                <Question
                                    key={question.id}
                                    id={question.id}
                                    question={question.question}
                                    answers={question.answers}
                                    pagesNumber={questions?.length}
                                    currentPage={currentPage}
                                    data-shown={i + 1 === currentPage}
                                    setUserAnswers={setUserAnswers}
                                />
                            ))
                        }
                    </Questions>
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