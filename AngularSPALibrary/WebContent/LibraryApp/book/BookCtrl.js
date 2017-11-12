angular.module('libraryApp').controller(
		'BookCtrl',
		[ '$scope', '$interval', 'dataFactory',
				function($scope, $interval, dataFactory) {
					$scope.books;
					getBooks();
					function getBooks() {
						dataFactory.getBooks().then(function(response) {
							$scope.books = response.data;
							console.log("it worked");
						}, function(error) {
							console.log("oh no!");
						});
					}
					
					$scope.deleteBook = function(bookId) {
						console.log("Delete");
						dataFactory.deleteBook(bookId).then(function(response) {
							console.log("Delete book worked");
						})
					}
					
					
					//we'd want to use $interval to refresh list periodically 
				} ]);