
var app = angular.module('libraryApp',['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl: 'home.html'
	})
	.when('/books',{
		templateUrl: 'book/bookView.html',
		controller: 'bookCtrl'
	})
	.when('/authors',{
		templateUrl: 'author/authorView.html',
		controller: 'authorCtrl'
	})
	.otherwise({redirectTo:'/'})
})

app.factory('dataFactory',['$http',function($http){
	var urlBase = 'http://localhost:8084';
	var dataFactory = {};
	dataFactory.getBooks = function(){
		return $http.get(urlBase+'/book/all');
	};
	dataFactory.newBook = function(book){
		return $http.post(urlBase+'/book/new',JSON.stringify(book));
	}
	dataFactory.getAuthors = function(){
		return $http.get(urlBase+'/author/all')
	}
	dataFactory.newAuthor = function(author){
		return $http.post(urlBase+'/author/new',JSON.stringify(author));
	}
	return dataFactory;
}])