import axios from "axios"
import {setCredentialsAction} from "../authReducer"
import {changeRegisterData} from "../registerReducer";
import {changeLoginData} from "../loginReducer";
import {changeTestData} from "../testReducer";
import {changeTests} from "../testsReducer";

export const getTests = () =>
    dispatch => {
        dispatch(changeTests({loading: true}))
        return axios.get('http://localhost:5000/api/tests')
            .then(res => {
                if (res.status !== 200 && res.status !== 201) return
                dispatch(changeTests({
                    tests: res.data.tests,
                    success: true,
                    loading: false,
                    message: res.statusText
                }))
            })
            .catch(e => {
                dispatch(changeTests({success: false, loading: false, message: e.message}))
                throw e
            })
    }


export const createTest = payload =>
    dispatch => {
        dispatch(changeTests({loading: true}))
        return axios.post(`http://localhost:5000/api/tests`, { testName: payload.testName, test: JSON.stringify(payload.test) })
            .then(res => {
                if (res.status !== 200 && res.status !== 201) return res.data.message

                dispatch(changeTests({
                    loading: false,
                    success: true,
                    message: res.statusText
                }))
            })
            .catch(e => {
                dispatch(changeTests({success: false, loading: false, message: e.message}))
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