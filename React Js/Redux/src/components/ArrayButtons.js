import React, { useState } from 'react';
import { useDispatch } from 'react-redux';

const ArrayButtons = () => {
    const [newItem, setNewItem] = useState('');
    const dispatch = useDispatch();

    const addItem = () => {
        if (newItem.trim() !== '') {
            dispatch({ type: 'ADD_ITEM', payload: newItem });
            setNewItem('');
        }
    };

    return (
        <div className="my-3">
            <h3>Add Item:</h3>
            <input
                type="text"
                value={newItem}
                onChange={(e) => setNewItem(e.target.value)}
                placeholder="Enter item"
            />
            <button className="btn btn-primary ms-2" onClick={addItem}>
                Add Item
            </button>
        </div>
    );
};

export default ArrayButtons;
