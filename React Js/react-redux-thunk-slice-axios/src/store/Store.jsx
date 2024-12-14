import { configureStore } from "@reduxjs/toolkit";
import apiSlice from "../app/Slice";

const store = configureStore({
   reducer: {
      ApiKey: apiSlice,
   }
})

export default store;