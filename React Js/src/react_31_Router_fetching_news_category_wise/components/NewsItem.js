import React, { Component } from 'react'

export default class NewsItem extends Component {
    render() {
        let { title, description, imageURL, newsURL, newsDate } = this.props; // in class base components get props 
        return (
            <div className="card" style={{ width: '26rem' }}>
                <img src={imageURL} className="card-img-top img-fluid" style={{ height: '17rem' }} alt='' />
                <div className="card-body">
                    <h5 className="card-title">{title}...</h5>
                    <p className="card-text">{description}...</p>
                    <a href={newsURL} target='_black' className="btn btn-sm btn-info">Read More</a>
                    <span className='m-2 text-muted'>{newsDate}</span>
                </div>
            </div>
        )
    }
}