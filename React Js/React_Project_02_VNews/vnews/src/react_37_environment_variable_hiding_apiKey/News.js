import React, { Component } from 'react';
import NewsItem from './NewsItem';
import Spinner from './Spinner';
import PropTypes from 'prop-types';
import InfiniteScroll from "react-infinite-scroll-component";

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
         error: null,       // Error handling state
         page: 1,
      };
      document.title = `${this.capitalizeFirstChar(this.props.category)} - VNews`
   }

   mainURl = `https://newsapi.org/v2/top-headlines?country=${this.props.country}&category=${this.props.category}&apiKey=${this.props.apiKey}`
   // "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=e4e19cdc690c45e5a82a414d018d5d25" 

   // Fetch data when the component mounts
   async componentDidMount() { // first run render() method than run this method automatically (call itself)
      await this.props.progressBar(20)
      let url = `${this.mainURl}&page=${this.state.page}&pageSize=${this.props.pageSize}`;
      console.log(url);

      let apiData = await fetch(url)
      await this.props.progressBar(60)
      let parsedData = await apiData.json()
      await this.props.progressBar(80)
      this.setState({
         currentArticles: parsedData.articles, // Store articles in state
         loading: false,   // Set loading to false
         totalResults: parsedData.totalResults
      });
      await this.props.progressBar(100)
   }

   async nextPage() {
      let currentPageNumber = this.state.page
      let nextPageNumber = currentPageNumber + 1
      console.log(nextPageNumber);

      this.setState({ page: nextPageNumber });
   }

   fetchMoreData = async () => {
      // console.log(this.state.page); // Logs the current page number before updating

      // Use setState with a callback to ensure the page is updated before proceeding
      this.setState(
         (prevState) => ({ page: prevState.page + 1 }),
         async () => {
            // This callback is executed after the state is updated

            let url = `${this.mainURl}&page=${this.state.page}&pageSize=${this.props.pageSize}`;
            console.log(url); // Log the URL for debugging

            let apiData = await fetch(url);
            let parsedData = await apiData.json();
            this.setState({
               currentArticles: this.state.currentArticles.concat(parsedData.articles),
               loading: false, // Set loading to false after data is fetched
            });
         }
      );
   };


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
         <>
            <h2 className='my-3 text-center'>VNews - Top {this.capitalizeFirstChar(this.props.category)} Headlines</h2>

            <InfiniteScroll
               dataLength={this.state.currentArticles.length}
               next={this.fetchMoreData}
               hasMore={this.state.currentArticles.length < this.state.totalResults}
               loader={<Spinner />}
            >
               <div className="container">
                  <div className="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
                     {/* Map through the articles and render the NewsItem component for each article */}
                     {currentArticles.map((element) => {
                        // Check if the title or any other field is '[Removed]'
                        if (element.title === '[Removed]' || element.description === '[Removed]' || element.author === '[Removed]') {
                           console.log('Removed News:', element);
                           return null; // Skip rendering this item
                        }

                        return (
                           <div className="col" key={element.url}>
                              <NewsItem
                                 source={element.source.name ? element.source.name : ""}
                                 imageURL={element.urlToImage ? element.urlToImage : ' '}
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
               </div>
            </InfiniteScroll>
         </>
      );
   }
}
