import {StrictMode} from 'react'
import {createRoot} from 'react-dom/client'
import './index.css'
import 'react-multi-carousel/lib/styles.css'
import {RouterProvider, createBrowserRouter} from "react-router-dom";
import ProductListPage from "./pages/ProductListPage/ProductListPage.jsx";
import ShopApplicationWrapper from "./pages/ShopApplicationWrapper.jsx";
import Shop from "./Shop.jsx";
import ProductDetails from "./pages/ProductDetailPage/ProductDetails.jsx";
import {loadProductById} from "./routes/product.jsx";

const router = createBrowserRouter([
    {
        path: "/",
        element: <ShopApplicationWrapper/>,

        children: [
            {
                path: "/",
                element: <Shop/>
            },
            {
                path: "/women",
                element: <ProductListPage categoryType={'WOMEN'}/>,
            },
            {
                path: "/men",
                element: <ProductListPage categoryType={'MEN'}/>,
            },
            {
                path: "/product/:productId",
                loader: loadProductById,
                element: <ProductDetails/>,
            },
        ]
    }
]);

createRoot(document.getElementById('root')).render(
    <StrictMode>
        <RouterProvider router={router}/>
    </StrictMode>,
)
