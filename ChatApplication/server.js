// set up ======================================================================
var express = require('express');
var app = express(); 						// create our app w/ express
var mongoose = require('mongoose'); 				// mongoose for mongodb
var port = process.env.PORT || 8080; 				// set the port
var database = require('./config/database'); 			// load the database config
var morgan = require('morgan');
var bodyParser = require('body-parser');
var methodOverride = require('method-override');
var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;
var admin = require("firebase-admin");
var serviceAccount = require("C:\\data\\serviceAccountKey.json");
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://tubes-wbd-3-95397.firebaseio.com"
});

// configuration ===============================================================
mongoose.connect(database.localUrl); 	// Connect to local MongoDB instance. A remoteUrl is also available (modulus.io)

app.use(express.static('./public')); 		// set the static files location /public/img will be /img for users
app.use(morgan('dev')); // log every request to the console
app.use(bodyParser.urlencoded({'extended': 'true'})); // parse application/x-www-form-urlencoded
app.use(bodyParser.json()); // parse application/json
app.use(bodyParser.json({type: 'application/vnd.api+json'})); // parse application/vnd.api+json as json
app.use(methodOverride('X-HTTP-Method-Override')); // override with the X-HTTP-Method-Override header in the request

// Set CORS header and intercept "OPTIONS" preflight call from AngularJS
var allowCrossDomain = function(req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type, Accept');
    res.header("Access-Control-Max-Age", "1728000");
    if (req.method === "OPTIONS") 
        res.sendStatus(200);
    else 
        next();
}

var id_customer, id_driver;
var token_customer, token_driver;
var Message = require('./app/models/message');

function getMessages(res) {
    Message.find(function (err, messages) {

        // if there is an error retrieving, send the error. nothing after res.send(err) will execute
        if (err) {
            res.send(err);
        }

        res.json(messages); // return all messages in JSON format
    });
};

app.post('/sendInfoFromCustomer', function(req, res) {
	// initialize id_customer and token_customer
	console.log(req.body.id + " as user with id: ");
	console.log(req.body.token);
	console.log();
	
	id_customer = req.body.id;
	token_customer = req.body.token;
	
	//if (token_driver != null){
	//	sendInfo(id_customer, token_driver, 'Sulliy1');	
	//}
	res.end();
});

app.post('/sendInfoFromDriver', function(req, res) {
	// initialize id_driver and token_driver
	console.log(req.body.id + " as driver with id: ");
	console.log(req.body.token);
	console.log();
	
	id_driver = req.body.id;
	token_driver = req.body.token;
	
	sendInfo(id_customer, token_driver, 'Sulliy');	
	res.end();
});

app.post('/sendMessageFromCustomer', function(req, res) {
	// var message = req. 
	// put message in mongodb, with attribute from_customer = true
	// send message to firebase with sendMessage(id_customer, token_driver, message)
	console.log(req.body.from + " as user writes: ");
	console.log(req.body.message);
	console.log("to: " + req.body.to);
	console.log();
	
	// create a message, information comes from AJAX request from Angular
    Message.create({
        text: req.body.message,
        from: req.body.from,
        to: req.body.to,
        done: false
    }, function (err, message) {
        if (err)
            res.send(err);

        // get and return all the messages after you create another
        getMessages(res);
    });
    
});


app.post('/sendMessageFromDriver', function(req, res) {
	// var message = req. 
	// put message in mongodb, with attribute from_customer = false
	// send message to firebase with sendMessage(id_driver, token_customer, message)
	console.log(req.body.from + " as driver writes: ");
	console.log(req.body.message);
	console.log("to: " + req.body.to);
	console.log();
	
	// create a message, information comes from AJAX request from Angular
    Message.create({
        text: req.body.message,
        from: req.body.from,
        to: req.body.to,
        done: false
    }, function (err, message) {
        if (err)
            res.send(err);

        // get and return all the messages after you create another
        getMessages(res);
    });
	
});

function sendMessage(idSender, tokenReceiver, messageContent){
	 
	  /*$.ajax({        
	            type : 'POST',
	            crossDomain: true,
	            url : "https://fcm.googleapis.com/fcm/send",
	            headers : {
	                Authorization : 'key=AAAAoOcdVKQ:APA91bHKeEkg_Uhu2VIkmuVJVats98jm3mQ5F3Wa7BJWpAg8svx4yDFAPFvE-czb_fOtej4Kq-oTnm5_Y6vK0_gRRiEgrv4EVcDrFCiqnUtlNDmSkc0W2fze6cpBAqse0p_cxt46LCdM'
	            },
	            beforeSend: function (xhrObj) {
	                xhrObj.setRequestHeader("Content-Type", "application/json");
	            },
	            contentType : 'application/json',
	            dataType: 'json',
	            data: JSON.stringify({to:tokenReceiver, data: {type:"message", id_sender:idSender, content:messageContent}}),
	            success : function(response) {
	                console.log("success: " + response);
	            },
	            error : function(xhr, status, error) {
	                console.log("error: " + xhr.error);                   
	            }
	  });*/
}

function sendInfo(idSender, tokenReceiver, usernameSender){
	 
	console.log("Sending info with: id=" + idSender + ", username=" + usernameSender + ", tokenReceiver=" + tokenReceiver);
	
	// This registration token comes from the client FCM SDKs.
	var registrationToken = tokenReceiver;

	// See the "Defining the message payload" section below for details
	// on how to define a message payload.
	var payload = {
			notification: {
			    title: "aaa",
			    body: "bbb"
			  },
	  data: {
		type: "info",
	    id_sender: idSender,
	    username_sender: usernameSender
	  }
	};

	// Send a message to the device corresponding to the provided
	// registration token.
	admin.messaging().sendToDevice(registrationToken, payload)
	  .then(function(response) {
	    // See the MessagingDevicesResponse reference documentation for
	    // the contents of response.
	    console.log("Successfully sent message:", response);
	  })
	  .catch(function(error) {
	    console.log("Error sending message:", error);
	  });
	
}

// routes ======================================================================
require('./app/routes.js')(app);

// use allowCrossDomain
app.use(allowCrossDomain);

// listen (start app with node server.js) ======================================
app.listen(port);
console.log("App listening on port " + port);
