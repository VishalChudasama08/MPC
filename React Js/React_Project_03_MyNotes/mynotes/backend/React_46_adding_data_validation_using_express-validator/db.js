const mongoose = require('mongoose');
const mongoURT = "mongodb://localhost:27017/mynotes";

const connectToMongo = async () => {
    // mongoose.connect(mongoURT, () => {
    //     console.log("Connected to Mongo Successfully");
    // })
    // The following line is commented out because Mongoose v6+ no longer accepts callbacks for the connect() method.

    // Instead, mongoose.connect() now returns a promise, so we are using async/await for better handling.

    try {
        await mongoose.connect(mongoURT);
        console.log("Connected to Mongo Successfully");
    } catch (error) {
        console.error("Failed to connect to Mongo", error);
    }
}

module.exports = connectToMongo