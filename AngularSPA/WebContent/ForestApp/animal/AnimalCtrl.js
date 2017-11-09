angular.module('forestApp').controller(
		'AnimalCtrl',
		[ '$scope', '$interval', 'dataFactory',
				function($scope, $interval, dataFactory) {
					$scope.bears;
					$scope.bats;
					getBears();
					getBats();
					function getBears() {
						dataFactory.getBears().then(function(response) {
							$scope.bears = response.data;
							console.log("it worked");
						}, function(error) {
							console.log("oh no!");
						});
					}
					function getBats() {
						dataFactory.getBats().then(function(response) {
							$scope.bats = response.data;
							console.log("it worked");
						}, function(error) {
							console.log("oh no!");
						});
					}
					
					//we'd want to use $interval to refresh list periodically 
				} ]);