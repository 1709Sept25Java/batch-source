angular.module('forestApp').controller('AnimalCtrl',
		['$scope','$interval','$dataFactory',
			function($scope,$interval,$dataFactory){
				$scope.bears;
				getBears();
				function getBears(){
					dataFactory.getBears()
					.then(function(response){
						$scope.bears = response.data;
						console.log("it worked!");
					}, function(error){
						console.log("oh no!");
					});
				}
		}]);