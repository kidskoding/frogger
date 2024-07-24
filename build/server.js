const express = require('express');
const dotenv = require('dotenv');
const path = require('path');

dotenv.config();
const app = express();
const port = 3000;

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

app.use(express.static(path.join(__dirname, '/public/')));

app.get('/', async (req, res) => {
    try {
        const froggerUrl = process.env.FROGGER_URL;
        if (!froggerUrl) {
            throw new Error("Game URL is not defined. Cannot load game");
        }

        res.render('index', { froggerUrl });
    } catch (error) {
        console.error('Error fetching game data:', error);
        res.status(500).json({ error: 'Failed to fetch game data' });
    }
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});