angular.module('messageService', [])

	// super simple service
	// each function returns a promise object 
	.factory('Messages', ['$http',function($http) {
		return {
			get : function() {
				return $http.get('/api/messages');
			},
			create : function(messageData) {
				return $http.post('/api/messages', messageData);
			},
			delete : function(id) {
				return $http.delete('/api/messages/' + id);
			}
		}
	}]);