angular.module('webapp', []).controller('EmpPendingCtrl', function($scope, $http, $interval){
	
	$scope.EMPBASE = "http://localhost:8082/ERSProject/empPending";
	getEmpPending();
	$interval(function(){
		getEmpPending();
	}, 20000);
	function getEmpPending(){
		console.log("getting pending reimbursements for employee");
		$http({
			method : "GET",
			url : $scope.EMPBASE
		}).then(function(response){
			console.log("got pending reimbursements for employee");
			$scope.reimbursements = response.data.reimbursements;
		}, function(response){
			return{
				name : "ERROR",
				description : "response.data"
			}
		});
	};
});
