// ga boleh dipindahin maupun diapus
importScripts('https://www.gstatic.com/firebasejs/4.6.2/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/4.6.2/firebase-messaging.js');

var config = {
	    apiKey: "AIzaSyB5rXXTdwUqnTTdaONDxfj845PgYD54384",
	    authDomain: "tubes-wbd-3-95397.firebaseapp.com",
	    databaseURL: "https://tubes-wbd-3-95397.firebaseio.com",
	    projectId: "tubes-wbd-3-95397",
	    storageBucket: "tubes-wbd-3-95397.appspot.com",
	    messagingSenderId: "691072226468"
	  };
	  firebase.initializeApp(config);


const messaging = firebase.messaging();