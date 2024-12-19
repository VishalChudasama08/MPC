/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}", // React components
    "./node_modules/flowbite/**/*.js", // Flowbite library
  ],
  theme: {
    extend: {},
  },
  plugins: [require('flowbite/plugin')],
};
