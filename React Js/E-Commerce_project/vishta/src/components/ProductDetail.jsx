import React from 'react'
import { useLocation } from 'react-router-dom';

function ProductDetail() {
   const location = useLocation();
   const queryParams = new URLSearchParams(location.search); // Parse the query string
   const product_id = queryParams.get('id'); // Get the value of 'id'

   let mobile = {
      id: `${product_id}`,
      name: 'realme 12x 5G (Woodland Green, 128 GB)  (8 GB RAM)',
      price: 13499,
      images: "product/images/realme12X.webp, product/images/realme12Xdetails.webp",
      seller: "XONIGHT E-Commerce",
      seller_role: '7 Days Service Center Replacement/Repair, GST invoice available',
      highlights: "8 GB RAM | 128 GB ROM | Expandable Upto 2 TB \n17.07 cm (6.72 inch) Full HD+ Display \n50MP + 2MP | 8MP Front Camera \n5000 mAh Battery \nDimensity 6100+ Processor",
      description: "The Realme 12x 5G is a sleek powerhouse redefining mobile technology. Swift charging meets endurance with 45 W SUPERVOOC Charge and a 5000 mAh battery, ensuring you're always connected. The Dimensity 6100+ 6nm chipset delivers lightning-fast 5G speeds for seamless connectivity wherever you are. Immerse yourself in the 12.07 cm (6.72) 120 Hz FHD+ Display, offering crystal-clear visuals with its ultra-smooth refresh rate. Style meets substance with its ultra-slim 7.69 mm profile and lightweight 188g body. Capture life's moments in stunning detail with the 50 MP AI camera, while the vapour chamber cooling system keeps performance optimal. Elevate your audio experience with dual stereo speakers, delivering Hi-Res Audio certification for immersive sound. The Realme 12x 5G: where innovation meets elegance in the palm of your hand.",
   }

   return (
      <div className='mx-8 my-4'>
         <div key={mobile.id} className="p-1 flex flex-col items-center bg-white border border-gray-200 rounded-lg shadow md:flex-row hover:bg-gray-100 dark:border-gray-700 dark:bg-gray-800 dark:hover:bg-gray-700">
            <img src={mobile.images.split(", ")[0]} className="object-cover w-full rounded-t-lg h-96 md:h-auto md:w-48 md:rounded-none md:rounded-s-lg" alt="" />
            <div className="flex flex-col justify-between p-4 leading-normal">
               <span className='text-white'>{mobile.id}</span>
               <h6 className="mb-2 text-xl font-bold tracking-tight text-gray-900 dark:text-white">{mobile.name}</h6>
               <span className="text-2xl font-bold text-gray-900 dark:text-white">₹{mobile.price}</span>
               <p className="mb-3 font-normal text-gray-700 dark:text-gray-400">{mobile.highlights}</p>
               <p className="mb-3 font-normal text-gray-700 dark:text-gray-400">{mobile.description}</p>
            </div>
         </div>

         {/* <div className="w-full max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
            <a href="#">
               <img src={mobile.images.split(", ")[0]} className="p-8 rounded-t-lg" alt="product image" />
            </a>
            <div className="px-5 pb-5">
               <a href="#">
                  <h5 className="text-xl font-semibold tracking-tight text-gray-900 dark:text-white">{mobile.name}</h5>
               </a>

               // star and rating
               <div className="flex items-center mt-2.5 mb-5">
                  <div className="flex items-center space-x-1 rtl:space-x-reverse">
                     <svg className="w-4 h-4 text-yellow-300" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 20">
                        <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z" />
                     </svg>
                     <svg className="w-4 h-4 text-yellow-300" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 20">
                        <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z" />
                     </svg>
                     <svg className="w-4 h-4 text-yellow-300" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 20">
                        <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z" />
                     </svg>
                     <svg className="w-4 h-4 text-yellow-300" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 20">
                        <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z" />
                     </svg>
                     <svg className="w-4 h-4 text-gray-200 dark:text-gray-600" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 20">
                        <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z" />
                     </svg>
                  </div>
                  <span className="bg-blue-100 text-blue-800 text-xs font-semibold px-2.5 py-0.5 rounded dark:bg-blue-200 dark:text-blue-800 ms-3">5.0</span>
               </div>

               <div className="flex items-center justify-between">
                  <span className="text-3xl font-bold text-gray-900 dark:text-white">₹{mobile.price}</span>
                  <a href="#" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Add to cart</a>
               </div>
            </div>
         </div> */}

      </div>
   )
}

export default ProductDetail