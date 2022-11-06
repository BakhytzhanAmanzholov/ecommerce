import './HomePage.css'
import {Search} from "../../UI/Search/Search";

import searchGirl from '../../assets/img/homePage/Girl.png'

// import INNR from '../../assets/img/homePage/brands/INNR.png'
import Babor from '../../assets/img/homePage/brands/Babor.png'
import EsteeLauder from '../../assets/img/homePage/brands/ESTEELAUDER.png'
import Givenchy from '../../assets/img/homePage/brands/Givenchy.png'
import Lancome from '../../assets/img/homePage/brands/lancome.png'
import Zielenski from '../../assets/img/homePage/brands/zielenski.png'
import {NavLink} from "react-router-dom";

const brands = [
    {
        name: 'Zielenski',
        src: Zielenski
    }, {
        name: 'EsteeLauder',
        src: EsteeLauder
    }, {
        name: 'Babor',
        src: Babor
    }, {
        name: 'Givenchy',
        src: Givenchy
    }, {
        name: 'Lancome',
        src: Lancome
    }
]


export const HomePage = () => {
    return (
        <main className="homePage" id="homePage">
            <section className={'searchBanner'}>
                <div className="container">
                    <Search/>
                    <NavLink to={'/products'}>
                        <img src={searchGirl} alt="Search Girl"/>
                    </NavLink>
                </div>
            </section>
            <section className={'brands'}>
                <div className="container">
                    {
                        brands?.map(brand => (
                            <img key={brand.name} src={brand.src} alt={brand.name}/>
                        ))
                    }
                </div>
            </section>
        </main>
    )
}