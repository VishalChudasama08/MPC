import React, { Component } from 'react'

export default class NewsItem extends Component {
    render() {
        let { title, description, imageURL, newsURL, newsDate, author, source } = this.props; // in class base components get props 
        return (
            <div className="card" style={{ width: '26rem' }}>
                <span className="position-absolute badge rounded-start bg-secondary" style={{ top: '-1px', right: '-1px', zIndex: '1' }}>{source}</span>
                <img src={imageURL} className="card-img-top img-fluid" style={{ height: '17rem' }} alt='' />
                <div className="card-body">
                    <h5 className="card-title">{title}...</h5>
                    <p className="card-text">{description}...</p>
                    <div className="d-flex justify-content-between">
                        <a href={newsURL} target='_black' className="btn btn-sm btn-info">Read More</a>
                        <span className="text-muted text-end" style={{ lineHeight: '1' }}>
                            <small>
                                Author: {author}<br />
                                Date: {new Date(newsDate).toGMTString().slice(0, -4)}
                            </small>
                        </span>
                    </div>
                </div>
            </div>
        )
    }
}