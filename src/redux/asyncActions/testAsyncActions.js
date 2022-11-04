import axios from "axios"
import {changeTestData} from "../testReducer"

export const getTest = payload =>
    dispatch => {
        dispatch(changeTestData({loading: true}))
        return axios.get(`http://localhost:5000/api/tests/${payload.testId}`, {
            signal: payload.controller.signal
        })
            .then(res => {
                if (res.status !== 200 && res.status !== 201) return

                const {
                    testName,
                    questions
                } = res.data.test

                dispatch(changeTestData({
                    test: {
                        testName,
                        questions: questions.map(el => ({
                            id: el._id,
                            question: el.question,
                            selections: el?.selections?.map(el => ({
                                id: el._id,
                                label: el.label
                            })),
                            correctAnswer: el.correctAnswer
                        }))
                    },
                    success: true,
                    loading: false,
                    message: res.statusText
                }))
            })
            .catch(e => {
                dispatch(changeTestData({success: false, loading: false, message: e.message}))
                throw e
            })
    }




    /*
    test: {
        testName: testName,
        questions: questions.map(el => ({
            id: el.id,
            question: el.question,
            selections: el?.selections.map(el => ({
                id: el.id,
                label: el.label
            })),
            correctAnswer: el.correctAnswer
        }))
    },
    success: true,
    loading: false,
    message: res.statusText
     */