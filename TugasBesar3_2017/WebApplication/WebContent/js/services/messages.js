angular.module('messageService', [])

	// super simple service
	// each function returns a promise object 
	.factory('Messages', ['$http',function($http) {
		return {
			get : function() {	
				return $http.get('http://localhost:8080/api/messages');
				
			},
			create : function(messageData) {
				return $http.post('http://localhost:8080/api/messages', messageData);
			},
			delete : function(id) {
				return $http.delete('http://localhost:8080/api/messages/' + id);
			}
		}
	}]);

function createCORSRequest(method, url) {
	  var xhr = new XMLHttpRequest();
	  if ("withCredentials" in xhr) {

	    // Check if the XMLHttpRequest object has a "withCredentials" property.
	    // "withCredentials" only exists on XMLHTTPRequest2 objects.
	    xhr.open(method, url, true);

	  } else if (typeof XDomainRequest != "undefined") {

	    // Otherwise, check if XDomainRequest.
	    // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
	    xhr = new XDomainRequest();
	    xhr.open(method, url);

	  } else {

	    // Otherwise, CORS is not supported by the browser.
	    xhr = null;

	  }
	  return xhr;
	}