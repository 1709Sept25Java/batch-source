
var app = angular.module('libraryApp',['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl: 'home.html'
	})
	.otherwise({redirectTo:'/'})
})