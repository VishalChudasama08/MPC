const initialObjectState = { items: [] };

const objectReducer = (state = initialObjectState, action) => {
    switch (action.type) {
        case 'ADD_OBJECT':
            return { ...state, items: [...state.items, action.payload] };
        default:
            return state;
    }
};

export default objectReducer;
