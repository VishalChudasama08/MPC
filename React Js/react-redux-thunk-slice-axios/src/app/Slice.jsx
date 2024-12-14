import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

export const fetchApi = createAsyncThunk("fetchApi", async () => {
   let response = await axios.get("http://localhost:5000/post");
   return response.data;
})
export const addData = createAsyncThunk("addData", async (newData) => {
   let response = await axios.post("http://localhost:5000/post", newData);
   return response.data;
})

export const deleteData = createAsyncThunk("deleteData", async (i) => {
   await axios.delete(`http://localhost:5000/post/${i}`)
   return i;
})
export const updateData = createAsyncThunk("updateData", async ({ editId, updData }) => {
   await axios.put(`http://localhost:5000/post/${editId}`, updData)
   return { editId, updData };
})

export const apiSlice = createSlice({
   name: "apiSlice",
   initialState: { record: [], loading: true },
   reducers: {},
   extraReducers: (builder) => {
      builder.addCase(fetchApi.fulfilled, (state, action) => {
         state.loading = false;
         state.record = action.payload;
      })
      builder.addCase(fetchApi.pending, (state, action) => {
         state.loading = true;
      })
      builder.addCase(deleteData.fulfilled, (state, action) => {
         state.record = state.record.filter((item) => item.id !== action.payload)
      })
      builder.addCase(addData.fulfilled, (state, action) => {
         state.record.push(action.payload)
      })
      builder.addCase(updateData.fulfilled, (state, action) => {
         state.record = state.record.map((e) => e.id === action.payload.editId ? { ...e, ...action.payload.updData } : e)
      })
   }
})
export default apiSlice.reducer;