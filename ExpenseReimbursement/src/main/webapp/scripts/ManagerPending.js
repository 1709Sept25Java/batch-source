angular.module('webapp', []).controller('ManagerPendingCtrl',function($scope, $http, $interval) {
	
			$scope.MANAGERPENDINGBASE = "http://localhost:8082/ExpenseReimbursement/allpending";
			getManagerPending();
			$interval(function() {
				getManagerPending();
			}, 20000);
			function getManagerPending() {
				console.log("getting all pending for manager");
				$http({
					method : "GET",
					url : $scope.MANAGERPENDINGBASE
				}).then(function(response) {
					console.log("got all pending for manager");
					$scope.managerpending = response.data.username;
					console.log(response.data)
				}, function(response) {
					return {
						name : "ERROR",
						description : "response.data"
					}
				});
			};
		});