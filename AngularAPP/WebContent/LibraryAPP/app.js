var app=angular.module('LibraryAPP',['ngRoute']);
app.config(function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl:'home.html'
	})
	.when('/author',{
		templateUrl:'Author/authorView.html',
		controller:'AuthorCtrl'
	})
	.when('/book',{
		templateUrl:'Book/bookView.html',
		controller:'BookCtrl'
	})
	.otherwise({redirectTo:'/'});
});
app.factory('dataFactory',['$http',function($http){
	var urlBase='http://localhost:8084';
	var dataFactory={};
	dataFactory.getAuthor = function(){
		return $http.get(urlBase+'/author/all');
	};
	dataFactory.newAuthor = function(){
		return $http.post(urlBase+'/author/new',JSON.stringify(author));
	};
	dataFactory.getBook = function(){
		return $http.get(urlBase+'/book/all');
	};
	dataFactory.newBook = function(){
		return $http.post(urlBase+'/book/new');
	};
	return dataFactory;
}]);