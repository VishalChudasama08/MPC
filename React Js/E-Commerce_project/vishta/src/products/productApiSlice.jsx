import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

let host = "http://localhost:";
let port = "5050";
let mainEndPoint = "/products";

let url = `${host}${port}${mainEndPoint}`;
console.log(url);

export const fetchApi = createAsyncThunk("fetchApi", async () => {
   let response = await axios.get(url); // fetch all product
   console.log(response.data);

   return response.data;
})

export const productSlice = createSlice({
   name: "productSlice",
   initialState: { productData: [], loading: true },
   extraReducers: (builder) => {
      builder.addCase(fetchApi.fulfilled, (state, action) => {
         state.loading = false;
         state.productData = action.payload;
      })
   }
})

export default productSlice.reducer;