var mongoose = require('mongoose');

module.exports = mongoose.model('Availability', {
    id : {
        type: Number,
        default: 0
    },
    status : {
    	type: Boolean,
    	default: 0
    }
});