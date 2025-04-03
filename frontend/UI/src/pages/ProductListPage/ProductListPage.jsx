import React from 'react'
import Navigation from "../../components/Navigation/Navigation.jsx";
import FilterIcon from "../../components/common/FiterIcon.jsx";

const ProductListPage = () => {
    return (
        <div>
            <Navigation/>
            <div className='flex'>
                <div className='w-[20%] p-[20px] border rounded-lg m-[20px]'>
                    { /* Filters */}
                    <div className='flex justify-between'>
                        <p className='text-lg text-gray-600'>Filter</p>
                        <FilterIcon/>
                    </div>
                    <div>
                        <p className='text-[16px] text-black'>Categories</p>
                    </div>
                </div>

                <div className='p-[40px]'>
                    <p>Hello1</p>
                    { /* Products */}
                </div>

            </div>
        </div>
    )
}

export default ProductListPage