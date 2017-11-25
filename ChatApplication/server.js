// set up ======================================================================
var express = require('express');
var firebase = require("firebase");
var app = express(); 						// create our app w/ express
var mongoose = require('mongoose'); 				// mongoose for mongodb
var port = process.env.PORT || 8080; 				// set the port
var database = require('./config/database'); 			// load the database config
var morgan = require('morgan');
var bodyParser = require('body-parser');
var methodOverride = require('method-override');

// configuration ===============================================================
mongoose.connect(database.localUrl); 	// Connect to local MongoDB instance. A remoteUrl is also available (modulus.io)

app.use(express.static('./public')); 		// set the static files location /public/img will be /img for users
app.use(morgan('dev')); // log every request to the console
app.use(bodyParser.urlencoded({'extended': 'true'})); // parse application/x-www-form-urlencoded
app.use(bodyParser.json()); // parse application/json
app.use(bodyParser.json({type: 'application/vnd.api+json'})); // parse application/vnd.api+json as json
app.use(methodOverride('X-HTTP-Method-Override')); // override with the X-HTTP-Method-Override header in the request

// Firebase Config
var config = {
	apiKey: "AIzaSyB5rXXTdwUqnTTdaONDxfj845PgYD54384",
	authDomain: "tubes-wbd-3-95397.firebaseapp.com",
	databaseURL: "https://tubes-wbd-3-95397.firebaseio.com",
	projectId: "tubes-wbd-3-95397",
	storageBucket: "tubes-wbd-3-95397.appspot.com",
	messagingSenderId: "691072226468"
};
 firebase.initializeApp(config);

// Set CORS header and intercept "OPTIONS" preflight call from AngularJS
/*var allowCrossDomain = function(req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type, Accept');
    res.header("Access-Control-Max-Age", "1728000");
    if (req.method === "OPTIONS") 
        res.sendStatus(200);
    else 
        next();
}*/

var id_customer, id_driver;
var token_customer, token_driver;

app.post('/sendTokenFromCustomer', function(req, res) {
	// initialize id_customer and token_customer
	console.log(req.body.id + " with id: ");
	console.log(req.body.token);
	console.log();
	
});

app.post('/sendTokenFromDriver', function(req, res) {
	// initialize id_driver and token_driver
});

app.post('/sendMessageFromCustomer', function(req, res) {
	// var message = req. 
	// put message in mongodb, with attribute from_customer = true
	// send message to firebase with sendMessage(id_customer, token_driver, message)
	console.log(req.body.id + " writes: ");
	console.log(req.body.message);
	console.log();
});


app.post('/sendMessageFromDriver', function(req, res) {
	// var message = req. 
	// put message in mongodb, with attribute from_customer = false
	// send message to firebase with sendMessage(id_driver, token_customer, message)
});

/* 
// Send message with FCM
// Masih bermasalah karena Cross-Origin Request Blocked dan preflight
function sendMessage(idSender, tokenReceiver, messageContent){
	 
	  $.ajax({        
	            type : 'POST',
	            crossDomain: true,
	            url : "https://fcm.googleapis.com/fcm/send",
	            headers : {
	                Authorization : 'key=AAAAoOcdVKQ:APA91bHKeEkg_Uhu2VIkmuVJVats98jm3mQ5F3Wa7BJWpAg8svx4yDFAPFvE-czb_fOtej4Kq-oTnm5_Y6vK0_gRRiEgrv4EVcDrFCiqnUtlNDmSkc0W2fze6cpBAqse0p_cxt46LCdM'
	            },
	            beforeSend: function (xhrObj) {
	                xhrObj.setRequestHeader("Content-Type", "application/json");
	            },
	            //contentType : 'application/json',
	            dataType: 'json',
	            data: JSON.stringify({to:tokenReceiver, data: {type:"message", id_sender:idSender, content:messageContent}}),
	            success : function(response) {
	                console.log("success: " + response);
	            },
	            error : function(xhr, status, error) {
	                console.log("error: " + xhr.error);                   
	            }
	  });
}

}*/

// routes ======================================================================
require('./app/routes.js')(app);

// use allowCrossDomain
//app.use(allowCrossDomain);

// listen (start app with node server.js) ======================================
app.listen(port);
console.log("App listening on port " + port);
