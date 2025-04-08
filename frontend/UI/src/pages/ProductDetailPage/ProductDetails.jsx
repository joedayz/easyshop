import React from 'react'
import {useLoaderData} from "react-router-dom";

const ProductDetails = () => {

    const { product } = useLoaderData();
    //const [image, setImage] = useState(product?.images[0]?.startsWith('http') ? product?.image[0] : product?.thumbnail);

    return (
        <div>ProductDetails { product?.title }</div>
    )
}

export default ProductDetails;