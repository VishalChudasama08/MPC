import React, { useContext, useState } from 'react'
import noteContext from '../context/notes/NoteContext'
import { useNavigate } from "react-router-dom";

const Login = () => {
    const host = "http://localhost:5000";

    const { showAlert } = useContext(noteContext);

    const [credentials, setCredentials] = useState({ email: "", password: "" })
    const navigate = useNavigate();

    // handle onChange all input
    const handleOnChange = (event) => {
        setCredentials({ ...credentials, [event.target.name]: event.target.value }) // get input data and set in credentials named useState hook
    }

    const handleSubmit = async (event) => {
        event.preventDefault()
        try {
            const response = await fetch(`${host}/api/auth/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ email: credentials.email, password: credentials.password })
            });

            const userData = await response.json();
            if (userData.success) {
                localStorage.setItem("UserToken", userData.jwtToken)
                navigate("/") // go to "/" page
                showAlert("success", "Login successfully")
            } else {
                console.log(userData);
                showAlert("danger", userData.err)
            }

        } catch (error) {
            console.error("Error fetching data:", error.message);
        }
    }

    return (
        <div>
            <h3 className='my-4'>Login Here</h3>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address</label>
                    <input type="email" name="email" onChange={handleOnChange} className="form-control" id="email" aria-describedby="emailHelp" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password" name="password" onChange={handleOnChange} className="form-control" id="password" minLength={8} required />
                </div>
                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
        </div>
    )
}

export default Login