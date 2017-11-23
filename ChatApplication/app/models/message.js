var mongoose = require('mongoose');

module.exports = mongoose.model('Message', {
    text: {
        type: String,
        default: ''
    }
});