const initialArrayState = { items: [] };

const arrayReducer = (state = initialArrayState, action) => {
    switch (action.type) {
        case 'ADD_ITEM':
            return { ...state, items: [...state.items, action.payload] };
        default:
            return state;
    }
};

export default arrayReducer;
