var app = angular.module('libraryApp',['ngRoute']); //create module, pass in dependency
app.config(function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl:'home.html'
	})
	.when('/author',{
		templateUrl: 'author/authorView.html',
		controller: 'AuthorCtrl'
	})
	.when('/book',{
		templateUrl: 'book/bookView.html',
		controller: 'BookCtrl'
	})
	.otherwise({redirectTo: '/'});
});

app.factory('dataFactory',['$http',function($http){
	var urlBase = 'http://localhost:8084';
	var dataFactory = {};
	dataFactory.getBooks = function(){
		return $http.get(urlBase+'/book/all');
	};
	dataFactory.newBook = function(book){
		return $http.post(urlBase+'/book/new',JSON.stringify(book));
	};
	dataFactory.getAuthors = function(){
		return $http.get(urlBase+'/author/all');
	};
	dataFactory.newAuthor = function(author){
		return $http.post(urlBase+'/author/new',JSON.stringify(author));
	};
	return dataFactory;
}]);