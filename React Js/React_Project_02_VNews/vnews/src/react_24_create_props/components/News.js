import React, { Component } from 'react'
import NewsItem from './NewsItem'

export default class News extends Component {
    render() {
        return (
            <div className='container my-3'>
                <div className="row mb-3">
                    <div className="col-md-3">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                    <div className="col-md-3">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                    <div className="col-md-3">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                </div>
                <div className="row mb-3">
                    <div className="col-md-3">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                    <div className="col-md-3">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                    <div className="col-md-3">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                </div>
            </div>
        )
    }
}
