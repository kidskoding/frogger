const express = require('express');
const dotenv = require('dotenv');
const port = 3000;

const app = express();

dotenv.config();
app.set('view engine', 'ejs');
app.set('views', './views');

app.get('/', function(req, res) {
    const apiUrl = process.env.FROGGER_URL;
    if(!apiUrl) {
        throw Error("Could not get URL of the game. Check URL in the .env file");
    }
    res.render('index', { apiUrl });
});

app.listen(3000, function() {
    console.log('Server is running on port', port);
});