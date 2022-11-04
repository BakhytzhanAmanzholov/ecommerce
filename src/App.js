import './App.css'
import './assets/css/variables.css'
import {NavRoutes} from "./components/NavRoutes/NavRoutes";
import {useLocation} from "react-router-dom";
import {useEffect} from "react";
import {Header} from "./components/Header/Header";
import {Search} from "./UI/Search/Search";

function App() {
    const location = useLocation()

    useEffect(() => {
        if (location.pathname === '/login' || location.pathname === 'registration'){

        }
    }, [])

    return (
        <div className="App">
            {(!location.pathname.includes('/login') && !location.pathname.includes('registration')) && <Header/>}
            <NavRoutes/>
        </div>
    )
}

export default App