import React from 'react'
import Component3 from './Component3'

function Component2() {
    return (
        <div className='border border-primary rounded p-3'>
            This is Component 2
            <Component3 />
            <div className='row mt-3'>
                <div className="card ms-3 p-0 col">
                    <h5 className="card-header">Add Amount</h5>
                    <div className="card-body mx-0 row">
                        <input className='form-control me-3 col' type="number" name="add" placeholder='Enter amount to add in your wallet' />
                        <button className="btn btn-outline-warning col flex-grow-0">Add</button>
                    </div>
                </div>
                <div className="card mx-3 p-0 col">
                    <h5 className="card-header">Withdraw Amount</h5>
                    <div className="card-body mx-0 row">
                        <input className='form-control me-3 col' type="number" name="add" placeholder='Enter amount to withdraw in your bank account' />
                        <button className="btn btn-outline-success col flex-grow-0">Withdraw</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Component2