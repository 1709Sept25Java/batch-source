angular.module('libraryApp').controller(
		'BookCreateCtrl',
		[ '$scope', '$http', 'dataFactory',
				function($scope, $interval, dataFactory) {
					$scope.book = {
							title: '',
							author: '',
					};
					$scope.createBook = function() { 
						console.log("clicked");
						console.log($scope.book);
						
						dataFactory.createBook($scope.book).then(function(response) {
							console.log("it worked");
						})
						
					};

		
		} ]);
