var app = angular.module('HelloWorldApp', []);
app.controller('ColorCtrl', function($scope) {
	$scope.myColor = '#476abe';
});
app.controller('DivisionCtrl', function($scope) {
	$scope.data;// = {number:0,divisor:0,result:0};
	$scope.divisionNeeded = function() {
		$scope.data.result = $scope.data.number / $scope.data.divisor;
	};
});

app.filter('myFormat',function(){
	return function(x){
		var i, c, txt="";
		for (i=0; i<x.length;i++){
			c = x[i];
			if (i%2==0){
				c = c.toUpperCase();
			}
			txt += c;
		}
		return txt;
	}
})
app.controller('ServiceCtrl',function($scope,$location,$interval){
	$scope.myUrl = $location.absUrl();
	$scope.theTime = new Date().toLocaleTimeString();
	$interval(function(){
		$scope.theTime = new Date().toLocaleTimeString();
	})
});
app.directive('myDirective',function(){
	return{
		//default invocation forms: EA
		restrict: "EAC",
		template: '<h3>Made by a directive!</h3>'
	};
});
/*
app.directive('div',function(){
	return{
		template: '<h3> definitely not a div </h3>'
	}
})*/