import React from 'react'
import { BiCommentDetail } from 'react-icons/bi'
import { TbCircleDashed } from 'react-icons/tb'

function HomePage() {
   return (
      <div className='relative'>
         <div className='py-14 bg-[#00a884] w-full'></div>
         <div className='flex bg-[#f0f2f5] h-[90vh] absolute top-6 left-6 w-full'>
            <div className='left w-[30%] bg-[#e8e9ec] h-full'>
               <div className='w-full'>
                  <div className='flex justify-between items-center p-3'>
                     <div className='flex items-center space-x-3'>
                        <img className='rounded-full w-10 h-10 cursor-pointer' src="IMG_20230327_101111.jpg" alt="" />
                        <p>UserName</p>
                     </div>
                     <div className='space-x-3 text-2xl flex'>
                        <TbCircleDashed />
                        <BiCommentDetail />
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   )
}

export default HomePage