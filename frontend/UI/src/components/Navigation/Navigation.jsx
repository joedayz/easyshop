import React from 'react'

const Navigation = () => {
    return (
        <nav className='flex items-center py-6 px-16 justify-between gap-40'>
            <div className='flex item-center gap-6'>
                {/* Logo */}
                <a className='text-3xl text-black font-bold gap-8' href="/">EasyShop</a>
            </div>
            <div className='flex flex-wrap items-center gap-8 flex-1'>
                {/* Nav items */}
                <ul className='flex gap-14 text-gray-600 hover:text-black'>
                    <li><a href="/">Shop</a> </li>
                    <li><a href="/mens">Men</a> </li>
                    <li><a href="/womens">Women</a> </li>
                    <li><a href="/kids">Kids</a> </li>
                </ul>
            </div>
            <div>
                {/* Search bar */}
            </div>

            <div>
                {/* Action items - icons */}
            </div>
        </nav>
    )
}

export default Navigation