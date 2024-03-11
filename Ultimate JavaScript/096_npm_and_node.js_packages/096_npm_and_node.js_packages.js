// first open terminal
// useing cd command go to your working folder
// in my case this is ->
// cd "Ultimate JavaScript/096_npm_and_node.js_packages"

// then, on terminal -> npm init
// then, npm init -y
// this create package.json file on sam deractriy, je file ma aa project (096_npm_and_node.js_packages folder) ni badhij detal and jeje package install karela hase te ni cammand automaticly save thay chhe jethi jya aa project ne, biji systerm ma run kar vu hoy tyare badha package te download kari aape chhe

// npm i html-pdf-node

// ahi "html-pdf-node" name na package ne install karel chhe jethi, 1k thi vadhare file "node_modules" name folder ni under bani gay, je me delet karej chhe kem ke aatlu motu foder github ma push na karvu joye...,
// and jya re aa project (096_npm_and_node.js_packages folder) ni jarur pade tyare, jyare aa project ne run kar vanu thay tyare terminal ma "npm install" cammand run karvathi jetla package ni jarur hoy te download thay jay chhe

const pdf = require('html-pdf-node');
const fs = require('fs');

// HTML content to convert to PDF
const htmlContent = `
<html>
<body>
    <h1>Hello, PDF!</h1>
    <p>This is a PDF generated from HTML using html-pdf-node module.</p>
</body>
</html>
`;

// Options for PDF generation
const options = { format: 'A4' };

// Generate PDF
pdf.generatePdf({ content: htmlContent }, options).then((pdfBuffer) => {
    // Write the PDF buffer to a file
    fs.writeFileSync('output.pdf', pdfBuffer);
    console.log('PDF generated successfully!');
}).catch((error) => {
    console.error('Error generating PDF:', error);
});

