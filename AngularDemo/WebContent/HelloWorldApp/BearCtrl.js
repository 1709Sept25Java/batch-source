angular.module('HelloWorldApp').controller('BearCtrl', function($scope, $http, $interval) {
	/*
	 * $http.get('bears.json').then(function(response) { $scope.bears =
	 * response.data.bears; });
	 * 
	 */
	
	$scope.BEARBASE = "http://localhost:8082/FrontControllerDemo/bear";
	getBears();
	$interval(function() {
		getBears();
	}, 20000);
	function getBears() {
		console.log("getting bears");
		$http({
			method : "GET",
			url : $scope.BEARBASE
		}).then(function(response) {
			console.log("got bears");
			$scope.bears = response.data.bears;
		}, function(response) {
			return {
				name : "ERROR",
				description : "response.data"
			}
		});
	};
	$scope.addBear = function(){
		if($scope.newBearName){
			$http({
				method:'POST',
				url: $scope.BEARBASE,
				data: {"name":$scope.newBearName}
			});
			$scope.inputStyle={'background-color':'white'};
		} else {
			$scope.inputStyle={'background-color':'red'};
		}
	};
});