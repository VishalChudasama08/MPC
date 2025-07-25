import React, { useEffect, useState } from 'react'
import { BsArrowLeft, BsArrowRight } from 'react-icons/bs'
import { stories } from './DummyStory'
import { RxCross2 } from 'react-icons/rx';
import { useNavigate } from 'react-router-dom';
import ProgressBar from './ProgressBar';

function StatusViewer() {
   const [currentStroyIndex, setCurrentStroyIndex] = useState(0);
   const [activeIndex, setActiveIndex] = useState(0);

   const duration = 3000;
   const navigate = useNavigate();

   const handleNextStroy = () => {
      if (currentStroyIndex < stories?.length - 1) {
         setCurrentStroyIndex(currentStroyIndex + 1)
         setActiveIndex(activeIndex + 1)
      } else {
         setCurrentStroyIndex(0)
         setActiveIndex(0)
      }
   }

   const handleClickOnClose = () => {
      navigate("/");
   }

   useEffect(() => {
      const intervalId = setInterval(() => {
         handleNextStroy();
      }, duration)
      return () => clearInterval(intervalId);
   }, [currentStroyIndex, activeIndex]);

   let statusUrl = stories?.[currentStroyIndex]?.image;
   let statusUrlArray = statusUrl.split("/");
   let statusName = statusUrlArray[statusUrlArray.length - 1];
   let statusNameArray = statusName.split(".");
   let extension = statusNameArray[statusNameArray.length - 1];
   // console.log(extension);

   return (
      <div className='relative'>
         <div className='absolute right-[10%] top-[2rem]'>
            <RxCross2 className='cursor-pointer text-5xl p-2 text-white hover:bg-slate-400 rounded-full hover:text-slate-900' onClick={handleClickOnClose} />
         </div>
         <div className='flex w-[50%] absolute top-0 mx-[25%]'>
            {stories.map((item, index) => <ProgressBar key={index} index={index} currentStroyIndex={currentStroyIndex} duration={duration} />)}
         </div>
         <div className='flex justify-between items-center h-[100vh] bg-slate-950 pt-5 px-[10%]'>
            {/* Left Arrow */}
            <div>
               <BsArrowLeft
                  className='cursor-pointer text-5xl p-2 text-white hover:bg-slate-400 rounded-full hover:text-slate-900 ripple-button'
                  onClick={() =>
                     setCurrentStroyIndex((prevIndex) =>
                        prevIndex > 0 ? prevIndex - 1 : stories?.length - 1
                     )
                  }
               />
            </div>

            {/* Status section */}
            <div className='items-center'>

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

               <div className='flex max-w-[100%] max-h-[100%] flex-col relative'>
                  <img className="max-h-[90vh] object-contain" src={stories?.[currentStroyIndex]?.image} alt="" />
               </div>

            </div>

            {/* Right Arrow */}
            <div>
               <BsArrowRight
                  className='cursor-pointer text-5xl p-2 text-white hover:bg-slate-400 rounded-full hover:text-slate-900'
                  onClick={() =>
                     setCurrentStroyIndex((prevIndex) =>
                        prevIndex === stories?.length - 1 ? 0 : prevIndex + 1
                     )
                  }
               />
            </div>
         </div>
      </div>
   )
}

export default StatusViewer