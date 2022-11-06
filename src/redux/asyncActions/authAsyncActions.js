import axios from "axios"
import {setCredentialsAction} from "../authReducer"
import {changeRegisterData} from "../registerReducer";
import {changeLoginData} from "../loginReducer";
import {setData, setInitial, setLoadingFalse, setLoadingTrue} from "../axiosReducer";

export const register = payload =>
    dispatch => {
        dispatch(setLoadingTrue())
        return axios.post('https://hackathon-2022-app.herokuapp.com/api/registration', {
            name: payload.name,
            surname: payload.surname,
            email: payload.email,
            password: payload.password
        })
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
                setTimeout(() => {
                    dispatch(setInitial())
                }, 5000)
            })
            .catch(e => {
                dispatch(setData({status: e.status, message: e.message, loading: false}))
                throw e
            })
    }

export const login = payload =>
    dispatch => {
        dispatch(setLoadingTrue())
        axios.post('https://hackathon-2022-app.herokuapp.com/api/auth/token', new URLSearchParams({
            email: payload.email,
            password: payload.password
        }), {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        })
            .then(res => {
                console.log(res)

                if (res.status !== 200) return dispatch(setData({
                    status: res.status,
                    message: res.data.message,
                    loading: false
                }))

                const data = {
                    user: {
                        id: res.data.account.id,
                        name: res.data.account.name,
                        surname: res.data.account.surname,
                        email: payload.email
                    },
                    token: {
                        accessToken: res.data.token.accessToken,
                        refreshToken: res.data.token.refreshToken
                    }
                }
                dispatch(setCredentialsAction(data))
                dispatch(setLoadingFalse())
            })
            .catch(e => {
                dispatch(setData({status: e.status, loading: false, message: e.message}))
                throw e
            })
    }