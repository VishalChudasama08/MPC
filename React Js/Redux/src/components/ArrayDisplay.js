import React from 'react';
import { useSelector } from 'react-redux';

const ArrayDisplay = () => {
    const items = useSelector((state) => state.array.items);

    return (
        <div>
            <h3>Array Items:</h3>
            <ul>
                {items.map((item, index) => (
                    <li key={index}>{item}</li>
                ))}
            </ul>
        </div>
    );
};

export default ArrayDisplay;
