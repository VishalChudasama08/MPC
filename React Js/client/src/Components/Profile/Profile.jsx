import React, { useState } from 'react'
import { BsArrowLeft, BsCheck2, BsPencil } from 'react-icons/bs'

function Profile({ handleCloseOpenProfile }) {
   const [flag, setFlag] = useState(false);
   const [username, setUsername] = useState("");

   const handleFlag = () => {
      flag ? setFlag(false) : setFlag(true);
   }

   return (
      <div className='leftSide w-[30%] bg-[#e8e9ec] h-full'>
         <div className='flex flex-row space-x-10 bg-[#008069] text-white py-5 px-10'>
            <BsArrowLeft className='absolute top-6 cursor-pointer text-2xl font-bold' onClick={handleCloseOpenProfile} />
            <p className='cursor-pointer text-2xl font-semibold'>Profile</p>
         </div>

         {/* profile picture */}
         <div className='flex justify-center my-10'>
            <label htmlFor="">
               <img className='rounded-full w-[15vw] h-[vm] cursor-pointer' src="IMG_20230327_101111.jpg" alt="" />
            </label>
            <input type="file" className='hidden' name="" id="imgInput" />
         </div>

         {/* name */}
         <div className='bg-white p-4'>
            <p className='pb-5 px-1'>Your Name</p>

            {!flag && <div className='flex justify-between'>
               <p className='w-[85%] px-1'>{username || <i>username</i>}</p>
               <BsPencil className='cursor-pointer' onClick={handleFlag} />
            </div>}

            {flag && <div className='flex justify-between'>
               <input className='w-[85%] outline-none border-b-2 border-blue-500 rounded-sm ps-1' type="text" placeholder='Enter Your Name' onChange={(e) => { setUsername(e.target.value) }} />
               <BsCheck2 className='cursor-pointer text-2xl' onClick={handleFlag} />
            </div>}

         </div>
         <div className='px-5'>
            <p className='py-5'>This is not username, this name will be visible to your whatsapp contacts.</p>
         </div>
      </div>
   )
}

export default Profile