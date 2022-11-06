import {Route, Routes} from "react-router-dom"
import {RequireAuth} from "../RequireAuth/RequireAuth"
import {HomePage} from "../../pages/HomePage/HomePage";
import {SignupPage} from "../../pages/SignupPage/SignupPage";
import {SigninPage} from "../../pages/SigninPage/SigninPage";
import {ErrorPage} from "../ErrorPage/ErrorPage";
import {UserPage} from "../../pages/UserPage/UserPage";
import {ProductsPage} from "../../pages/ProductsPage/ProductsPage";
import {ProductPage} from "../../pages/ProductPage/ProductPage";
import {QuestionsPage} from "../../pages/QuestionsPage/QuestionsPage";
import {CartPage} from "../../pages/CartPage/CartPage";
import {FavoritesPage} from "../../pages/FavoritesPage/FavoritesPage";
import {ConsultationPage} from "../../pages/ConsultationPage/ConsultationPage";
import {ConsultationCostPage} from "../../pages/ConsultationCostPage/ConsultationCostPage";
import {SelectedConsultantPage} from "../../pages/SelectedConsultantPage/SelectedConsultantPage";

export const NavRoutes = () => {
    return (
        <Routes>
            <Route path={'/'} element={
                <RequireAuth>
                    <HomePage/>
                </RequireAuth>
            }/>
            <Route path={'/registration'} element={<SignupPage/>}/>
            <Route path={'/login'} element={<SigninPage/>}/>
            <Route path={'/user/:id'} element={
                <RequireAuth>
                    <UserPage/>
                </RequireAuth>
            }/>
            <Route path={'/products'} element={
                <RequireAuth>
                    <ProductsPage/>
                </RequireAuth>
            }/>
            <Route path={'/product/:id'} element={
                <RequireAuth>
                    <ProductPage/>
                </RequireAuth>
            }/>
            <Route path={'/questions'} element={
                <RequireAuth>
                    <QuestionsPage/>
                </RequireAuth>
            }/>
            <Route path={'/user/:id/cart'} element={
                <RequireAuth>
                    <CartPage/>
                </RequireAuth>
            }/>
            <Route path={'/user/:id/favorites'} element={
                <RequireAuth>
                    <FavoritesPage/>
                </RequireAuth>
            }/>
            <Route path={'/user/:id/consultation'} element={
                <RequireAuth>
                    <ConsultationPage/>
                </RequireAuth>
            }/>
            <Route path={'/user/:id/consultation/:consultandId'} element={
                <RequireAuth>
                    <SelectedConsultantPage/>
                </RequireAuth>
            }/>
            <Route path={'/user/:id/consultation-cost'} element={
                <RequireAuth>
                    <ConsultationCostPage/>
                </RequireAuth>
            }/>
            <Route path={'/*'} element={<ErrorPage/>}/>
        </Routes>
    )
}