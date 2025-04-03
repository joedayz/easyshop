import React, {useMemo} from 'react'
import FilterIcon from "../../components/common/FiterIcon.jsx";
import content from '../../data/content.json'
import Categories from "../../components/Filters/Categories.jsx";
import PriceFilter from "../../components/Filters/PriceFilter.jsx";
import ColorsFilter from "../../components/Filters/ColorsFilter.jsx";
import SizeFilter from "../../components/Filters/SizeFilter.jsx";
import ProductCard from "./ProductCard.jsx";

const categories = content?.categories;

const ProductListPage = ({categoryType}) => {

    const categoryContent = useMemo(()=>{
        return categories?.find(category => category.code === categoryType);
    },[categoryType]);

    const productListItems = useMemo(()=>{
        return content?.products?.filter((product)=> product?.category_id === categoryContent?.id );
    },[categoryContent]);


    return (
        <div>
            <div className='flex'>
                <div className='w-[20%] p-[20px] border rounded-lg m-[20px]'>
                    { /* Filters */}
                    <div className='flex justify-between'>
                        <p className='text-lg text-gray-600'>Filter</p>
                        <FilterIcon/>
                    </div>
                    <div>
                        { /* Product types */}
                        <p className='text-[16px] text-black'>Categories</p>
                        <Categories types={categoryContent?.types}/>
                        <hr></hr>
                    </div>
                    <div>
                        { /* Price */}
                        <PriceFilter/>
                        <hr></hr>
                        { /* Colors */}
                        <ColorsFilter colors={categoryContent?.meta_data?.colors}/>
                        { /* Sizes */}
                        <SizeFilter sizes={categoryContent?.meta_data?.sizes}/>
                    </div>
                </div>

                <div className='p-[15px]'>
                    <p className='text-black'>{categoryContent?.description}</p>
                    {/* Products */}
                    <div className='pt-4 grid grid-cols-1 lg:grid-cols-3 md:grid-cols-2 gap-8 px-2'>
                        {productListItems?.map((item,index)=>(
                            <ProductCard key={item?.id+"_"+index} {...item} title={item?.name}/>
                        ))}
                    </div>

                </div>

            </div>
        </div>
    )
}

export default ProductListPage