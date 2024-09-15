import React, { Component } from 'react'

export default class NewsItem extends Component {
    render() {
        let { title, description } = this.props; // in class base components get props 
        return (
            <div>
                <div className="card" style={{ width: '18rem' }}>
                    <img src="https://nextbigfuture.s3.amazonaws.com/uploads/2024/03/Screen-Shot-2024-03-26-at-11.44.17-AM.jpg" className="card-img-top" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">{title}</h5>
                        <p className="card-text">{description}</p>
                        <a href="/newsdesc" className="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </div >
        )
    }
}

/* 
https://newsapi.org/v2/top-headlines?apiKey=e4e19cdc690c45e5a82a414d018d5d25&q=space 

sampleOutput.json file created using this link
*/
