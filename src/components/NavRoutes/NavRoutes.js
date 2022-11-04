import {Route, Routes} from "react-router-dom"
import {RequireAuth} from "../RequireAuth/RequireAuth"
import {HomePage} from "../../pages/HomePage/HomePage";
import {SignupPage} from "../../pages/SignupPage/SignupPage";
import {SigninPage} from "../../pages/SigninPage/SigninPage";

export const NavRoutes = () => {
    return (
        <Routes>
            <Route path={'/'} element={
                // <RequireAuth>
                    <HomePage/>
                // </RequireAuth>
            }/>
            <Route path={'/registration'} element={<SignupPage/>}/>
            <Route path={'/login'} element={<SigninPage/>}/>
        </Routes>
    )
}