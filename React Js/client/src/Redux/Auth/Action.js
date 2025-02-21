import { BASE_API_URL } from "../../Config/api"
import { LOGIN, LOGOUT, REGISTER, REQ_USER, SEARCH_USER, UPDATE_USER } from "./ActionType";

export const register = (inputData) => async (dispatch) => {
   // console.log(inputData);

   try {
      const res = await fetch(`${BASE_API_URL}/api/auth/signup`, {
         method: "POST",
         headers: {
            "Content-Type": "application/json",
         },
         body: JSON.stringify(inputData)
      })

      const resData = await res.json();
      console.log(resData);

      if (resData.awt) {
         localStorage.setItem("token", resData.awt)
      }

      dispatch({ type: REGISTER, payload: resData })
   } catch (error) {
      console.log("catch register error: " + error);
   }
}

export const login = (data) => async (dispatch) => {
   try {
      const res = await fetch(`${BASE_API_URL}/api/auth/signin`, {
         method: "POST",
         headers: {
            "Content-Type": "application/json",
         },
         body: JSON.stringify(data)
      })

      const resData = await res.json();
      console.log("login data: ", resData);

      if (resData.awt) {
         localStorage.setItem("token", resData.awt)
      }

      dispatch({ type: LOGIN, payload: resData })
   } catch (error) {
      console.log("catch login error: " + error);
   }
}

export const currentUser = (token) => async (dispatch) => {
   try {
      const res = await fetch(`${BASE_API_URL}/api/users/profile`, {
         method: "GET",
         headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`
         },
      })

      const resData = await res.json();
      console.log("currentUser data: ", resData);

      dispatch({ type: REQ_USER, payload: resData })
   } catch (error) {
      console.log("catch currentUser error: " + error);
   }
}

export const searchUser = (data) => async (dispatch) => {
   try {
      const res = await fetch(`${BASE_API_URL}/api/users/search?name=${data.keyword}`, {
         method: "GET",
         headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${data.token}`
         },
      })

      const resData = await res.json();
      console.log("searchUser data: ", resData);

      dispatch({ type: SEARCH_USER, payload: resData })
   } catch (error) {
      console.log("catch searchUser error: " + error);
   }
}

export const updateUser = (data) => async (dispatch) => {
   try {
      const res = await fetch(`${BASE_API_URL}/api/users/update/${data.id}`, {
         method: "GET",
         headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${data.token}`
         },
      })

      const resData = await res.json();
      console.log("updateUser data: ", resData);

      dispatch({ type: UPDATE_USER, payload: resData })
   } catch (error) {
      console.log("catch updateUser error: " + error);
   }
}

export const logout = () => async (dispatch) => {
   localStorage.clear();
   dispatch({ type: LOGOUT, payload: null })
   dispatch({ type: REQ_USER, payload: null }) // remove request user data from store
}