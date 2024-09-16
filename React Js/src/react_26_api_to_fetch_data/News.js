import React, { Component } from 'react';
import NewsItem from './NewsItem';

export default class News extends Component {
   constructor(props) {
      super(props);
      // Initialize state to store API data and loading status
      this.state = {
         sampleArticles: [], // Initialize as an empty array for articles
         loading: true,      // Initial loading state
         error: null         // Error handling state
      };
   }

   // Fetch data when the component mounts
   componentDidMount() {
      fetch('https://newsapi.org/v2/top-headlines?apiKey=e4e19cdc690c45e5a82a414d018d5d25&q=school')
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
   }

   render() {
      const { sampleArticles, loading, error } = this.state;

      // Handle loading and error states
      if (loading) {
         return <p>Loading...</p>;
      }

      if (error) {
         return <p>Error: {error.message}</p>;
      }

      return (
         <div className='container my-3'>
            <div className="row d-flex justify-content-between">
               {/* Map through the articles and render the NewsItem component for each article */}
               {sampleArticles.map((element) => {
                  return (
                     <div className="col p-0 mb-3" key={element.url}>
                        <NewsItem
                           title={element.title ? element.title.slice(0, 45) : "No Title"}
                           description={element.description ? element.description.slice(0, 88) : "No Description"}
                           imageURL={element.urlToImage}
                           newsURL={element.url}
                        />
                     </div>
                  );
               })}
            </div>
         </div>
      );
   }
}
