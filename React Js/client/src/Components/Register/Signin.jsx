import { Alert, Button, Snackbar } from '@mui/material';
import { green } from '@mui/material/colors';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

function Signin() {
   const navigate = useNavigate();
   const [inputData, setInputData] = useState({ email: "", password: "" })
   const [openSnackbar, setOpenSnackbar] = useState(false);

   const handleSnackbarClose = () => {
      setOpenSnackbar(false);
   }

   const handleSubmit = (event) => {
      event.preventDefault()
      setOpenSnackbar(true);
   }

   const handleChange = (e) => {
      const { name, value } = e.target;
      setInputData((values) => ({ ...values, [name]: value }))
   }

   const changeStyle = (cName) => {
      const element = document.getElementsByClassName(cName)[0]; // Get the first element with class cName
      if (element) {
         element.classList.remove("translate-x-5", "translate-y-4"); // Remove specific classes
      }
   }
   const changeStyleV = (cName) => {
      if (inputData.email.length === 0) {
         const element = document.getElementsByClassName(cName)[0]; // Get the first element with class cName
         if (element) {
            element.classList.add("translate-x-5", "translate-y-4"); // Remove specific classes
         }
      }
   }

   return (
      <div>
         <div className='flex justify-center items-center h-screen'>
            <div className='w-[70%] p-10 shadow-md rounded-md bg-white'>
               <form onSubmit={handleSubmit} action="" className='space-y-5'>
                  <div>
                     <p className='emailInput mb-2 px-1 relative inline-block transition-all duration-500 ease-in-out translate-x-5 translate-y-4 bg-white'>Email</p>
                     <input type="text" name="email" id=""
                        className='py-2 ps-2 outline outline-green-600 w-full rounded border'
                        placeholder='Enter Your Email'
                        onFocus={() => changeStyle("emailInput")}
                        onBlur={() => { inputData.email.length === 0 ? changeStyleV("emailInput") : changeStyle("emailInput") }}
                        onChange={(e) => handleChange(e)}
                        value={inputData.email}
                     />
                  </div>
                  <div>
                     <p className='passwordInput mb-2 px-1 relative inline-block transition-all duration-500 ease-in-out translate-x-5 translate-y-4 bg-white'>Password</p>
                     <input type="password" name="password" id=""
                        className='py-2 ps-2 outline outline-green-600 w-full rounded border'
                        placeholder='Enter Your Password'
                        onFocus={() => changeStyle("passwordInput")}
                        onBlur={() => { inputData.password.length === 0 ? changeStyleV("passwordInput") : changeStyle("passwordInput") }}
                        onChange={(e) => handleChange(e)}
                        value={inputData.password} />
                  </div>
                  <div>
                     <Button type='submit' sx={{ bgcolor: green[600], paddingTop: ".7rem", ":hover": { bgcolor: "primary.main" } }} className='w-full' variant='contained'>Sing In</Button>
                  </div>
               </form>
               <div className='flex space-x-3 items-center mt-5'>
                  <p className='m-0'>Create New Account</p>
                  <Button variant='text' onClick={() => navigate("/signup")} sx={{ color: green[600], paddingTop: ".7rem", ":hover": { color: "primary.main" } }}>signup</Button>
               </div>
            </div>
         </div>
         <Snackbar open={openSnackbar} autoHideDuration={6000} onClose={handleSnackbarClose}>
            <Alert onClose={handleSnackbarClose} severity='success' sx={{ width: '100%' }}>
               Login Successfully!
            </Alert>
         </Snackbar>
      </div>
   )
}

export default Signin