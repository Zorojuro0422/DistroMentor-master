const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const app = express();
const PORT = process.env.PORT || 3002;

// MongoDB connection
mongoose.connect('mongodb+srv://backendAcct:backend123@distributorsystem.hnskupd.mongodb.net/DistriLink', {
    useNewUrlParser: true,
    useUnifiedTopology: true
});

const db = mongoose.connection;

db.on('error', console.error.bind(console, 'MongoDB connection error:'));
db.once('open', () => {
    console.log('Connected to MongoDB');
});

// User schema
const userSchema = new mongoose.Schema({
    username: String,
    password: String,
    role: String
});

const User = mongoose.model('User', userSchema);

// Middleware
app.use(bodyParser.json());

// Routes
app.post('/signin', async (req, res) => {
    const { username, password } = req.body;

    try {
        const user = await User.findOne({ username, password }).exec();

        if (user) {
            const result = {
                tableName: user.role,
                userId: user._id,
                username: user.username
            };
            res.status(200).json(result);
        } else {
            res.status(401).json({ error: 'Invalid username or password' });
        }
    } catch (error) {
        console.error('Error during authentication:', error);
        res.status(500).json({ error: 'An error occurred during authentication' });
    }
});

// Start the server
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
