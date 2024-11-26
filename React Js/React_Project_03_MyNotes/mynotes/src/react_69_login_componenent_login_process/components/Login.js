import React, { useState } from 'react'
import { useNavigate } from "react-router-dom";

const Login = () => {
    const host = "http://localhost:5000";

    const [credentials, setCredentials] = useState({ email: "", password: "" })
    const navigate = useNavigate();

    // handle onChange all input
    const heddleOnChange = (event) => {
        setCredentials({ ...credentials, [event.target.name]: event.target.value }) // get input data and set in credentials named useState hook
    }

    const heddleSubmit = async (event) => {
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
            } else {
                console.log(userData);
                alert("Please try to login with correct credentials");
            }

        } catch (error) {
            console.error("Error fetching data:", error.message);
        }
    }

    return (
        <div>
            <form onSubmit={heddleSubmit}>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address</label>
                    <input type="email" name="email" onChange={heddleOnChange} className="form-control" id="email" aria-describedby="emailHelp" />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password" name="password" onChange={heddleOnChange} className="form-control" id="password" />
                </div>
                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
        </div>
    )
}

export default Login