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
            <h3>Add New card</h3><br />
            Enter Title: <input
                type="text"
                value={name}
                onChange={(e) => setName(e.target.value)}
                placeholder="Name"
            />
            <br />
            <br />
            Enter Description: <input
                type="text"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                placeholder="Description"
            /><br /><br />
            <button className="btn btn-primary ms-2" onClick={addObject}>Add</button>
        </div>
    );
};

export default ObjectForm;
