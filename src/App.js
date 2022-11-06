import './App.css'
import './assets/css/variables.css'
import {NavRoutes} from "./components/NavRoutes/NavRoutes";
import {useLocation} from "react-router-dom";
import {useEffect} from "react";
import {Header} from "./components/Header/Header";
import {Search} from "./UI/Search/Search";
import {Footer} from "./components/Footer/Footer";

function App() {
    const location = useLocation()

    return (
        <div className="App">
            {(!location.pathname.includes('login') && !location.pathname.includes('registration')) && <Header/>}
            <NavRoutes/>
            {(!location.pathname.includes('login') && !location.pathname.includes('registration') && location.pathname.localeCompare('/') !== 0) && <Footer/>}
        </div>
    )
}

export default App