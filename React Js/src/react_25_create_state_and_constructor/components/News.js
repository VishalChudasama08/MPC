import React, { Component } from 'react'
import NewsItem from './NewsItem'
import sample from './sampleOutput.json'

export default class News extends Component {
    sampleStatus = sample.status;
    sampleArticles = sample.articles;

    constructor() {
        super();
        this.state = {
            articles: this.sampleArticles,
            loading: false
        }
    }
    render() {
        return (
            <div className='container my-3'>
                {this.sampleStatus}
                <div className="row mb-3">
                    <div className="col p-0">
                        <NewsItem title={this.sampleArticles[0].title} description={this.sampleArticles[0].description} imageURL="https://fastly.picsum.photos/id/38/536/354.jpg?hmac=_z8YiiDU3GI3KUtRDkJC2nM7s2BdGWRjLnxdAYHjaA0" newsURL="TODO" />
                    </div>
                    <div className="col p-0">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                    <div className="col p-0">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                </div>
                <div className="row mb-3">
                    <div className="col p-0">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                    <div className="col p-0">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                    <div className="col p-0">
                        <NewsItem title="title" description="This is news description." />
                    </div>
                </div>
            </div>
        )
    }
}
