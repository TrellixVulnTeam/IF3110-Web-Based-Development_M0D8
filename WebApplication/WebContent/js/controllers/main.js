angular.module('messageController', [])

	// inject the Message service factory into our controller
	.controller('mainController', ['$scope','$http','Messages', function($scope, $http, Messages) {
		$scope.formData = {};
		$scope.loading = true;

		// GET =====================================================================
		// when landing on the page, get all messages and show them
		// use the service to get all the messages
		Messages.get()
			.success(function(data) {
				$scope.messages = data;
				$scope.loading = false;
			});
		
		$scope.getMessage = function() {
			Messages.get()
			.success(function(data) {
				$scope.messages = data;
				$scope.loading = false;
			});
		};

		// CREATE ==================================================================
		// when submitting the add form, send the text to the node API
		$scope.createMessage = function(from,to) {

			// validate the formData to make sure that something is there
			// if form is empty, nothing will happen
			if ($scope.formData.text != undefined) {
				$scope.loading = true;

				$scope.formData.from = from;
				$scope.formData.to = to;
				// call the create function from our service (returns a promise object)
				Messages.create($scope.formData)

					// if successful creation, call our get function to get all the new messages
					.success(function(data) {
						$scope.loading = false;
						$scope.formData = {}; // clear the form so our user is ready to enter another
						$scope.messages = data; // assign our new list of messages
					});
			}
		};

		// DELETE ==================================================================
		// delete a message after checking it
		$scope.deleteMessage = function(id) {
			$scope.loading = true;

			Messages.delete(id)
				// if successful creation, call our get function to get all the new messages
				.success(function(data) {
					$scope.loading = false;
					$scope.messages = data; // assign our new list of messages
				});
		};
	}]);