angular.module('libraryApp').controller(
		'AuthorCreateCtrl',
		[ '$scope', '$http', 'dataFactory',
				function($scope, $interval, dataFactory) {
					$scope.author = {
							firstname: '',
							lastname: '',
					};
					$scope.createAuthor = function() { 
						console.log("clicked");
						console.log($scope.author);
						
						dataFactory.createAuthor($scope.author).then(function(response) {
							console.log("it worked");
						})
						
					};

		
		} ]);
