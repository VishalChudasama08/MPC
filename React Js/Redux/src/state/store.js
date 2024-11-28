import { createStore } from "redux";
import reducers from "./reducers";
import { applyMiddleware } from "redux";
import { thunk } from "redux-thunk"; // helping to execute asynchronous function


export const store = createStore(reducers, {}, applyMiddleware(thunk))