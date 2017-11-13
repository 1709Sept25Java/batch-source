angular.module('bookstore').controller(
		'GroundCtrl',
		[ '$scope', '$interval', 'dataService',
				function($scope, $interval, dataService) {
					$scope.caves;
					$scope.beehives;
					getCaves();
					getBeehives();
					function getCaves() {
						dataService.getCaves().then(function(response) {
							$scope.caves = response.data;
							console.log("it worked");
						}, function(error) {
							console.log("oh no!");
						});
					}
					function getBeehives() {
						dataService.getBeehives().then(function(response) {
							$scope.beehives = response.data;
							console.log("it worked");
						}, function(error) {
							console.log("oh no!");
						});
					}
				} ]);