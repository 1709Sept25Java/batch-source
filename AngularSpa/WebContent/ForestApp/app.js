
var app = angular.module('forestApp',['ngRoute']); //create module, pass in dependency

app.config(function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl:'home.html'
	})
	.when('/animals',{
		templateUrl: 'animal/animalView.html',
		controller: 'AnimalCtrl'
	})
	.when('/landscape',{
		templateUrl: 'landscape/landscapeView.html',
		controller: 'GroundCtrl'
	})
	.otherwise({redirectTo:'/'});
});

app.factory('dataFactory',['$http',function($http){
	var urlBase="http://localhost:8082/RestServiceDemo";
	var dataFactory={};
	dataFactory.getBears = function(){
		return $http.get(urlBase+'/bear/all')
	}
	return dataFactory;
}])

app.service('dataService',['$http',function($http){
	var urlBase="http://localhost:8082/RestServiceDemo";
	this.getBears = function(){
		return $http.get(urlBase+'/bear/all');
	};
}])