var app = angular.module('HelloWorldApp',[]);
app.controller('ColorCtrl',function($scope){
	$scope.myColor = '#476abe';
});

app.controller('DivisionCtrl', function($scope){
	
	 $scope.data = {number:0,result:0};
	 $scope.divisionNeeded = function() {
		$scope.data.result = $scope.data.number/$scope.data.divisor; 
		 
	 };
});
app.controller('BearCtrl', function($scope, $http){
			
		$http.get('bears.json').then(function(response){
			$scope.bears=response.data.bears;
			
		});
	});
app.filter('myFormat', function(){
	return function(x){
		var i, c, txt="";
		for (i=0; i<x.length; i+=){
			c=x[i];
			if (i%2==0){
				c=c.toUpperCase();
			}
			txt +=c; }
		return txt; }
});
app.directive('myDirective', 
