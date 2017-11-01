angular.module('webapp', []).controller('ManagerResolvedCtrl',function($scope, $http, $interval){
	$scope.MANAGERRESOLVEDBASE = "http://localhost:8082/ExpenseReimbursement/allresolved";
	getManagerResolved();
	$interval(function(){
		getManagerResolved();
	},20000);
	function getManagerResolved(){
		console.log("getting request");
		$http({
			method : "GET",
			url : $scope.MANAGERRESOLVEDBASE
		}).then(function(response){
			console.log("got request");
				$scope.managerresolved = response.data.username;
				console.log(response.data.username);
			},function(response){
				return{
					name : "ERROR",
					description : "response.data"
				}
			});
	};
});