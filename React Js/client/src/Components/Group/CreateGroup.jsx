import React, { useState } from 'react'
import { AiOutlineSearch } from 'react-icons/ai';
import { BsArrowLeft, BsArrowRight } from 'react-icons/bs'
import SelectedMember from './SelectedMember';

function CreateGroup({ handleCreateGroup, handleSearch }) {
   const [searchMember, setSearchMember] = useState("");
   const [newGroup, setNewGroup] = useState(false)
   const [groupMember, setGroupMember] = useState(new Set());

   const handleRemoveMember = (item) => {
      const newGroupMember = new Set(groupMember); // Create a new Set
      newGroupMember.delete(item); // Add item to the new Set

      setGroupMember(newGroupMember); // Update state with the new Set
   }

   const handleSelectMember = (item) => {
      // if (!(groupMember instanceof Set)) {
      //    console.error("groupMember is not a Set:", groupMember);
      //    setGroupMember(new Set()); // Reset if it's not a Set
      //    return;
      // }

      // Create a new Set and add the selected item
      const newGroupMember = new Set(groupMember);
      newGroupMember.add(item);

      setGroupMember(newGroupMember); // Update state
   };

   return (
      <div className='leftSide flex w-full bg-[#e8e9ec] h-full'>
         <div className='w-[50%]'>
            <div className='flex flex-row space-x-10 bg-[#008069] text-white p-4'>
               <BsArrowLeft className='mt-px cursor-pointer text-3xl' onClick={handleCreateGroup} />
               <p className='cursor-pointer text-2xl font-semibold'>Add Group Members</p>
            </div>

            {/* search & find use chat */}
            <div className='relative flex justify-center bg-white py-4 px-3'>
               <input className='border-none outline-none bg-slate-200 rounded-md w-[90%] pl-9 py-2' type="text"
                  placeholder='Search members'
                  onChange={(e) => { handleSearch(e.target.value); setSearchMember(e.target.value); }}
                  value={searchMember} />
               <AiOutlineSearch className='absolute left-11 top-7' />
            </div>
            <hr />

            <div className='bg-white overflow-y-scroll h-[76.3vh] px-3'>
               {searchMember && [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, "Vishal"].map((item) => (
                  <div key={item} onClick={() => handleSelectMember(item)}>
                     <div className='flex bg-slate-300 rounded-full items-center m-2 cursor-pointer group'>
                        <img className='h-10 w-10 rounded-full' src="krishna.jpg" alt="krishna" />
                        <p className="text-lg pl-2">{item}</p>
                     </div>
                  </div>
               ))}
               {!searchMember && <p className='text-center italic my-[50%]'> Search </p>}
            </div>
         </div>
         <div className='w-[50%]'>
            <div className='bg-[#008069] border-l-2 text-white  p-4'>
               <p className='text-2xl font-semibold'>Selected Members</p>
            </div>
            {/* Selected members */}
            {groupMember.size > 0 && <div className='flex flex-wrap justify-center overflow-y-scroll p-4'>
               {Array.from(groupMember).map((item) => <SelectedMember handleRemoveMember={() => handleRemoveMember(item)} member={item} />)}
            </div>}
            {groupMember.size == 0 && <p className='text-center italic my-[50%]'>Any group member not selected! <br /> Select minimum 3 members</p>}

            <button className='absolute right-[10%] bottom-[10%] cursor-pointer rounded-full font-semibold border-green-600 border-2 text-green-600 hover:bg-green-600 hover:text-white py-2 px-4'>Create Group With This Members</button>
         </div>
      </div>
   )
}

export default CreateGroup