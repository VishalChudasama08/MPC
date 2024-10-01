import logo from './logo.svg';
import './App.css';

let vishal = "Vishal";

function App() {
    return (
        // In return Block inner code is like HTML but this is JSX code 
        // and in this only one main tag return only (in this code: div). 
        // if need to return more tags than covert all tag in this tag:- <> </> like:- <> <h1>...</h1><div>...</div> </>
        // JSX it is HTML+JS in .js file, in jsx same word (that keyword in js) than name change like:- in html class attribute in "class" but in JSX class attribute is "className", and like as "for" : "htmlFor"
        // for add javascript in JSX than use {} this bracket see h2 tag   

        <>
            <p>That all inner <></> than is child tags.</p>
            <div className="App">
                <header className="App-header">
                    <h2>Hello {vishal}</h2>
                    <img src={logo} className="App-logo" alt="logo" />
                    <p>
                        Edit <code>src/App.js</code> and save to reload.
                    </p>
                    <p>I Am Vishal. and I Am Learn React</p>
                </header>
            </div>
        </>
    );
}

export default App;
