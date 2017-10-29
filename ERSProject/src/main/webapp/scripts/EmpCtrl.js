angular.module('webapp', []).controller('EmpCtrl', function($scope, $http, $interval){
	
	$scope.EMPBASE = "http://localhost:8082/ERSProject/emp";
	getEmployees();
	$interval(function(){
		getEmployees();
	}, 20000);
	function getEmployees(){
		console.log("getting employees");
		$http({
			method : "GET",
			url : $scope.EMPBASE
		}).then(function(response){
			console.log("got employees");
			$scope.employees = response.data.employees;
		}, function(response){
			return{
				name : "ERROR",
				description : "response.data"
			}
		});
	};
});
