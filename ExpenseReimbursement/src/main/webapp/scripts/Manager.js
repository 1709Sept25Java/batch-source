angular.module('webapp').controller('ProfileCtrl',function($scope,$http,$interval){
	
	$scope.PROFILEBASE= "http://localhost:8082/ExpenseReimbursement/profilelist";
	getProfile();
	$interval(function(){
		getProfile();
	},20000);
	function getProfile(){
		console.log("getting profile");
		$http({
			method:"GET",
			url : $scope.PROFILEBASE
		}).then(function(response){
			console.log("got profile");
			$scope.profile = response.data.username;
			console.log(response.data);
		}, function(response){
			return {
				name: "ERROR",
				description: "response.data"
			}
		});
	};
});