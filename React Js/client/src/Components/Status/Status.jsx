import React from 'react'
import StatusCard from './StatusCard'
import { useNavigate } from 'react-router-dom'

function Status() {
   const navigate = useNavigate();

   const handleClickOnStatus = () => {
      navigate("/status/{userId}");
      // console.log("okay");

   }
   return (
      <div className='bg-white overflow-y-scroll h-[76.5vh] px-3'>
         {[1, 2, 1, 1, 1, 4, 5, 1, 3, 4, 7, 8].map((item) => (
            <div>
               <hr />
               <StatusCard handleClickOnStatus={handleClickOnStatus} />
            </div>
         ))}
      </div>
   )
}

export default Status