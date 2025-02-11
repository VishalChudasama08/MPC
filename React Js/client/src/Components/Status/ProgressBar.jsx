import React, { useEffect, useState } from 'react';
import "./ProgressBar.css";

function ProgressBar({ index, currentStroyIndex, duration }) {
   const isActive = index === currentStroyIndex; // Use comparison operator `===`
   const [progress, setProgress] = useState(0); // Initialize progress state

   useEffect(() => {
      const intervalId = setInterval(() => {
         setProgress((prev) => {
            if (prev < 100) {
               return prev + 1;
            }
            clearInterval(intervalId);
            return prev;
         });
      }, duration / 100);

      return () => clearInterval(intervalId); // Cleanup on component unmount or currentStroyIndex change
   }, [currentStroyIndex, duration]);

   useEffect(() => {
      setProgress(0); // Reset progress when currentStroyIndex changes
   }, [currentStroyIndex]);

   return (
      <div className={`progress-bar-container ${isActive ? "active-story" : ""}`}>
         <div
            className={`${isActive ? "progress-bar" : ""}`}
            style={{ width: `${progress}%` }}
         ></div>
      </div>
   );
}

export default ProgressBar;
