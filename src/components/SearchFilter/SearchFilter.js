import './SearchFilter.css'

import {Button} from "../../UI/Button/Button";

export const SearchFilter = () => {
    const handleSearchFilter = () => {

    }

    return(
        <section className={'searchFilter'}>
            <div className="costFilter">
                cost filter
            </div>
            <div className="searchFilterBtn">
                <Button onClick={handleSearchFilter}>
                    Search
                </Button>
            </div>
        </section>
    )
}