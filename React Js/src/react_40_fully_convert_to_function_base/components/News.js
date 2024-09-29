import React, { useEffect, useState } from 'react';
import NewsItem from './NewsItem';
import Spinner from './Spinner';
import PropTypes from 'prop-types';
import InfiniteScroll from "react-infinite-scroll-component";

const News = (props) => {
   const [currentArticles, setCurrentArticles] = useState([]); // currentArticles state value -> Initialize as an empty array for articles
   const [totalResults, setTotalResults] = useState(0);
   const [loading, setLoading] = useState(true); // Initial loading state
   const [page, setPage] = useState(1)

   // Capitalizing the first character of specific fields
   const capitalizeFirstChar = (string) => {
      return string.charAt(0).toUpperCase() + string.slice(1)
   }
   document.title = `${capitalizeFirstChar(props.category)} - VNews`

   let mainURl = `https://newsapi.org/v2/top-headlines?country=${props.country}&category=${props.category}&apiKey=${props.apiKey}`
   // "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=e4e19cdc690c45e5a82a414d018d5d25" 

   const fetchData = async () => {
      await props.progressBar(20)
      let url = `${mainURl}&page=${page}&pageSize=${props.pageSize}`;
      console.log(url);

      let apiData = await fetch(url)
      await props.progressBar(60)
      let parsedData = await apiData.json()
      console.log(parsedData);

      await props.progressBar(80)

      setCurrentArticles(parsedData.articles) // Store articles in state
      setLoading(false) // Set loading to false
      setTotalResults(parsedData.totalResults)

      await props.progressBar(100)
   }
   useEffect(() => {
      fetchData()
      // eslint-disable-next-line
   }, [])

   const fetchMoreData = async () => {
      let url = `${mainURl}&page=${page + 1}&pageSize=${props.pageSize}`; // Use the updated page state directly
      setPage(page + 1);
      // console.log(url);
      // console.log(page);

      let apiData = await fetch(url);
      let parsedData = await apiData.json();

      setCurrentArticles((prevArticles) => prevArticles.concat(parsedData.articles)); // Concatenate the new articles with the previous ones
      setLoading(false);
   };

   // Handle loading and error states
   if (loading) {
      return <Spinner />;
   }

   return (
      <>
         <h2 className='my-3 text-center'>VNews - Top {capitalizeFirstChar(props.category)} Headlines</h2>

         <InfiniteScroll
            dataLength={currentArticles.length}
            next={fetchMoreData}
            hasMore={currentArticles.length < totalResults}
            loader={currentArticles.length < totalResults ? <Spinner /> : null}
         >
            <div className="container">
               <div className="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
                  {/* Map through the articles and render the NewsItem component for each article */}
                  {currentArticles.map((element, index) => {
                     // Check if the title or any other field is '[Removed]'
                     if (element.title === '[Removed]' || element.description === '[Removed]' || element.author === '[Removed]') {
                        console.log('Removed News:', element);
                        return null; // Skip rendering this item
                     }

                     return (
                        <div className="col" key={`${element.url}-${index}`}>
                           <NewsItem
                              source={element.source.name ? element.source.name : ""}
                              imageURL={element.urlToImage ? element.urlToImage : " "}
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

export default News;

News.defaultProps = { // set default Props if props not pass than use this
   pageSize: 10,
   country: 'in',
   category: 'general'
}

News.propTypes = { // set props data types 
   pageSize: PropTypes.number,
   country: PropTypes.string,
   category: PropTypes.string
}