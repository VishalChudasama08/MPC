import React, { Component } from 'react';
import NewsItem from './NewsItem';
import Spinner from './Spinner';
import PropTypes from 'prop-types';

export default class News extends Component {
   next = 0;
   static defaultProps = { // set default Props if props not pass than use this
      pageSize: 10,
      country: 'in',
      category: 'general'
   }

   static propTypes = { // set props data types 
      pageSize: PropTypes.number,
      country: PropTypes.string,
      category: PropTypes.string
   }

   // Capitalizing the first character of specific fields
   capitalizeFirstChar = (string) => {
      return string.charAt(0).toUpperCase() + string.slice(1)
   }

   constructor(props) {
      super(props);
      // Initialize state to store API data and loading status
      this.state = {
         currentArticles: [], // Initialize as an empty array for articles
         loading: true,      // Initial loading state
         error: null,        // Error handling state
         page: 1,
      };
      document.title = `${this.capitalizeFirstChar(this.props.category)} - VNews`
   }

   mainURl = `https://newsapi.org/v2/top-headlines?country=${this.props.country}&category=${this.props.category}&apiKey=e4e19cdc690c45e5a82a414d018d5d25`
   // "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=e4e19cdc690c45e5a82a414d018d5d25" 

   async fetchMethod() {
      let url = `${this.mainURl}&page=${this.state.page}&pageSize=${this.props.pageSize}`;
      console.log(url);

      let apiData = await fetch(url)
      let parsedData = await apiData.json()
      this.setState({
         currentArticles: parsedData.articles, // Store articles in state
         loading: false,   // Set loading to false
         totalResults: parsedData.totalResults
      });
   }

   // Fetch data when the component mounts
   async componentDidMount() { // first run render() method than run this method automatically (call itself)
      this.fetchMethod()
   }

   handlePrevious = async () => {
      this.setState(
         (prevState) => ({ page: prevState.page - 1, loading: true }), // Update the page first
         () => this.fetchMethod() // Call fetchMethod() after the page is updated
      );
   }
   handleNext = async () => {
      if (!(this.state.page + 1 > Math.ceil(this.state.totalResults / this.props.pageSize))) {
         this.setState(
            (prevState) => ({ page: prevState.page + 1, loading: true }), // Update the page first
            () => this.fetchMethod() // Call fetchMethod() after the page is updated
         );
      }
   }

   render() {
      const { currentArticles, loading, error } = this.state;

      // Handle loading and error states
      if (loading) {
         return <Spinner />;
      }

      if (error) {
         return <p>Error: {error.message}</p>;
      }

      return (
         <div className='container mb-3 mt-1'>
            <div className="d-flex justify-content-between mb-3">
               <button disabled={this.state.page <= 1} onClick={this.handlePrevious} type="button" className="btn btn-sm btn-primary mt-4">&larr; Previous</button>
               <h2 className='mt-2'>VNews - Top {this.capitalizeFirstChar(this.props.category)} Headlines</h2>
               <button disabled={this.state.page + 1 > Math.ceil(this.state.totalResults / this.props.pageSize)} onClick={this.handleNext} type="button" className="btn btn-sm btn-primary mt-4">Next &rarr;</button>
            </div>

            <div className="row d-flex justify-content-between">
               {/* Map through the articles and render the NewsItem component for each article */}
               {currentArticles.map((element) => {
                  // Check if the title or any other field is '[Removed]'
                  if (element.title === '[Removed]' || element.description === '[Removed]' || element.author === '[Removed]') {
                     console.log('Removed News:', element);
                     return null; // Skip rendering this item
                  }

                  return (
                     <div className="col p-0 mb-3" key={element.url}>
                        <NewsItem
                           source={element.source.name ? element.source.name : ""}
                           imageURL={element.urlToImage ? element.urlToImage : "No Image"}
                           title={element.title ? element.title.slice(0, 70) : "No Title"}
                           description={element.description ? element.description.slice(0, 95) : "No Description"}
                           newsURL={element.url ? element.url : ' '}
                           newsDate={element.publishedAt ? element.publishedAt : " "}
                           author={element.author ? element.author : "[Unknown]"}
                        />
                     </div>
                  );
               })}
            </div>

            <div className="d-flex justify-content-between mb-3">
               <button disabled={this.state.page <= 1} onClick={this.handlePrevious} type="button" className="btn btn-sm btn-primary">&larr; Previous</button>
               <button disabled={this.state.page + 1 > Math.ceil(this.state.totalResults / this.props.pageSize)} onClick={this.handleNext} type="button" className="btn btn-sm btn-primary">Next &rarr;</button>
            </div>
         </div>
      );
   }
}






/*
               Methods in React Component Lifecycle 

# reader():- The reader() method is used to render HTML of the component in react.
      This method is required for a class based component to render the DOM.
      it runs during the mounting and updating of your component. 
      render() method should be pure ie you cannot modify state inside it!

# componentDidMount():- the componentDidMount() method runs after the component output has been rendered to the DOM.

# componentDidUpdate():- method is invoked as soon as the updating happens.
      The most common use case for the componentDidUpdate() method is updating the DOM in response to prop or state changes.

# componentWillUnmount():- lifecycle method just before the component is unmounted and destroyed. 
      Usually to preform cleanups 
*/