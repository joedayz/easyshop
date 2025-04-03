import './Shop.css'
import Navigation from "./components/Navigation/Navigation.jsx";
import HeroSection from "./components/HeroSection/HeroSection.jsx";
import NewArrivals from "./components/Sections/NewArrivals.jsx";
import Category from "./components/Sections/Categories/Category.jsx";
import content from "./data/content.json"


function Shop() {


    return (
        <div className="App">
            <Navigation/>
            <HeroSection/>
            <NewArrivals/>
            {content?.categories && content?.categories?.map((item, index) => <Category key={item?.title+index} {...item}/>)}
        </div>
    )
}

export default Shop
