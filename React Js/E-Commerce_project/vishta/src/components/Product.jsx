import React from 'react'
import { useNavigate } from 'react-router-dom';

function Product() {
   const navigate = useNavigate();
   let currantCategory = window.location.pathname.slice(1, window.location.pathname.length);
   let products = {
      electronics: {
         mobilesAccessories: {
            Mobiles: [
               {
                  id: 1,
                  name: 'realme 12x 5G (Woodland Green, 128 GB)  (8 GB RAM)',
                  price: 13499,
                  images: "product/images/realme12X.webp, product/images/realme12Xdetails.webp",
                  seller: "XONIGHT E-Commerce",
                  seller_role: '7 Days Service Center Replacement/Repair, GST invoice available',
                  highlights: "8 GB RAM | 128 GB ROM | Expandable Upto 2 TB \n17.07 cm (6.72 inch) Full HD+ Display \n50MP + 2MP | 8MP Front Camera \n5000 mAh Battery \nDimensity 6100+ Processor",
                  description: "The Realme 12x 5G is a sleek powerhouse redefining mobile technology. Swift charging meets endurance with 45 W SUPERVOOC Charge and a 5000 mAh battery, ensuring you're always connected. The Dimensity 6100+ 6nm chipset delivers lightning-fast 5G speeds for seamless connectivity wherever you are. Immerse yourself in the 12.07 cm (6.72) 120 Hz FHD+ Display, offering crystal-clear visuals with its ultra-smooth refresh rate. Style meets substance with its ultra-slim 7.69 mm profile and lightweight 188g body. Capture life's moments in stunning detail with the 50 MP AI camera, while the vapour chamber cooling system keeps performance optimal. Elevate your audio experience with dual stereo speakers, delivering Hi-Res Audio certification for immersive sound. The Realme 12x 5G: where innovation meets elegance in the palm of your hand.",
               },
               {
                  id: 2,
                  name: 'realme 12x 5G (Woodland Green, 128 GB)  (8 GB RAM)',
                  price: 13499,
                  images: "product/images/realme12X.webp, product/images/realme12Xdetails.webp",
                  seller: "XONIGHT E-Commerce",
                  seller_role: '7 Days Service Center Replacement/Repair, GST invoice available',
                  highlights: "8 GB RAM | 128 GB ROM | Expandable Upto 2 TB \n17.07 cm (6.72 inch) Full HD+ Display \n50MP + 2MP | 8MP Front Camera \n5000 mAh Battery \nDimensity 6100+ Processor",
                  description: "The Realme 12x 5G is a sleek powerhouse redefining mobile technology. Swift charging meets endurance with 45 W SUPERVOOC Charge and a 5000 mAh battery, ensuring you're always connected. The Dimensity 6100+ 6nm chipset delivers lightning-fast 5G speeds for seamless connectivity wherever you are. Immerse yourself in the 12.07 cm (6.72) 120 Hz FHD+ Display, offering crystal-clear visuals with its ultra-smooth refresh rate. Style meets substance with its ultra-slim 7.69 mm profile and lightweight 188g body. Capture life's moments in stunning detail with the 50 MP AI camera, while the vapour chamber cooling system keeps performance optimal. Elevate your audio experience with dual stereo speakers, delivering Hi-Res Audio certification for immersive sound. The Realme 12x 5G: where innovation meets elegance in the palm of your hand.",
               },
               {
                  id: 3,
                  name: 'realme 12x 5G (Woodland Green, 128 GB)  (8 GB RAM)',
                  price: 13499,
                  images: "product/images/realme12X.webp, product/images/realme12Xdetails.webp",
                  seller: "XONIGHT E-Commerce",
                  seller_role: '7 Days Service Center Replacement/Repair, GST invoice available',
                  highlights: "8 GB RAM | 128 GB ROM | Expandable Upto 2 TB \n17.07 cm (6.72 inch) Full HD+ Display \n50MP + 2MP | 8MP Front Camera \n5000 mAh Battery \nDimensity 6100+ Processor",
                  description: "The Realme 12x 5G is a sleek powerhouse redefining mobile technology. Swift charging meets endurance with 45 W SUPERVOOC Charge and a 5000 mAh battery, ensuring you're always connected. The Dimensity 6100+ 6nm chipset delivers lightning-fast 5G speeds for seamless connectivity wherever you are. Immerse yourself in the 12.07 cm (6.72) 120 Hz FHD+ Display, offering crystal-clear visuals with its ultra-smooth refresh rate. Style meets substance with its ultra-slim 7.69 mm profile and lightweight 188g body. Capture life's moments in stunning detail with the 50 MP AI camera, while the vapour chamber cooling system keeps performance optimal. Elevate your audio experience with dual stereo speakers, delivering Hi-Res Audio certification for immersive sound. The Realme 12x 5G: where innovation meets elegance in the palm of your hand.",
               },
               {
                  id: 4,
                  name: 'realme 12x 5G (Woodland Green, 128 GB)  (8 GB RAM)',
                  price: 13499,
                  images: "product/images/realme12X.webp, product/images/realme12Xdetails.webp",
                  seller: "XONIGHT E-Commerce",
                  seller_role: '7 Days Service Center Replacement/Repair, GST invoice available',
                  highlights: "8 GB RAM | 128 GB ROM | Expandable Upto 2 TB \n17.07 cm (6.72 inch) Full HD+ Display \n50MP + 2MP | 8MP Front Camera \n5000 mAh Battery \nDimensity 6100+ Processor",
                  description: "The Realme 12x 5G is a sleek powerhouse redefining mobile technology. Swift charging meets endurance with 45 W SUPERVOOC Charge and a 5000 mAh battery, ensuring you're always connected. The Dimensity 6100+ 6nm chipset delivers lightning-fast 5G speeds for seamless connectivity wherever you are. Immerse yourself in the 12.07 cm (6.72) 120 Hz FHD+ Display, offering crystal-clear visuals with its ultra-smooth refresh rate. Style meets substance with its ultra-slim 7.69 mm profile and lightweight 188g body. Capture life's moments in stunning detail with the 50 MP AI camera, while the vapour chamber cooling system keeps performance optimal. Elevate your audio experience with dual stereo speakers, delivering Hi-Res Audio certification for immersive sound. The Realme 12x 5G: where innovation meets elegance in the palm of your hand.",
               },
            ]
         },
         LaptopsComputers: {
            GamingLaptops: [
               {
                  id: 5,
                  name: "Apple MacBook AIR Apple M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLXW3HN/A  (13.6 Inch, Space Grey, 1.24 Kg)",
                  price: 73990,
                  images: "'Apple_MacBook_m2.webp', 'Apple_MacBook_m2_details.webp'",
                  seller: 'TREASURE HAUL ONLINE',
                  seller_role: "No Returns Applicable \nGST invoice available",
                  highlights: "Stylish & Portable Thin and Light Laptop \n13.6 Inch Liquid Retina Display, LED-backlit display with IPS technology, 500 nits brightness, Wide colour (P3), True Tone technology \nLight Laptop without Optical Disk Drive",
                  description: "You can experience the power of the M2 chip on this redesigned MacBook Air. With a battery back up of up to 18 hours, you can easily get all your work done from anywhere on this easily portable MacBook Air."
               },
               {
                  id: 6,
                  name: "Apple MacBook AIR Apple M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLXW3HN/A  (13.6 Inch, Space Grey, 1.24 Kg)",
                  price: 73990,
                  images: "'Apple_MacBook_m2.webp', 'Apple_MacBook_m2_details.webp'",
                  seller: 'TREASURE HAUL ONLINE',
                  seller_role: "No Returns Applicable \nGST invoice available",
                  highlights: "Stylish & Portable Thin and Light Laptop \n13.6 Inch Liquid Retina Display, LED-backlit display with IPS technology, 500 nits brightness, Wide colour (P3), True Tone technology \nLight Laptop without Optical Disk Drive",
                  description: "You can experience the power of the M2 chip on this redesigned MacBook Air. With a battery back up of up to 18 hours, you can easily get all your work done from anywhere on this easily portable MacBook Air."
               },
               {
                  id: 7,
                  name: "Apple MacBook AIR Apple M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLXW3HN/A  (13.6 Inch, Space Grey, 1.24 Kg)",
                  price: 73990,
                  images: "'Apple_MacBook_m2.webp', 'Apple_MacBook_m2_details.webp'",
                  seller: 'TREASURE HAUL ONLINE',
                  seller_role: "No Returns Applicable \nGST invoice available",
                  highlights: "Stylish & Portable Thin and Light Laptop \n13.6 Inch Liquid Retina Display, LED-backlit display with IPS technology, 500 nits brightness, Wide colour (P3), True Tone technology \nLight Laptop without Optical Disk Drive",
                  description: "You can experience the power of the M2 chip on this redesigned MacBook Air. With a battery back up of up to 18 hours, you can easily get all your work done from anywhere on this easily portable MacBook Air."
               },
               {
                  id: 8,
                  name: "Apple MacBook AIR Apple M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLXW3HN/A  (13.6 Inch, Space Grey, 1.24 Kg)",
                  price: 73990,
                  images: "'Apple_MacBook_m2.webp', 'Apple_MacBook_m2_details.webp'",
                  seller: 'TREASURE HAUL ONLINE',
                  seller_role: "No Returns Applicable \nGST invoice available",
                  highlights: "Stylish & Portable Thin and Light Laptop \n13.6 Inch Liquid Retina Display, LED-backlit display with IPS technology, 500 nits brightness, Wide colour (P3), True Tone technology \nLight Laptop without Optical Disk Drive",
                  description: "You can experience the power of the M2 chip on this redesigned MacBook Air. With a battery back up of up to 18 hours, you can easily get all your work done from anywhere on this easily portable MacBook Air."
               },
            ]
         }
      },
      GroceryGourmetFood: {
         SnacksBeverages: {
            ChocolatesCandies: [
               {
                  id: 9,
                  name: "Cadbury Dairy Milk Fruit & Nut Chocolate Bars  (12 x 36 g)",
                  price: 496,
                  images: "",
                  seller: "SuperComNet",
                  seller_role: "No Returns Applicable \nGST invoice available",
                  highlights: "Milk Chocolate \nPlain Flavor",
                  description: "Kuch achha ho jaaye, kuch meetha ho jaaye with Cadbury Dairy Milk. Generously made with a glass and a half of milk, This Cadbury chocolate comes with the goodness of crunchy nuts & dried raisins. Cadbury Dairy Milk is the perfect meetha for sharing everyday moments of joy with your loved ones. This milk chocolate bar pack is perfect sweet for snacking & storing in the fridge, or as a chocolate gift pack for gifting on special occasions like birthdays and get-togethers. Every chocolate bar of Cadbury Dairy Milk is made from 100% sustainably sourced cocoa. It is suitable for vegetarians."
               },
               {
                  id: 10,
                  name: "Cadbury Dairy Milk Fruit & Nut Chocolate Bars  (12 x 36 g)",
                  price: 496,
                  images: "",
                  seller: "SuperComNet",
                  seller_role: "No Returns Applicable \nGST invoice available",
                  highlights: "Milk Chocolate \nPlain Flavor",
                  description: "Kuch achha ho jaaye, kuch meetha ho jaaye with Cadbury Dairy Milk. Generously made with a glass and a half of milk, This Cadbury chocolate comes with the goodness of crunchy nuts & dried raisins. Cadbury Dairy Milk is the perfect meetha for sharing everyday moments of joy with your loved ones. This milk chocolate bar pack is perfect sweet for snacking & storing in the fridge, or as a chocolate gift pack for gifting on special occasions like birthdays and get-togethers. Every chocolate bar of Cadbury Dairy Milk is made from 100% sustainably sourced cocoa. It is suitable for vegetarians."
               },
               {
                  id: 11,
                  name: "Cadbury Dairy Milk Fruit & Nut Chocolate Bars  (12 x 36 g)",
                  price: 496,
                  images: "",
                  seller: "SuperComNet",
                  seller_role: "No Returns Applicable \nGST invoice available",
                  highlights: "Milk Chocolate \nPlain Flavor",
                  description: "Kuch achha ho jaaye, kuch meetha ho jaaye with Cadbury Dairy Milk. Generously made with a glass and a half of milk, This Cadbury chocolate comes with the goodness of crunchy nuts & dried raisins. Cadbury Dairy Milk is the perfect meetha for sharing everyday moments of joy with your loved ones. This milk chocolate bar pack is perfect sweet for snacking & storing in the fridge, or as a chocolate gift pack for gifting on special occasions like birthdays and get-togethers. Every chocolate bar of Cadbury Dairy Milk is made from 100% sustainably sourced cocoa. It is suitable for vegetarians."
               },
               {
                  id: 12,
                  name: "Cadbury Dairy Milk Fruit & Nut Chocolate Bars  (12 x 36 g)",
                  price: 496,
                  images: "",
                  seller: "SuperComNet",
                  seller_role: "No Returns Applicable \nGST invoice available",
                  highlights: "Milk Chocolate \nPlain Flavor",
                  description: "Kuch achha ho jaaye, kuch meetha ho jaaye with Cadbury Dairy Milk. Generously made with a glass and a half of milk, This Cadbury chocolate comes with the goodness of crunchy nuts & dried raisins. Cadbury Dairy Milk is the perfect meetha for sharing everyday moments of joy with your loved ones. This milk chocolate bar pack is perfect sweet for snacking & storing in the fridge, or as a chocolate gift pack for gifting on special occasions like birthdays and get-togethers. Every chocolate bar of Cadbury Dairy Milk is made from 100% sustainably sourced cocoa. It is suitable for vegetarians."
               },
            ]
         }
      }
   }

   const electronics = [
      { mobilesAccessories: "Mobile" },
      { LaptopsComputers: "GamingLaptops" },
   ]

   let Mobiles = [
      {
         id: 1,
         name: 'realme 12x 5G (Woodland Green, 128 GB)  (8 GB RAM)',
         price: 13499,
         images: "product/images/realme12X.webp, product/images/realme12Xdetails.webp",
         seller: "XONIGHT E-Commerce",
         seller_role: '7 Days Service Center Replacement/Repair, GST invoice available',
         highlights: "8 GB RAM | 128 GB ROM | Expandable Upto 2 TB \n17.07 cm (6.72 inch) Full HD+ Display \n50MP + 2MP | 8MP Front Camera \n5000 mAh Battery \nDimensity 6100+ Processor",
         description: "The Realme 12x 5G is a sleek powerhouse redefining mobile technology. Swift charging meets endurance with 45 W SUPERVOOC Charge and a 5000 mAh battery, ensuring you're always connected. The Dimensity 6100+ 6nm chipset delivers lightning-fast 5G speeds for seamless connectivity wherever you are. Immerse yourself in the 12.07 cm (6.72) 120 Hz FHD+ Display, offering crystal-clear visuals with its ultra-smooth refresh rate. Style meets substance with its ultra-slim 7.69 mm profile and lightweight 188g body. Capture life's moments in stunning detail with the 50 MP AI camera, while the vapour chamber cooling system keeps performance optimal. Elevate your audio experience with dual stereo speakers, delivering Hi-Res Audio certification for immersive sound. The Realme 12x 5G: where innovation meets elegance in the palm of your hand.",
      },
      {
         id: 2,
         name: 'realme 12x 5G (Woodland Green, 128 GB)  (8 GB RAM)',
         price: 13499,
         images: "product/images/realme12X.webp, product/images/realme12Xdetails.webp",
         seller: "XONIGHT E-Commerce",
         seller_role: '7 Days Service Center Replacement/Repair, GST invoice available',
         highlights: "8 GB RAM | 128 GB ROM | Expandable Upto 2 TB \n17.07 cm (6.72 inch) Full HD+ Display \n50MP + 2MP | 8MP Front Camera \n5000 mAh Battery \nDimensity 6100+ Processor",
         description: "The Realme 12x 5G is a sleek powerhouse redefining mobile technology. Swift charging meets endurance with 45 W SUPERVOOC Charge and a 5000 mAh battery, ensuring you're always connected. The Dimensity 6100+ 6nm chipset delivers lightning-fast 5G speeds for seamless connectivity wherever you are. Immerse yourself in the 12.07 cm (6.72) 120 Hz FHD+ Display, offering crystal-clear visuals with its ultra-smooth refresh rate. Style meets substance with its ultra-slim 7.69 mm profile and lightweight 188g body. Capture life's moments in stunning detail with the 50 MP AI camera, while the vapour chamber cooling system keeps performance optimal. Elevate your audio experience with dual stereo speakers, delivering Hi-Res Audio certification for immersive sound. The Realme 12x 5G: where innovation meets elegance in the palm of your hand.",
      },
      {
         id: 3,
         name: 'realme 12x 5G (Woodland Green, 128 GB)  (8 GB RAM)',
         price: 13499,
         images: "product/images/realme12X.webp, product/images/realme12Xdetails.webp",
         seller: "XONIGHT E-Commerce",
         seller_role: '7 Days Service Center Replacement/Repair, GST invoice available',
         highlights: "8 GB RAM | 128 GB ROM | Expandable Upto 2 TB \n17.07 cm (6.72 inch) Full HD+ Display \n50MP + 2MP | 8MP Front Camera \n5000 mAh Battery \nDimensity 6100+ Processor",
         description: "The Realme 12x 5G is a sleek powerhouse redefining mobile technology. Swift charging meets endurance with 45 W SUPERVOOC Charge and a 5000 mAh battery, ensuring you're always connected. The Dimensity 6100+ 6nm chipset delivers lightning-fast 5G speeds for seamless connectivity wherever you are. Immerse yourself in the 12.07 cm (6.72) 120 Hz FHD+ Display, offering crystal-clear visuals with its ultra-smooth refresh rate. Style meets substance with its ultra-slim 7.69 mm profile and lightweight 188g body. Capture life's moments in stunning detail with the 50 MP AI camera, while the vapour chamber cooling system keeps performance optimal. Elevate your audio experience with dual stereo speakers, delivering Hi-Res Audio certification for immersive sound. The Realme 12x 5G: where innovation meets elegance in the palm of your hand.",
      },
      {
         id: 4,
         name: 'realme 12x 5G (Woodland Green, 128 GB)  (8 GB RAM)',
         price: 13499,
         images: "product/images/realme12X.webp, product/images/realme12Xdetails.webp",
         seller: "XONIGHT E-Commerce",
         seller_role: '7 Days Service Center Replacement/Repair, GST invoice available',
         highlights: "8 GB RAM | 128 GB ROM | Expandable Upto 2 TB \n17.07 cm (6.72 inch) Full HD+ Display \n50MP + 2MP | 8MP Front Camera \n5000 mAh Battery \nDimensity 6100+ Processor",
         description: "The Realme 12x 5G is a sleek powerhouse redefining mobile technology. Swift charging meets endurance with 45 W SUPERVOOC Charge and a 5000 mAh battery, ensuring you're always connected. The Dimensity 6100+ 6nm chipset delivers lightning-fast 5G speeds for seamless connectivity wherever you are. Immerse yourself in the 12.07 cm (6.72) 120 Hz FHD+ Display, offering crystal-clear visuals with its ultra-smooth refresh rate. Style meets substance with its ultra-slim 7.69 mm profile and lightweight 188g body. Capture life's moments in stunning detail with the 50 MP AI camera, while the vapour chamber cooling system keeps performance optimal. Elevate your audio experience with dual stereo speakers, delivering Hi-Res Audio certification for immersive sound. The Realme 12x 5G: where innovation meets elegance in the palm of your hand.",
      },
   ]
   let GamingLaptops = [
      {
         id: 5,
         name: "Apple MacBook AIR Apple M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLXW3HN/A  (13.6 Inch, Space Grey, 1.24 Kg)",
         price: 73990,
         images: "'Apple_MacBook_m2.webp', 'Apple_MacBook_m2_details.webp'",
         seller: 'TREASURE HAUL ONLINE',
         seller_role: "No Returns Applicable \nGST invoice available",
         highlights: "Stylish & Portable Thin and Light Laptop \n13.6 Inch Liquid Retina Display, LED-backlit display with IPS technology, 500 nits brightness, Wide colour (P3), True Tone technology \nLight Laptop without Optical Disk Drive",
         description: "You can experience the power of the M2 chip on this redesigned MacBook Air. With a battery back up of up to 18 hours, you can easily get all your work done from anywhere on this easily portable MacBook Air."
      },
      {
         id: 6,
         name: "Apple MacBook AIR Apple M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLXW3HN/A  (13.6 Inch, Space Grey, 1.24 Kg)",
         price: 73990,
         images: "'Apple_MacBook_m2.webp', 'Apple_MacBook_m2_details.webp'",
         seller: 'TREASURE HAUL ONLINE',
         seller_role: "No Returns Applicable \nGST invoice available",
         highlights: "Stylish & Portable Thin and Light Laptop \n13.6 Inch Liquid Retina Display, LED-backlit display with IPS technology, 500 nits brightness, Wide colour (P3), True Tone technology \nLight Laptop without Optical Disk Drive",
         description: "You can experience the power of the M2 chip on this redesigned MacBook Air. With a battery back up of up to 18 hours, you can easily get all your work done from anywhere on this easily portable MacBook Air."
      },
      {
         id: 7,
         name: "Apple MacBook AIR Apple M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLXW3HN/A  (13.6 Inch, Space Grey, 1.24 Kg)",
         price: 73990,
         images: "'Apple_MacBook_m2.webp', 'Apple_MacBook_m2_details.webp'",
         seller: 'TREASURE HAUL ONLINE',
         seller_role: "No Returns Applicable \nGST invoice available",
         highlights: "Stylish & Portable Thin and Light Laptop \n13.6 Inch Liquid Retina Display, LED-backlit display with IPS technology, 500 nits brightness, Wide colour (P3), True Tone technology \nLight Laptop without Optical Disk Drive",
         description: "You can experience the power of the M2 chip on this redesigned MacBook Air. With a battery back up of up to 18 hours, you can easily get all your work done from anywhere on this easily portable MacBook Air."
      },
      {
         id: 8,
         name: "Apple MacBook AIR Apple M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLXW3HN/A  (13.6 Inch, Space Grey, 1.24 Kg)",
         price: 73990,
         images: "'Apple_MacBook_m2.webp', 'Apple_MacBook_m2_details.webp'",
         seller: 'TREASURE HAUL ONLINE',
         seller_role: "No Returns Applicable \nGST invoice available",
         highlights: "Stylish & Portable Thin and Light Laptop \n13.6 Inch Liquid Retina Display, LED-backlit display with IPS technology, 500 nits brightness, Wide colour (P3), True Tone technology \nLight Laptop without Optical Disk Drive",
         description: "You can experience the power of the M2 chip on this redesigned MacBook Air. With a battery back up of up to 18 hours, you can easily get all your work done from anywhere on this easily portable MacBook Air."
      },
   ]

   const handleProduct = (product_id) => {
      navigate(`/ProductDetail?id=${product_id}`)
   }
   return (
      <>
         <h4 className='text-center text-xl font-bold'>{currantCategory}</h4>
         {electronics.map((subtype) => {
            return (
               <div className='flex flex-wrap gap-8 justify-center my-4'>
                  {Mobiles.map((mobile) => {
                     return (
                        <>
                           <div onClick={() => { handleProduct(mobile.id); }} className="flex flex-col items-center bg-white border border-gray-200 rounded-lg shadow md:flex-row md:max-w-xl hover:bg-gray-100 dark:border-gray-700 dark:bg-gray-800 dark:hover:bg-gray-700">
                              <img src={mobile.images.split(", ")[0]} className="object-cover w-full rounded-t-lg h-96 md:h-auto md:w-48 md:rounded-none md:rounded-s-lg" alt="" />
                              <div className="flex flex-col justify-between p-4 leading-normal">
                                 <h6 className="mb-2 text-xl font-bold tracking-tight text-gray-900 dark:text-white">{mobile.name}</h6>
                                 <p className="mb-3 font-normal text-gray-700 dark:text-gray-400">{mobile.highlights}</p>
                              </div>
                           </div>
                        </>
                     )
                  })}
               </div>
            )
         })}

      </>
   )
}

export default Product