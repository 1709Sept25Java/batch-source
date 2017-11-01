angular.module('webapp', []).controller('EmployeeResolvedCtrl',function($scope,$http,$interval){
	
	$scope.EMPLOYEERESOLVEDBASE= "http://localhost:8082/ExpenseReimbursement/employeeresolved";
	getEmployeeResolved();
	$interval(function(){
		getEmployeeResolved();
	},20000);
	function getEmployeeResolved(){
		console.log("getting employee resolved");
		$http({
			method:"GET",
			url : $scope.EMPLOYEERESOLVEDBASE
		}).then(function(response){
			console.log("got employee resolved");
			$scope.employeeresolved = response.data.username;
			console.log(response.data);
		}, function(response){
			return {
				name: "ERROR",
				description: "response.data"
			}
		});
	};
});