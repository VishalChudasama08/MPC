import React from 'react'

function ChatCard() {
   return (
      <div className='flex justify-center items-center p-2 cursor-pointer group'>
         <div className='w-[10%]'>
            <img className='h-10 w-10 rounded-full' src="krishna.jpg" alt="krishna" />
         </div>
         <div className='w-[90%] pl-2'>
            <div className="flex justify-between items-center">
               <p className="text-lg">username</p>
               <p className="text-sm">timestamp</p>
            </div>
            <div className="flex justify-between items-center">
               <p>last message...</p>
               <div className="flex space-x-2 items-center">
                  <p className="text-xs py-1 px-2 text-white bg-green-500 rounded-full font-bold">5</p>
               </div>
            </div>
         </div>
      </div>
   )
}

export default ChatCard