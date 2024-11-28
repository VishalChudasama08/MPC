import React from 'react';
import { useDispatch } from 'react-redux';
import { increment, decrement } from '../redux/actions/counterAction';

const CounterButtons = () => {
    const dispatch = useDispatch();

    return (
        <div className="text-center mt-5">
            <button className="btn btn-success me-2" onClick={() => dispatch(increment())}>
                Increment
            </button>
            <button className="btn btn-danger" onClick={() => dispatch(decrement())}>
                Decrement
            </button>
        </div>
    );
};

export default CounterButtons;
