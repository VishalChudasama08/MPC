import React from 'react';
import { useSelector } from 'react-redux';

const CounterMiter = () => {
    const count = useSelector((state) => state.counter.count);

    return (
        <button disabled className='btn btn-outline-info mx-3'>Counter Miter: {count}</button>
    );
};

export default CounterMiter;
