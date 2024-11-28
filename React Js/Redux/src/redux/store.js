import { configureStore } from '@reduxjs/toolkit';
import counterReducer from './reducers/counterReducer';
import arrayReducer from './reducers/arrayReducer';
import objectReducer from './reducers/objectReducer';

const store = configureStore({
    reducer: {
        counter: counterReducer,
        array: arrayReducer,
        objects: objectReducer,
    }
});

export default store;
