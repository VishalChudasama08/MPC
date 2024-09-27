import React from 'react'

const NewsItem = (props) => {
    let { title, description, imageURL, newsURL, newsDate, author, source } = props; // in class base components get props 
    return (
        <div className="card h-100">
            <span className="position-absolute badge rounded-start bg-secondary" style={{ top: '-1px', right: '-1px', zIndex: '1' }}>{source}</span>
            <img src={imageURL} className="card-img-top" alt='' />
            <div className="card-body">
                <h5 className="card-title">{title}...</h5>
                <p className="card-text">{description}...</p>
                <div className="d-flex justify-content-between">
                    <a href={newsURL} target='_black' className="btn btn-sm btn-info">Read More</a>
                    <span className="text-muted text-end" style={{ lineHeight: '1' }}>
                        <small>
                            Author: {author.slice(0, 25)}<br />
                            Date: {new Date(newsDate).toGMTString().slice(0, -4)}
                        </small>
                    </span>
                </div>
            </div>
        </div>
    )
}
export default NewsItem;