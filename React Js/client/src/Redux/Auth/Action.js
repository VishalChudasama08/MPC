import { BASE_API_URL } from "../../Config/api"
import { REGISTER } from "./ActionType";

export const register = (data) => async (dispatch) => {
   try {
      const res = await fetch(`${BASE_API_URL}/api/auth/signup`, {
         method: "POST",
         headers: {
            "Content-Type": "application/json",
         },
         body: JSON.stringify(data)
      })

      const resData = await res.json();
      console.log("register data: ", resData);

      dispatch({ type: REGISTER, payload: resData })
   } catch (error) {

   }
}

export const login = (data) => async (dispatch) => {
   try {
      const res = await fetch(`${BASE_API_URL}/api/auth/signup`, {
         method: "POST",
         headers: {
            "Content-Type": "application/json",
         },
         body: JSON.stringify(data)
      })

      const resData = await res.json();
      console.log("register data: ", resData);

      dispatch({ type: REGISTER, payload: resData })
   } catch (error) {

   }
}