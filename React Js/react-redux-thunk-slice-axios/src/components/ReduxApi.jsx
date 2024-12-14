import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import DOMPurify from "dompurify"; // DOMPurify is a library used to sanitize HTML, preventing security risks like cross-site scripting (XSS) attacks. It ensures that any potentially harmful or unsafe HTML content is cleansed of malicious code before being inserted into your DOM.
// using DOMPurify to sanitize various parts of your data, such as the title, price, description, category, and image URL. This helps prevent attacks by removing any harmful scripts or invalid HTML from the data before it's displayed on the webpage.

import { fetchApi, addData, deleteData, updateData } from "../app/Slice";

export default function Redux_api() {
   const [title, setTitle] = useState("");
   const [price, setPrice] = useState("");
   const [description, setDescription] = useState("");
   const [category, setCategory] = useState("");
   const [image, setImage] = useState("");
   const [rate, setRate] = useState(3.9);
   const [count, setCount] = useState(120);
   const [editID, setEditID] = useState(null);

   const dispatch = useDispatch();

   const record = useSelector((state) => {
      if (!state.ApiKey || !Array.isArray(state.ApiKey.record)) return { record: [], loading: true };
      return state.ApiKey;
   });

   useEffect(() => {
      dispatch(fetchApi());
   }, [dispatch]);

   const validateInputs = () => {
      if (!title || !price || !description || !category || !image) {
         alert("All fields are required!");
         return false;
      }
      if (isNaN(price) || Number(price) <= 0) {
         alert("Price must be a valid positive number.");
         return false;
      }
      if (isNaN(rate) || Number(rate) < 0 || Number(rate) > 5) {
         alert("Rate must be between 0 and 5.");
         return false;
      }
      if (isNaN(count) || Number(count) < 0) {
         alert("Count must be a valid positive number.");
         return false;
      }
      if (!isValidURL(image)) {
         alert("Please provide a valid image URL.");
         return false;
      }
      return true;
   };

   const isValidURL = (url) => {
      // Basic URL validation
      try {
         new URL(url);
         return true;
      } catch (e) {
         return false;
      }
   };

   const addOrUpdateData = async () => {
      if (!validateInputs()) return; // return; -> that means exit function if() condition true than exit function

      const sanitizedData = {
         id: editID || String(record.record.length + 1),
         title: DOMPurify.sanitize(title),
         price: DOMPurify.sanitize(price),
         description: DOMPurify.sanitize(description),
         category: DOMPurify.sanitize(category),
         image: DOMPurify.sanitize(image),
         rating: { rate: DOMPurify.sanitize(rate), count: DOMPurify.sanitize(count) },
      };

      if (editID) {
         dispatch(updateData({ editId: editID, updData: sanitizedData }));
         setEditID(null);
      } else {
         dispatch(addData(sanitizedData));
      }

      // Fetch the latest data from json-server after updating the store
      dispatch(fetchApi());  // Re-fetch data from the server

      resetForm();
   };

   const resetForm = () => {
      setTitle("");
      setPrice("");
      setDescription("");
      setCategory("");
      setImage("");
      setRate(3.9);
      setCount(120);
   };

   const handleDelete = (id) => {
      if (window.confirm("Are you sure you want to delete this record?")) {
         dispatch(deleteData(id));
      }
   };

   const handleEdit = (item) => {
      const confirmEdit = window.confirm("Do you want to edit this data?");
      if (confirmEdit) {
         setEditID(item.id);
         setTitle(item.title);
         setPrice(item.price);
         setDescription(item.description);
         setCategory(item.category);
         setImage(item.image);
         setRate(item.rating?.rate || 3.9);
         setCount(item.rating?.count || 120);
         window.scrollTo({ top: 0, behavior: "smooth" }); // Scrolls to the top smoothly
      }
   };

   return (
      <div>
         <div className="container">
            <form className="form">
               <input
                  type="text"
                  placeholder="Enter Your Title"
                  value={title}
                  onChange={(e) => setTitle(e.target.value)}
                  className="input"
                  required
               />
               <input
                  type="number"
                  placeholder="Enter Your Price"
                  value={price}
                  onChange={(e) => setPrice(e.target.value)}
                  className="input"
                  required
               />
               <textarea
                  placeholder="Enter Your Description"
                  value={description}
                  onChange={(e) => setDescription(e.target.value)}
                  className="input"
                  required
               />
               <input
                  type="text"
                  placeholder="Enter Your Category"
                  value={category}
                  onChange={(e) => setCategory(e.target.value)}
                  className="input"
                  required
               />
               <input
                  type="url"
                  placeholder="Enter Your Image URL"
                  value={image}
                  onChange={(e) => setImage(e.target.value)}
                  className="input"
                  required
               />
               <input
                  type="number"
                  placeholder="Enter Rating Rate"
                  value={rate}
                  onChange={(e) => setRate(e.target.value)}
                  className="input"
                  required
               />
               <input
                  type="number"
                  placeholder="Enter Rating Count"
                  value={count}
                  onChange={(e) => setCount(e.target.value)}
                  className="input"
                  required
               />
               <button type="button" onClick={addOrUpdateData} className="button">
                  {editID ? "Update Data" : "Add Data"}
               </button>
            </form>
            <h1 className="heading">Product Records</h1>
            <div className="records">
               {record.loading === false &&
                  record.record.map((item) => (
                     <div key={item.id} className="record-card">
                        <img
                           src={DOMPurify.sanitize(item.image)}
                           alt={DOMPurify.sanitize(item.title)}
                           className="record-image"
                        />
                        <h3 className="record-title">{DOMPurify.sanitize(item.title)}</h3>
                        <p className="record-price">Price: ${DOMPurify.sanitize(item.price)}</p>
                        <p className="record-description">
                           {DOMPurify.sanitize(
                              item.description.length > 50
                                 ? `${item.description.slice(0, 50)}...`
                                 : item.description
                           )}
                        </p>
                        <p className="record-category">Category: {DOMPurify.sanitize(item.category)}</p>
                        <p className="record-rating">
                           Rating: {DOMPurify.sanitize(item.rating?.rate)} (
                           {DOMPurify.sanitize(item.rating?.count)} reviews)
                        </p>
                        <div>
                           <button onClick={() => handleDelete(item.id)}>Delete</button>
                           <button onClick={() => handleEdit(item)}>Edit</button>
                        </div>
                     </div>
                  ))}
            </div>
         </div>
      </div>
   );
}