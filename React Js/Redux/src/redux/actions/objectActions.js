// redux/actions/objectActions.js

export const addToObject = (key, value) => ({
    type: 'ADD_TO_OBJECT',
    payload: { key, value }, // The key-value pair to add
});

export const updateObjectKey = (key, value) => ({
    type: 'UPDATE_OBJECT_KEY',
    payload: { key, value }, // The key-value pair to update
});
