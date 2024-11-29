const initialState = { balance: 0 }

const walletReducer = (state = initialState, action) => {
    let amount = action.amount;
    amount = Number(amount)

    switch (action.type) {
        case 'deposit':
            return { ...state, balance: state.balance + amount }
        // here set key amount:, but also do without key like:- state + action.amount, if set key than useSelector() time properly mention this, ex. const {balance} = useSelector((state)=>(state.wallet.balance)); here wallet that is key than present in store.js, and balance is also key than present in initialState object (walletReducer.js file)  

        case 'withdraw':
            return { ...state, balance: state.balance - amount }

        default:
            return state;
    }
}

export default walletReducer;