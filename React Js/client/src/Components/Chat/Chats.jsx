import React from 'react'
import ChatCard from './ChatCard'

function Chats({ query, handleClickOnChat }) {
   return (
      <div className='bg-white overflow-y-scroll h-[76.5vh] px-3'>
         {query && [1, 2, 1, 1, 1, 4, 5, 1, 3, 4, 7, 8].map((item) => (
            <div onClick={handleClickOnChat}>
               <hr />
               <ChatCard />
            </div>
         ))}
      </div>
   )
}

export default Chats