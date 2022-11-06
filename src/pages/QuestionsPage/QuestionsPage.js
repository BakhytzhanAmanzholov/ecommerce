import './QuestionsPage.css'
import {Ellipse} from "../../UI/Ellipse/Ellipse";

export const QuestionsPage = () => {
    return(
        <div className="questionsPage" id="questionsPage">
            <div className="container">
                <div className="questionsPageLeft">
                    <h1>Ask several questions</h1>

                </div>
                <div className="questionsPageRight">
                    <Ellipse
                        size={'xl'}
                    />
                </div>
            </div>
        </div>
    )
}