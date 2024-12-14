import React from 'react';
import { useSelector } from 'react-redux';

const CounterMiter = () => {
    const count = useSelector((state) => state.counter.count); // get counter count data from redux store
    // state.counter.count => 
    // 'state'->redux store state, 
    // 'counter'->reducer: { counter: counterReducer,... } in 'store' function on store.js file,
    // 'count'-> counter state name from here counterReducer.js file 

    return (
        <button disabled className='btn btn-outline-info mx-3'>Counter Miter: {count}</button>
    );
};

export default CounterMiter;
