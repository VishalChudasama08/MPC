import React from 'react'
import Component2 from './Component2'
import CounterButtons from './CounterButtons'

const Home = () => {
    return (
        <div className='border border-secondary rounded p-3'>
            This is Component 1
            <CounterButtons />
            <Component2 />
        </div>
    )
}

export default Home