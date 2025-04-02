import React from 'react'
import SectionHeading from "./SectionsHeading/SectionHeading.jsx";
import Card from "../Card/Card.jsx";
import Jeans from "../../assets/img/jeans.jpg";
import Shirts from "../../assets/img/shirts.jpg";
import Tshirt from "../../assets/img/tshirts.jpeg";
import dresses from "../../assets/img/dresses.jpg";

const items = [{
    'title': 'Jeans',
    imagePath: Jeans
}, {
    'title': 'Shirts',
    imagePath: Shirts
}, {
    'title': 'T-Shirts',
    imagePath: Tshirt
}, {
    'title': 'Dresses',
    imagePath: dresses
}];

const NewArrivals = () => {
    return (
        <>
            <SectionHeading title={"New Arrivals"}/>
            <div className='flex flex-wrap px-[20px]'>
                {items && items?.map((item,index)=> <Card key={item?.title +index} title={item.title} imagePath={item.imagePath}/>)}
            </div>
        </>
    )
}

export default NewArrivals;