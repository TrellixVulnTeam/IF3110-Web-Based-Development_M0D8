<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="completeProxy" scope="request" class="com.services.UserServiceProxy" />
<%
	completeProxy.setEndpoint("http://localhost:8000/WebService/User");
	int id = Integer.parseInt(request.getParameter("id_customer"));
	com.services.User user = completeProxy.getUserWithoutValidation(id);
	
%>   

<%
    String mytoken = "";
    Cookie[] mycookies = request.getCookies();
    if (mycookies != null) {
        for (int i = 0; i < mycookies.length; ++i) {
        	if (mycookies[i].getName().equals("token")) {
        		mytoken = mycookies[i].getValue();
        			break;
        	}
        }
    }
%>
<jsp:useBean id="profileProxy" scope="request" class="com.services.UserServiceProxy" />
<%
	profileProxy.setEndpoint("http://localhost:8000/WebService/User");
	String idStr = request.getParameter("id_active");
	int idA = Integer.parseInt(idStr);
	
	com.services.User userV = null;
	String redirect = "";
	try{
		userV = profileProxy.getUser(mytoken, idA);
	} catch (com.services.TokenException tex) {
		redirect = "LogoutServlet?id=" + request.getParameter("id_active") + "&e=" + profileProxy.getValidation(mytoken, Integer.parseInt(request.getParameter("id_active")));
		userV = new com.services.User();
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="swtMessage">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Order</title>
	<link rel="icon" href="img/icon.png" />
	<link rel="stylesheet" href="css/style.css">
	
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script><!-- load angular -->

	<script src="js/controllers/main.js"></script> <!-- load up our controller -->
	<script src="js/services/messages.js"></script> <!-- load our message service -->
	<script src="js/core.js"></script> <!-- load our main application -->
	
</head>
<body ng-controller="mainController">
  	<div id="navbar">
	  <%@ include file="Navbar.jsp" %>
	  <div class="after-box">
	    <div class="centered">
	      <a href="Order.jsp?id_active=<%= request.getParameter("id_active") %>" class="active-order">ORDER</a>
	      <a href="Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>" class="list-item-history">HISTORY</a>
	      <a href="Profile.jsp?id_active=<%= request.getParameter("id_active") %>" class="list-item-profile">MY PROFILE</a>
	    </div>
	  </div>
	</div>
	
	<%
		// TODO: check if still finding order, having order, etc
		//if (userNavbar.isDriver()){  
		//	response.sendRedirect("Findorder.jsp?id_active=" + request.getParameter("id_active"));
		//}
	%>
    
    <div id="order-header">
	  <div class="floating-box-left-chat" >LOOKING FOR AN ORDER</div>
	</div>
	
	<div id="order-chat-driver">
		<div class="ordergot">Got an Order!</div>
		<div class="ordername"><%= user.getUsername()%><br></div>
	  <div class="chatbox">
		<div ng-repeat="message in messages">
		  	<div ng-if="message.from == ('<%=request.getParameter("id_customer") %>') && message.to == ('<%=request.getParameter("id_active") %>')">
		  		<div class="messageholder">
			  		<div class="messagechat">
							<label> {{ message.text }} </label>
					</div>
				</div>
			</div>
			<div ng-if="message.from == ('<%=request.getParameter("id_active") %>') && message.to == ('<%=request.getParameter("id_customer") %>')">
				<div class="messageholder">
					<div class="messagechat2">
							<label> {{ message.text }} </label>
					</div>
				</div>
			</div>
	  		
		</div>
		</div>
		<form class="inputform">
		<input type="text" id="msg" name="msg" class="inputbox" ng-model="formData.text ">
		<button type="submit" class="send" id="send" name="send" ng-click="createMessage(<%= request.getParameter("id_active") %>,<%= request.getParameter("id_customer") %>)">Kirim</button>
		</form>	
	</div>
</body>

<%
out.println("<script>id = " + request.getParameter("id_active") + "</script>");
out.println("<script>id2 = " + request.getParameter("id_customer") + "</script>");
%>

<script src="https://www.gstatic.com/firebasejs/4.6.2/firebase.js"></script>
<script src="https://www.gstatic.com/firebasejs/4.6.2/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/4.6.2/firebase-messaging.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="https://cdn.rawgit.com/mgalante/jquery.redirect/master/jquery.redirect.js"></script>

<script>
  // Initialize Firebase
  var mytoken; 
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
  if ('serviceWorker' in navigator) {
	  navigator.serviceWorker.register('firebase-messaging-sw.js')
	  .then(function(reg) {
	    // registration worked
	    console.log('Registration succeeded. Scope is ' + reg.scope);
	    messaging.useServiceWorker(reg);
	    sendInfoToServer();
	  }).catch(function(error) {
	    // registration failed
	    console.log('Registration failed with ' + error);
	  });
  }
  
  messaging.requestPermission()
  .then(function() {
    console.log('Notification permission granted.');
  })
  .catch(function(err) {
    console.log('Unable to get permission to notify.', err);
  });
  
  // handle when client get message from firebase
  messaging.onMessage(function(payload) {
	  console.log("Message received. ", payload);
	  if (payload.data.type == "message") {
		  var recvId = payload.data.id_sender;
		  var recvMessage = payload.data.content;
		  console.log(recvId + " " + recvMessage);
		  // use angularjs to update UI
	  } else { // if (payload.data.type == "info")
		  // only for driver
		  var recvId = payload.data.id_sender;
		  var recvUsername = payload.data.username_sender;
		  console.log(recvId + " " + recvUsername);
	  }
  });
  
  // Call sendTokenToServer
  
  /////////////////////// functions
  
  function sendInfoToServer(){
	  messaging.requestPermission()
	  .then(function(){
	    console.log('Getting Token');
	    return messaging.getToken()
	  .then(function(currentToken) {
		mytoken = currentToken;
	    console.log(mytoken);
	    
	    // TODO: create ajax post request to server here
	    // action="http://localhost:8080/sendTokenFromCustomer" method="POST" 
	    // to send id_customer and token
	    
	    // should be called first when page has loaded
	    
	    $.ajax({        
            type : 'POST',
            url : "http://localhost:8080/sendInfoFromDriver",
            //contentType : 'application/json',
            //dataType: 'json',
            data: {token: mytoken, id: id}
            /*success : function(response) {
                console.log("success: " + response);
        	    alert('request done. success response received.');
            },
            error : function(xhr, status, error) {
                console.log("error: " + xhr.error);                   
        	    alert('request failed. error response received.');
            }*/
  		});
	   
	    
	  })
	  .catch(function(err) {
	    console.log('An error occurred while retrieving token. ', err);
	  });

	  }).catch(function(err){
	    console.log('Error');
	  });
  }
  
  function sendMessageToServer(){
	  msg = document.getElementById("msg").value;
	    
	  // TODO: create ajax post request to server here to send id_customer and message
	  // action="http://localhost:8080/sendMessageFromCustomer" method="POST" 
	  // should be called after sendTokenToServer called
	  
	  $.ajax({        
          type : 'POST',
          url : "http://localhost:8080/sendMessageFromDriver",
          //contentType : 'application/json',
          //dataType: 'json',
          data: {message: msg, from: id, to: id2}
          /*success : function(response) {
              console.log("success: " + response);
      	    alert('request done. success response received.');
          },
          error : function(xhr, status, error) {
              console.log("error: " + xhr.error);                   
      	    alert('request failed. error response received.');
          }*/
		});

  }
</script>
</html>

<script>
	cancelled = false;
	callout = function () {
			$.ajax({      
                 type : 'POST',
                 url : "http://localhost:8080/api/avals/customer",
                 //contentType : 'application/json',
                 //dataType: 'json',
                 data: {id:id},
                 success : function(response) {
                     if (response == "0") {
                     	$.redirect('Findorder.jsp?id_active=' + id);
                     	//window.location = ('driver_chat.jsp?id_active=' + id, {'id_customer': response});
                     } else {
                    	 angular.element(document.body).scope().getMessage();
                     }
                 }
       		})
	  		.always(function() {
	  			setTimeout(callout, 2000);
	  		});
	};

	callout();
</script>

<%
	if (redirect != "") {
		response.sendRedirect(redirect);
	}
%>