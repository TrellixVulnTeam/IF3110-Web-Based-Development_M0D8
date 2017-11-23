var Message = require('./models/message');

function getMessages(res) {
    Message.find(function (err, messages) {

        // if there is an error retrieving, send the error. nothing after res.send(err) will execute
        if (err) {
            res.send(err);
        }

        res.json(messages); // return all messages in JSON format
    });
};

module.exports = function (app) {

    // api ---------------------------------------------------------------------
    // get all messages
    app.get('/api/messages', function (req, res) {
        // use mongoose to get all messages in the database
        getMessages(res);
    });

    // create message and send back all messages after creation
    app.post('/api/messages', function (req, res) {

        // create a message, information comes from AJAX request from Angular
        Message.create({
            text: req.body.text,
            done: false
        }, function (err, message) {
            if (err)
                res.send(err);

            // get and return all the messages after you create another
            getMessages(res);
        });

    });

    // delete a message
    app.delete('/api/messages/:message_id', function (req, res) {
        Message.remove({
            _id: req.params.message_id
        }, function (err, message) {
            if (err)
                res.send(err);

            getMessages(res);
        });
    });

    // application -------------------------------------------------------------
    app.get('*', function (req, res) {
        res.sendFile(__dirname + '/public/index.html'); // load the single view file (angular will handle the page changes on the front-end)
    });
};
