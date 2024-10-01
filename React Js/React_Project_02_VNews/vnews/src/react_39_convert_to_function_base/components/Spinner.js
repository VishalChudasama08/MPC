import React from 'react'
import loading from './loading.gif'

const Spinner = (props) => {
  return (
    <div className='text-center my-5'>
      <img src={loading} style={{ width: 50 }} alt="Loading..." />
    </div>
  )
}
export default Spinner; 