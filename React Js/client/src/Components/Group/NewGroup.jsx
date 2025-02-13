import { Button, CircularProgress } from '@mui/material';
import React, { useState } from 'react'
import { BsArrowLeft, BsCheck2 } from 'react-icons/bs';

function NewGroup({ handleNewGroup }) {
   const [isImageUploading, setIsImageUploading] = useState(false);
   const [groupName, setGroupName] = useState("");

   return (
      <div className='w-full h-full'>
         <div className='flex flex-row space-x-10 bg-[#008069] text-white p-4'>
            <BsArrowLeft className='mt-px cursor-pointer text-3xl' onClick={handleNewGroup} />
            <p className='text-2xl font-semibold'>New Group</p>
         </div>

         <div className='flex flex-col justify-center items-center'>
            <label className='w-60 h-60' htmlFor="imgInput">
               <img className='rounded-full m-5' src="dummy_group_image.webp" alt="dummy group image" />
               {isImageUploading && (
                  <CircularProgress className='absolute top-20 left-24' />
               )}
            </label>

            <input type="file" className="hidden cursor-pointer" id="imgInput" onChange={() => { console.log("image change"); }} />

            <input className='w-[50%] outline-none border-b-2 border-blue-500 rounded-sm mt-10 ps-2' type="text" placeholder='Enter Group Name' onChange={(e) => setGroupName(e.target.value)} />

            {groupName && (<div className='bg-[#008069] rounded-full mt-10'>
               <Button>
                  <BsCheck2 className='text-white font-bold text-5xl' />
               </Button>
            </div>)}
         </div>
      </div>
   )
}

export default NewGroup