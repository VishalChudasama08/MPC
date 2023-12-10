let url = "https://isro.vercel.app/api/customer_satellites";
let respo = fetch(url); //run url and fetch data on respo variable

respo.then((v) => {
    return v.json(); //using json to return promise object data
}).then((contests) => {
    console.log(contests); // showing all data on console in object in array 
    ihtml = "vishal"; // initialize string variable
    for (item in contests) {
        console.log(contests[item]);
        ihtml += `
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${contests[item].id}</h5>
                <p class="card-text">${contests[item].country}</p>
                <p class="card-text">${contests[item].launch_date}</p>
                <p class="card-text">${contests[item].mass}</p>
                <p class="card-text">${contests[item].launcher}</p>
            </div>
            </div>`;
        // console.log(data[id]);
        let cardcontainer = document.getElementById(cardcontainer);
        cardcontainer.innerHTML = ihtml;
    }
});

cardcontainer.innerHTML = "<h1>This program is not working 🤬🤬🤬</h1>"

