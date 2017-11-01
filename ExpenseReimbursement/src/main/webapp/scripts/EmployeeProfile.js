angular.module('webapp').controller('EmpProfileCtrl',function($scope,$http,$interval){
	
	$scope.EMPPROFILEBASE= "http://localhost:8082/ExpenseReimbursement/employeeprofile";
	getEmpProfile();
	$interval(function(){
		getEmpProfile();
	},20000);
	function getEmpProfile(){
		console.log("getting profile");
		$http({
			method:"GET",
			url : $scope.EMPPROFILEBASE
		}).then(function(response){
			console.log("got profile");
			$scope.empProfile = response.data.username;
			console.log(response.data);
		}, function(response){
			return {
				name: "ERROR",
				description: "response.data"
			}
		});
	};
});