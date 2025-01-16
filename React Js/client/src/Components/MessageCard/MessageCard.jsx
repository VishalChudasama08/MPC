import React from 'react'

function MessageCard({ isReqUserMassage, massageContent }) {
   return (
      <div className={`py-1 px-2 rounded-md max-w-[70%] ${isReqUserMassage ? "self-start bg-white" : "self-end bg-[#d9fdd3]"}`}>
         <p>{massageContent}</p>
      </div>
   )
}

export default MessageCard