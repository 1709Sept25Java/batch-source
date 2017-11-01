angular.module('webapp', []).controller('ShowEmpCtrl', function($scope, $http, $interval){
	
	$scope.EMPBASE = "http://localhost:8082/ERSProject/empShow";
	getPending();
	$interval(function(){
		getPending();
	}, 20000);
	function getPending(){
		console.log("getting pending reimbursements");
		$http({
			method : "GET",
			url : $scope.EMPBASE
		}).then(function(response){
			console.log("got pending reimbursements");
			$scope.reimbursements = response.data.reimbursements;
		}, function(response){
			return{
				name : "ERROR",
				description : "response.data"
			}
		});
	};
});
