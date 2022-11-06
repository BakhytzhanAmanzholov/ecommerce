import axios from "axios"
import {setData, setInitial, setLoadingFalse, setLoadingTrue} from "../axiosReducer";
import {setQuestions} from "../questionsReducer";

export const getQuestions = payload =>
    dispatch => {
        dispatch(setLoadingTrue())
        return axios.get('https://hackathon-2022-app.herokuapp.com/api/survey')
            .then(res => {
                if (res.status !== 200 && res.status !== 201) return dispatch(setData({
                    status: res.status,
                    message: res.data.message,
                    loading: false
                }))
                dispatch(setData({
                    status: res.status,
                    message: res.data.message,
                    loading: false
                }))
                dispatch(setQuestions(res.data))
            })
            .catch(e => {
                dispatch(setData({status: e.status, message: e.message, loading: false}))
                throw e
            })
    }