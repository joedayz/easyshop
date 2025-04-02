import './Shop.css'
import Navigation from "./components/Navigation/Navigation.jsx";
import HeroSection from "./components/HeroSection/HeroSection.jsx";
import NewArrivals from "./components/Sections/NewArrivals.jsx";

function Shop() {


    return (
        <div className="App">
            <Navigation/>
            <HeroSection/>
            <NewArrivals/>
        </div>
    )
}

export default Shop
