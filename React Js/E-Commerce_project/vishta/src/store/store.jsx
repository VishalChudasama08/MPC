import { configureStore } from "@reduxjs/toolkit";
import productSlice from "../products/productApiSlice";

const store = configureStore({
   reducer: {
      productApiKey: productSlice,
   }
})

export default store;
