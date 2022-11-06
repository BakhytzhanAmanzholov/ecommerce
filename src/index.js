import ReactDOM from 'react-dom/client'
import './index.css'
import App from './App'

import {BrowserRouter} from "react-router-dom"

import {Provider} from 'react-redux'
import {store} from './redux/store'
import ScrollToTop from "./components/ScroollToTop/ScrollToTop";

const root = ReactDOM.createRoot(document.getElementById('root'))
root.render(
    <Provider store={store}>
        <BrowserRouter>
            <ScrollToTop/>
            <App/>
        </BrowserRouter>
    </Provider>
)