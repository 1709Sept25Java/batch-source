angular.module('webapp', []).controller('ResolvedCtrl', function($scope, $http, $interval){
	
	$scope.EMPBASE = "http://localhost:8082/ERSProject/resolved";
	getResolved();
	$interval(function(){
		getResolved();
	}, 20000);
	function getResolved(){
		console.log("getting resolved reimbursements");
		$http({
			method : "GET",
			url : $scope.EMPBASE
		}).then(function(response){
			console.log("got resolved reimbursements");
			$scope.reimbursements = response.data.reimbursements;
		}, function(response){
			return{
				name : "ERROR",
				description : "response.data"
			}
		});
	};
});
