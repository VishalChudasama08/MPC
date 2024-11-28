export const addToArray = (item) => ({
    type: 'ADD_TO_ARRAY',
    payload: item, // The item to add to the array
});

export const removeFromArray = (index) => ({
    type: 'REMOVE_FROM_ARRAY',
    payload: index, // The index of the item to remove
});
