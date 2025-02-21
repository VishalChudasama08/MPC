import { LOGIN, LOGOUT, REGISTER, REQ_USER, SEARCH_USER, UPDATE_USER } from "./ActionType";

const initialValue = {
   singUp: null,
   singIn: null,
   reqUser: null,
}

export const authReducer = (store = initialValue, { type, payload }) => {
   if (type === REGISTER) {
      return { ...store, singUp: payload }
   } else if (type === LOGIN) {
      return { ...store, singIn: payload }
   } else if (type === LOGOUT) {
      return { ...store, singUp: null, singIn: null } // logout than remove previous signup/signin user data
   } else if (type === REQ_USER) {
      return { ...store, reqUser: payload }
   } else if (type === SEARCH_USER) {
      return { ...store, searchUser: payload }
   } else if (type === UPDATE_USER) {
      return { ...store, updatedUser: payload }
   }
   return store;
}