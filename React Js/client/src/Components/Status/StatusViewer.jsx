import React, { useEffect, useState } from 'react'
import { BsArrowLeft, BsArrowRight } from 'react-icons/bs'
import { stories } from './DummyStory'

function StatusViewer() {
   const [currentStroyIndex, setCurrentStroyIndex] = useState(0);
   const [activeIndex, setActiveIndex] = useState(0);

   const handleNextStroy = () => {
      if (currentStroyIndex < stories?.length - 1) {
         setCurrentStroyIndex(currentStroyIndex + 1)
         setActiveIndex(activeIndex + 1)
      } else {
         setCurrentStroyIndex(0)
         setActiveIndex(0)
      }
   }

   useEffect(() => {
      const intervalId = setInterval(() => {
         handleNextStroy();
      }, 3000)
      return () => clearInterval(intervalId);
   }, [currentStroyIndex]);

   return (
      <div className='relative'>
         <div className='flex justify-between h-[100vh] bg-slate-950 pt-5 px-5'>
            <div>
               <BsArrowLeft
                  className='cursor-pointer text-3xl text-white'
                  onClick={() =>
                     setCurrentStroyIndex((prevIndex) =>
                        prevIndex > 0 ? prevIndex - 1 : stories?.length - 1
                     )
                  }
               />
            </div>
            <div className='flex items-center'>
               {/* <div className='flex justify-between bg-black h-2 py-1'>
                  {[1, 2, 1, 1, 1].map((item) => (
                     <>
                        <span className='border-2 border-gray-300 w-full  rounded-md'></span>
                        <span className='h-1.5'>v</span>
                     </>
                  ))}
               </div>
               <video
                  src="/ohayo_ohayo.mp4"
                  autoPlay="true"
                  controls
                  className='max-h-[90vh]'
               >
                  Your browser does not support the video tag.
               </video> */}
               <img className="max-h-[90vh] object-contain" src={stories?.[currentStroyIndex]?.image} alt="" />
            </div>
            <div>
               <BsArrowRight
                  className='cursor-pointer text-3xl text-white'
                  onClick={() =>
                     setCurrentStroyIndex((prevIndex) =>
                        prevIndex == stories?.length - 1 ? 0 : prevIndex + 1
                     )
                  }
               />
            </div>
         </div>
      </div>
   )
}

export default StatusViewer