angular.module('webapp', []).controller('ManagerEmployeesCtrl', function($scope, $http, $interval){
	$scope.MANAGEREMPLOYEEBASE="http://localhost:8082/ExpenseReimbursement/allemployees";
	getAllEmployees();
	$interval(function(){
		getAllEmployees();
	},20000);
	function getAllEmployees(){
		console.log("getting employees");
		$http({
			method : "GET",
			url : $scope.MANAGEREMPLOYEEBASE
		}).then(function(response){
			console.log("got employees");
			$scope.allemployees = response.data.users;
			console.log(response.data)
		},function(response){
			return{
				name : "ERROR",
				description : "response.data"
			}
		});
	};
});