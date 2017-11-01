angular.module('webapp', []).controller('EmployeePendingCtrl',function($scope,$http,$interval){
	
	$scope.EMPLOYEEPENDINGBASE= "http://localhost:8082/ExpenseReimbursement/employeepending";
	getEmployeePending();
	$interval(function(){
		getEmployeePending();
	},20000);
	function getEmployeePending(){
		console.log("getting employee pending");
		$http({
			method:"GET",
			url : $scope.EMPLOYEEPENDINGBASE
		}).then(function(response){
			console.log("got employee pending");
			$scope.employeepending = response.data.username;
			console.log(response.data);
		}, function(response){
			return {
				name: "ERROR",
				description: "response.data"
			}
		});
	};
});