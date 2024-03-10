// first open terminal
// useing cd command go to your working folder
// in my case this is ->
// cd "Ultimate JavaScript"
// cd 096_npm_and_node.js_packages

// then, on terminal -> npm init
// then, npm init -y
// this create package.json file on sam deractriy, je file ma aa project (096_npm_and_node.js_packages folder) ni badhij detal and jeje package install karela hase te ni cammand automaticly save thay chhe jethi jya aa project ne, biji systerm ma run kar vu hoy tyare badha package te download kari aape chhe

// ahi "pdf-creator-node" name na package ne install karel chhe jethi, 4k thi vadhare file "node_modules" name folder ni under bani gay, je me delet karej chhe kem ke aatlu motu foder github ma push na karvu joye...,
// and jya re aa project (096_npm_and_node.js_packages folder) ni jarur pade tyare, jyare aa project ne run kar vanu thay tyare terminal ma "npm install" cammand run karvathi jetla package ni jarur hoy te download thay jay chhe

//Required package
var pdf = require("pdf-creator-node");
var fs = require("fs");

// Read HTML Template
var html = fs.readFileSync("096_npm_and_node.js_packages.html", "utf8");

var options = {
    format: "A3",
    orientation: "portrait",
    border: "10mm",
    header: {
        height: "45mm",
        contents: '<div style="text-align: center;">Author: Shyam Hajare</div>'
    },
    footer: {
        height: "28mm",
        contents: {
            first: 'Cover page',
            2: 'Second page', // Any page number is working. 1-based index
            default: '<span style="color: #444;">{{page}}</span>/<span>{{pages}}</span>', // fallback value
            last: 'Last Page'
        }
    }
};

var users = [
    {
        name: "Shyam",
        age: "26",
    },
    {
        name: "Navjot",
        age: "26",
    },
    {
        name: "Vitthal",
        age: "26",
    },
];
var document = {
    html: html,
    data: {
        users: users,
    },
    path: "./output.pdf",
    type: "",
};
// By default a file is created but you could switch between Buffer and Streams by using "buffer" or "stream" respectively.

pdf
    .create(document, options)
    .then((res) => {
        console.log(res);
    })
    .catch((error) => {
        console.error(error);
    });

