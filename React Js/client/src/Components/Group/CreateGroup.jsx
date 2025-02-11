import React from 'react'
import { AiOutlineSearch } from 'react-icons/ai';
import { BsArrowLeft, BsFilter } from 'react-icons/bs'
import Chats from '../Chat/Chats';

function CreateGroup({ handleCreateGroup, handleSearch, setQuery, query }) {
   return (
      <div className='leftSide w-[30%] bg-[#e8e9ec] h-full'>
         <div className='flex flex-row space-x-10 bg-[#008069] text-white py-5 px-7'>
            <BsArrowLeft className='mt-px cursor-pointer text-3xl' onClick={handleCreateGroup} />
            <p className='cursor-pointer text-2xl font-semibold'>Add Group Members</p>
         </div>

         {/* search & find use chat */}
         <div className='relative flex justify-center bg-white py-4 px-3'>
            <input className='border-none outline-none bg-slate-200 rounded-md w-[90%] pl-9 py-2' type="text"
               placeholder='Search or start new chat'
               onChange={(e) => { handleSearch(e.target.value); setQuery(e.target.value); }}
               value={query} />
            <AiOutlineSearch className='absolute left-5 top-7' />
            <div>
               <BsFilter className='ml-4 text-3xl mt-2' />
            </div>
         </div>
      </div>
   )
}

export default CreateGroup