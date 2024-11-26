import React, { useState } from 'react'
import { useNavigate } from "react-router-dom";

const SignUp = () => {
    const host = "http://localhost:5000";

    const [credentials, setCredentials] = useState({ name: "", email: "", password: "", cPassword: "" })
    const navigate = useNavigate();

    // handle onChange all input
    const heddleOnChange = (event) => {
        setCredentials({ ...credentials, [event.target.name]: event.target.value }) // get input data and set in credentials named useState hook
    }

    const heddleSubmit = async (event) => {
        event.preventDefault()
        try {
            const response = await fetch(`${host}/api/auth/createUser`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ name: credentials.name, email: credentials.email, password: credentials.password })
            });

            const dbResponse = await response.json();
            if (dbResponse.success) {
                localStorage.setItem("UserToken", dbResponse.jwtToken)
                navigate("/login") // go to "/login" page
            } else {
                console.log(dbResponse);
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
                    <label htmlFor="name" className="form-label">Name</label>
                    <input type="text" className="form-control" id="name" name="name" onChange={heddleOnChange} required />
                </div>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address</label>
                    <input type="email" className="form-control" id="email" name="email" onChange={heddleOnChange} aria-describedby="emailHelp" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password" className="form-control" id="password" name="password" onChange={heddleOnChange} minLength={8} autoComplete="new-password" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="cPassword" className="form-label">Confirm Password</label>
                    <input type="password" className="form-control" id="cPassword" name="cPassword" onChange={heddleOnChange} minLength={8} autoComplete="new-password" required />
                </div>
                {credentials.cPassword.length !== 0 && credentials.password !== credentials.cPassword && (<small className="text-danger">{"Passwords do not match, Please confirm your password"}</small>)}
                <button type="submit" disabled={credentials.password !== credentials.cPassword} className="btn btn-primary d-block">Submit</button>
            </form>
        </div>
    )
}

export default SignUp