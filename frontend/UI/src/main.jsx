import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import Shop from './Shop.jsx'
import 'react-multi-carousel/lib/styles.css'
import { RouterProvider, createBrowserRouter } from "react-router-dom";
import ProductListPage from "./pages/ProductListPage/ProductListPage.jsx";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Shop />,
    },
    {
        path: "/womens",
        element: <ProductListPage />,
    }, // Ruta para 404
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
      <RouterProvider router={router} />
  </StrictMode>,
)
