import React from 'react'

function StatusCard({ handleClickOnStatus }) {
   return (
      <div className='flex justify-center items-center p-2 cursor-pointer group' onClick={handleClickOnStatus}>
         <div className='w-[10%]'>
            <img className='h-10 w-10 rounded-full' src="krishna.jpg" alt="krishna" />
         </div>
         <div className='w-[90%] pl-2'>
            <div className="flex justify-between items-center">
               <p className="text-lg">username</p>
               <p className="text-sm">timestamp</p>
            </div>
         </div>
      </div>
   )
}

export default StatusCard