import React, { Component } from 'react';
import NewsItem from './NewsItem';

export default class News extends Component {
   constructor(props) {
      super(props);
      // Initialize state to store API data and loading status
      this.state = {
         currentArticles: [], // Initialize as an empty array for articles
         loading: true,      // Initial loading state
         error: null,        // Error handling state
         page: 1,
         pageSize: 10
      };
   }

   // Fetch data when the component mounts
   async componentDidMount() { // first run render() method than run this method automatically (call itself)
      let url = `https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=e4e19cdc690c45e5a82a414d018d5d25&page=${this.state.page}&pageSize=${this.state.pageSize}`;
      let apiData = await fetch(url)
      let parsedData = await apiData.json()

      this.setState({
         currentArticles: parsedData.articles, // Store articles in state
         loading: false,   // Set loading to false
         totalResults: parsedData.totalResults
      });
   }

   handlePrevious = async () => {
      let url = `https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=e4e19cdc690c45e5a82a414d018d5d25&page=${this.state.page - 1}&pageSize=${this.state.pageSize}`
      console.log(url);

      let apiData = await fetch(url)
      let parsedData = await apiData.json()
      this.setState({
         currentArticles: parsedData.articles, // Store articles in state
         loading: false,   // Set loading to false
         page: this.state.page - 1,
      });
   }
   handleNext = async () => {
      if (this.state.page + 1 > Math.ceil(this.state.totalResults / this.state.pageSize)) {

      } else {
         let url = `https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=e4e19cdc690c45e5a82a414d018d5d25&page=${this.state.page + 1}&pageSize=${this.state.pageSize}`
         console.log(url);
         let apiData = await fetch(url)
         let parsedData = await apiData.json()
         this.setState({
            currentArticles: parsedData.articles, // Store articles in state
            loading: false,   // Set loading to false
            page: this.state.page + 1,
         });
      }
   }

   render() {
      const { currentArticles, loading, error } = this.state;

      // Handle loading and error states
      if (loading) {
         return <p>Loading...</p>;
      }

      if (error) {
         return <p>Error: {error.message}</p>;
      }

      return (
         <div className='container my-3'>
            <div className="container d-flex justify-content-between mb-3">
               <button disabled={this.state.page <= 1} onClick={this.handlePrevious} type="button" className="btn btn-primary">&larr; Previous</button>
               <button disabled={this.state.page + 1 > Math.ceil(this.state.totalResults / this.state.pageSize)} onClick={this.handleNext} type="button" className="btn btn-primary">Next &rarr;</button>
            </div>
            <div className="row d-flex justify-content-between">
               {/* Map through the articles and render the NewsItem component for each article */}
               {currentArticles.map((element) => {
                  return (
                     <div className="col p-0 mb-3" key={element.url}>
                        <NewsItem
                           title={element.title ? element.title.slice(0, 50) : "No Title"}
                           description={element.description ? element.description.slice(0, 100) : "No Description"}
                           imageURL={element.urlToImage}
                           newsURL={element.url}
                        />
                     </div>
                  );
               })}
            </div>
            <div className="container d-flex justify-content-between mb-3">
               <button disabled={this.state.page <= 1} onClick={this.handlePrevious} type="button" className="btn btn-primary">&larr; Previous</button>
               <button disabled={this.state.page + 1 > Math.ceil(this.state.totalResults / this.state.pageSize)} onClick={this.handleNext} type="button" className="btn btn-primary">Next &rarr;</button>
            </div>
         </div>
      );
   }
}






/*

fetch(`https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=e4e19cdc690c45e5a82a414d018d5d25&page=${this.state.page}&pageSize=10`)
         .then(response => {
            if (!response.ok) {
               throw new Error('Network response was not ok');
            }
            return response.json();  // Parse the JSON from the response
         })
         .then(data => {
            // Update the state with fetched articles
            this.setState({
               sampleArticles: data.articles, // Store articles in state
               loading: false,   // Set loading to false
            });
         })
         .catch(error => {
            this.setState({
               error: error,     // Store any error that occurs
               loading: false,   // Set loading to false
            });
         });

*/