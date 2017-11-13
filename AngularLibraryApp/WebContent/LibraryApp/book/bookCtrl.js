angular.module('libraryApp').controller(
		'BookCtrl',
		['$scope', '$interval','dataFactory',
			function($scope, $interval, dataFactory){
			$scope.books
			getBooks();
			function getBooks(){
				dataFactory.getBooks().then(function(response){
					$scope.books = response.data;
					console.log($scope.books);
				})
			}
			$scope.authors;
			getAuthors();
			function getAuthors(){
				dataFactory.getAuthors().then(function(response){
					$scope.authors = response.data;
				})
			}
			$scope.book = {id: 0,title: null,author: null};
			$scope.newBook = function(){
				console.log($scope.book);
				dataFactory.newBook($scope.book).then(function(response){
					$scope.status = 'Success!'
				})
			}
		}]);