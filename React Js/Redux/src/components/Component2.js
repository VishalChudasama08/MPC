import React, { useState } from 'react'
import Component3 from './Component3'
import { useDispatch } from 'react-redux'
import Component4 from './Component4';
import Component5 from './Component5';
import Component6 from './Component6';

function Component2() {
    const dispatch = useDispatch()

    const [amount, setAmount] = useState(Number);

    const handleDeposit = () => {
        dispatch({ type: 'deposit', amount: amount })
        setAmount(0)
        document.getElementById('deposit').value = ''
    }
    const handleWithdraw = () => {
        dispatch({ type: 'withdraw', amount: amount })
        setAmount(0)
        document.getElementById('withdraw').value = ''
    }
    return (
        <div className='border border-primary rounded p-3'>
            This is Component 2
            <div className='row my-3'>
                <div className="card ms-3 p-0 col">
                    <h5 className="card-header">Add Amount</h5>
                    <div className="card-body mx-0 row">
                        <input onChange={(e) => setAmount(e.target.value)} className='form-control me-3 col' type="number" id='deposit' name="add" placeholder='Enter amount to add in your wallet' />
                        <button onClick={handleDeposit} className="btn btn-outline-warning col flex-grow-0">Deposit</button>
                    </div>
                </div>
                <div className="card mx-3 p-0 col">
                    <h5 className="card-header">Withdraw Amount</h5>
                    <div className="card-body mx-0 row">
                        <input onChange={(e) => setAmount(e.target.value)} className='form-control me-3 col' type="number" id='withdraw' name="add" placeholder='Enter amount to withdraw in your bank account' />
                        <button onClick={handleWithdraw} className="btn btn-outline-success col flex-grow-0">Withdraw</button>
                    </div>
                </div>
            </div>
            <Component3 /><br />
            <Component4 /><br />
            <Component5 /><br />
            <Component6 />
        </div>
    )
}

export default Component2