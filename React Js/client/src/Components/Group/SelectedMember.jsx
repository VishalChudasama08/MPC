import React from 'react'
import { AiOutlineClose } from 'react-icons/ai'

function SelectedMember({ handleRemoveMember, member }) {
   return (
      <div className='flex items-center bg-slate-300 rounded-full p-1 m-1 h-10'>
         <img className='w-7 h-7 rounded-full' src="logo192.png" alt="" />
         <p className='px-2'>{member}</p>
         <AiOutlineClose className='pr-1 text-2xl cursor-pointer' onClick={handleRemoveMember} />
      </div>
   )
}

export default SelectedMember