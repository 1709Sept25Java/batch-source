angular.module('webapp', []).controller('EmpResolvedCtrl', function($scope, $http, $interval){
	
	$scope.EMPBASE = "http://localhost:8082/ERSProject/empResolved";
	getEmpResolved();
	$interval(function(){
		getEmpResolved();
	}, 20000);
	function getEmpResolved(){
		console.log("getting resolved reimbursements for employee");
		$http({
			method : "GET",
			url : $scope.EMPBASE
		}).then(function(response){
			console.log("got resolved reimbursements for employee");
			$scope.reimbursements = response.data.reimbursements;
		}, function(response){
			return{
				name : "ERROR",
				description : "response.data"
			}
		});
	};
});
