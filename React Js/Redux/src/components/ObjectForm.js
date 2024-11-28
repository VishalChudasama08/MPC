import React, { useState } from 'react';
import { useDispatch } from 'react-redux';

const ObjectForm = () => {
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const dispatch = useDispatch();

    const addObject = () => {
        if (name.trim() && description.trim()) {
            const newObject = { name, description };
            dispatch({ type: 'ADD_OBJECT', payload: newObject });
            setName('');
            setDescription('');
        }
    };

    return (
        <div>
            <h3>Add New Object</h3>
            <input
                type="text"
                value={name}
                onChange={(e) => setName(e.target.value)}
                placeholder="Name"
            />
            <input
                type="text"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                placeholder="Description"
            />
            <button className="btn btn-primary ms-2" onClick={addObject}>
                Add
            </button>
        </div>
    );
};

export default ObjectForm;
