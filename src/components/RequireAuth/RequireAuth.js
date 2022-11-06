import {useSelector} from "react-redux"
import {Navigate} from "react-router-dom"

export const RequireAuth = ({children}) => {
    const {token} = useSelector(state => state.auth)

    return token?.accessToken ? children : <Navigate to={'/login'}/>
}