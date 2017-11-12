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
	.when('/author/create',{
		templateUrl: 'author/authorCreate.html',
		controller: 'AuthorCreateCtrl'
	})
	.when('/book',{
		templateUrl: 'book/bookView.html',
		controller: 'BookCtrl'
	})
	.when('/book/create',{
		templateUrl: 'book/bookCreate.html',
		controller: 'BookCreateCtrl'
	})
	.otherwise({redirectTo: '/'});
});
app.factory('dataFactory',['$http',function($http){
	var urlBase = 'http://localhost:8084';
	var dataFactory = {};
	dataFactory.getBooks = function(){
		return $http.get(urlBase+'/book/all');
	};
	dataFactory.getAuthors = function(){
		return $http.get(urlBase+'/author/all')
	}
	dataFactory.createAuthor = function(author){
		return $http.post(urlBase+'/author/add',JSON.stringify(author));
	}
	dataFactory.deleteAuthor = function(id) {
		return $http.delete(urlBase+'/author/delete/' + id, id);
	}
	dataFactory.createBook = function(book){
		return $http.post(urlBase+'/book/add',JSON.stringify(book));
	}
	dataFactory.deleteBook = function(id) {
		return $http.delete(urlBase+'/book/delete/' + id, id);
	}
	return dataFactory;
}])