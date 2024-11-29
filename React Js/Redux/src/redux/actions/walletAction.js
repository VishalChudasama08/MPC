export const depositAmount = (value) => ({
    type: 'deposit',
    amount: value
}) // this addAmount function return object
// this type arrow function by default return value ex. let hello = () => ("Hello " + name); this return "Hello " + name

export const withdrawAmount = (value) => ({
    type: 'withdraw',
    amount: value
})