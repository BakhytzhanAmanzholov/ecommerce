import './Footer.css'

import {Ellipse} from "../../UI/Ellipse/Ellipse";

export const Footer = () => {
    return(
        <footer className="footer" id="footer">
            <div className="container">
                <Ellipse/>
                <div className="legal">
                    All rights reserved.
                </div>
            </div>
        </footer>
    )
}