import React from 'react';
import { useSelector } from 'react-redux';

const CounterMiter = () => {
    const count = useSelector((state) => state.counter.count);

    return (
        <nav className="navbar bg-dark text-white">
            <h3>Counter Miter: {count}</h3>
        </nav>
    );
};

export default CounterMiter;
