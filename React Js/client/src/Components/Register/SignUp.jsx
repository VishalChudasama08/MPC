import { Alert, Button, Snackbar } from '@mui/material';
import { green } from '@mui/material/colors';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { currentUser, register } from '../../Redux/Auth/Action';
import { useDispatch, useSelector } from 'react-redux';

function SignUp() {
   const token = localStorage.getItem("token");

   const { auth } = useSelector(store => store);
   console.log("auth from signup page: ", auth);

   const dispatch = useDispatch();

   const navigate = useNavigate();

   const [inputData, setInputData] = useState({ fullName: "", email: "", password: "" })
   const [openSnackbar, setOpenSnackbar] = useState(false);
   const [confirmPassword, setConfirmPassword] = useState("");

   useEffect(() => {
      if (token) {
         dispatch(currentUser(token))
      }
   }, [token])

   useEffect(() => {
      if (auth.reqUser?.fullName) {
         navigate("/")
      }
   }, [auth.reqUser])

   const handleSnackbarClose = () => {
      setOpenSnackbar(false);
   }

   const handleSubmit = (event) => {
      event.preventDefault()

      dispatch(register(inputData))
      setOpenSnackbar(true);
   }

   const formSubmitDisability = () => {
      if (inputData.email === "" || inputData.fullName === "" || inputData.password === "" || confirmPassword === "" || inputData.password !== confirmPassword) {
         return true;
      } else {
         return false;
      }
   }

   const handleChange = (e) => {
      setInputData({ ...inputData, [e.target.name]: e.target.value })
      // console.log(inputData);
   }

   const handleConfirmPassword = (e, thisElementClassName) => {
      setConfirmPassword(e.target.value);
      // console.log(confirmPassword);
      const element = document.getElementsByClassName(thisElementClassName)[0];
      if (element) {
         if (inputData.password === e.target.value) { // here not use confirmPassword. The issue occurs because React state updates are asynchronous.
            element.classList.remove("outline-red-600", "bg-red-100")
         } else {
            element.classList.add("outline-red-600", "bg-red-100")
         }
      }
   }

   const changeStyle = (cName) => {
      const element = document.getElementsByClassName(cName)[0]; // Get the first element with class cName
      if (element) {
         element.classList.remove("translate-x-5", "translate-y-4"); // Remove specific classes
      }
   }
   const changeStyleV = (cName) => {
      const element = document.getElementsByClassName(cName)[0]; // Get the first element with class cName
      if (element) {
         element.classList.add("translate-x-5", "translate-y-4"); // Remove specific classes
      }
   }

   return (
      <div>
         <div className='flex flex-col justify-center min-h-screen items-center'>
            <div className='w-[70%] p-10 shadow-md rounded-md bg-white'>
               <form onSubmit={handleSubmit} action="" className='space-y-5'>
                  {/* <p>name: {inputData.fullname} <br /> email: {inputData.email} <br /> password: {inputData.password} <br /> confirm password: {confirmPassword}</p> */}
                  <div>
                     <p className='usernameInput mb-[0.65%] px-1.5 relative inline-block transition-all duration-500 ease-in-out translate-x-5 translate-y-4 bg-white rounded-full'>User Name</p>
                     <input type="text" name='fullName' placeholder='Enter username'
                        className='py-2 ps-3 outline outline-green-600 w-full rounded border-1'
                        onFocus={() => changeStyle("usernameInput")}
                        onBlur={(e) => { inputData.fullName.length === 0 ? changeStyleV("usernameInput") : changeStyle("usernameInput") }}
                        onChange={(e) => handleChange(e)}
                        value={inputData.fullName} />
                  </div>
                  <div>
                     <p className='emailInput mb-[0.65%] px-1.5 relative inline-block transition-all duration-500 ease-in-out translate-x-5 translate-y-4 bg-white rounded-full'>Email</p>
                     <input type="text" name='email' placeholder='Enter Email'
                        className='py-2 ps-3 outline outline-green-600 w-full rounded border-1'
                        onFocus={() => changeStyle("emailInput")}
                        onBlur={() => { inputData.email.length === 0 ? changeStyleV("emailInput") : changeStyle("emailInput") }}
                        onChange={(e) => handleChange(e)}
                        value={inputData.email} />
                  </div>
                  <div>
                     <p className='passwordInput mb-[0.65%] px-1.5 relative inline-block transition-all duration-500 ease-in-out translate-x-5 translate-y-4 bg-white rounded-full'>Password</p>
                     <input type="password" name='password' placeholder='Create Password'
                        className='py-2 ps-3 outline outline-green-600 w-full rounded border-1'
                        onFocus={() => changeStyle("passwordInput")}
                        onBlur={() => { inputData.password.length === 0 ? changeStyleV("passwordInput") : changeStyle("passwordInput") }}
                        onChange={(e) => { handleChange(e); setConfirmPassword("") }}
                        value={inputData.password} />
                  </div>
                  <div className={`confirmEnterPassword ${inputData.password === "" ? 'opacity-30' : ''}`}>
                     <p className='ConfirmPasswordInput mb-[0.65%] px-1.5 relative inline-block transition-all duration-500 ease-in-out translate-x-5 translate-y-4 bg-white rounded-full'>Confirm Password</p>
                     <input type="password" name='password' placeholder='Re-Enter Password'
                        className='input8 py-2 ps-3 outline outline-green-600 w-full rounded border-1'
                        onFocus={() => changeStyle("ConfirmPasswordInput")}
                        onBlur={() => { confirmPassword.length === 0 ? changeStyleV("ConfirmPasswordInput") : changeStyle("ConfirmPasswordInput") }}
                        onChange={(e) => { handleConfirmPassword(e, "input8") }}
                        value={confirmPassword}
                        disabled={inputData.password === "" ? true : false} />
                  </div>
                  <div>
                     <Button type='submit' sx={{ bgcolor: green[600], paddingTop: ".7rem", ":hover": { bgcolor: "primary.main" } }} className=' w-full' variant='contained' disabled={formSubmitDisability()}>Sing Up</Button>
                  </div>
               </form>
               <div className='flex space-x-3 items-center mt-5'>
                  <p className='m-0'>Already Have Account ?</p>
                  <Button variant='text' onClick={() => navigate("/signin")} sx={{ color: green[600], paddingTop: ".7rem", ":hover": { color: "primary.main" } }}>signin</Button>
               </div>
            </div>
         </div>
         <Snackbar open={openSnackbar} autoHideDuration={6000} onClose={handleSnackbarClose}>
            <Alert onClose={handleSnackbarClose} severity='success' sx={{ width: '100%' }}>
               Your Account Successfully Created!
            </Alert>
         </Snackbar>
      </div>
   )
}

export default SignUp