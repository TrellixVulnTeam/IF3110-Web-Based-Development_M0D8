var mongoose = require('mongoose');

module.exports = mongoose.model('Message', {
    text: {
        type: String,
        default: ''
    },
    from: {
    	type:Number,
    	default: 0
    },
    to: {
    	type:Number,
    	default: 0
    }
});