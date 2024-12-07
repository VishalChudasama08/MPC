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
      <div className='col-lg-3 col-md-4 col-sm-5 p-0 px-2' style={{ width: "100vw" }}>
         <div className="card my-2" key={mobile.id}>
            <span className="position-absolute rounded-start text-dark my-2 px-3" style={{ top: '-1px', right: '-1px', zIndex: '1' }}>
               <i className='far fa-trash-alt mx-3'></i>
               <i className='far fa-edit'></i>
            </span>
            <div className="row g-0">
               <div className="col-md-4">
                  <img src={mobile.images.split(", ")[0]} width={200} height={250} alt="" />
               </div>
               <div className="col-md-8">
                  <div className="card-body">
                     <span>{mobile.id}</span>
                     <h5 className='card-title '>{mobile.name}</h5>

                     <p className='card-text'>₹{mobile.price}</p>
                     <p className='card-text'>{mobile.highlights}</p>
                     <p className='card-text'>{mobile.description}</p>
                  </div>
               </div>
            </div>
         </div>
         {/* <div className='card my-2' key={mobile.id}>
            <span className="position-absolute rounded-start text-dark my-2 px-3" style={{ top: '-1px', right: '-1px', zIndex: '1' }}>
               <i className='far fa-trash-alt mx-3'></i>
               <i className='far fa-edit'></i>
            </span>
            <div className='card-body'>
               <span>{mobile.id}</span>
               <h5 className='card-title '>{mobile.name}</h5>

               <img src={mobile.images.split(", ")[0]} width={200} height={250} alt="" />

               <p className='card-text'>₹{mobile.price}</p>
               <p className='card-text'>{mobile.highlights}</p>
               <p className='card-text'>{mobile.description}</p>
            </div>
         </div> */}
      </div>
   )
}

export default ProductDetail