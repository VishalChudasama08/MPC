import React from 'react'
import Notes from './Notes';

const Home = () => {
    return (
        <div>
            <h2>Add a Note</h2>
            <form>
                <div className="mb-3">
                    <label htmlFor="exampleFormControlInput1" className="form-label">Make Title</label>
                    <input type="text" className="form-control" id="exampleFormControlInput1" placeholder="what is note title ?" />
                </div>
                <div className="mb-3">
                    <label htmlFor="exampleFormControlTextarea1" className="form-label">Enter New Note</label>
                    <textarea className="form-control" id="exampleFormControlTextarea1" placeholder='what is note description ?' rows="3"></textarea>
                </div>
                <button type="submit" className="btn btn-primary">Submit</button>
            </form>

            <Notes />

        </div>
    )
}

export default Home