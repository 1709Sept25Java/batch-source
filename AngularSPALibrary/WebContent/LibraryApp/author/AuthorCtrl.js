angular.module('libraryApp').controller(
		'AuthorCtrl',
		[ '$scope', '$interval', 'dataFactory',
				function($scope, $interval, dataFactory) {
					$scope.authors;
					getAuthors();
					function getAuthors() {
						dataFactory.getAuthors().then(function(response) {
							$scope.authors = response.data;
							console.log("it worked");
						}, function(error) {
							console.log("oh no!");
						});
					}
					$scope.deleteAuthor = function(authorId) {
						console.log("Delete");
						dataFactory.deleteAuthor(authorId).then(function(response) {
							console.log("Deleted author worked");
						})
					}
		} ]);
