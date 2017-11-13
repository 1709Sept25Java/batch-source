angular.module('libraryApp').controller(
		'AuthorCtrl',
		['$scope', '$interval', 'dataFactory',
			function($scope, $interval, dataFactory){
			$scope.authors;
			getAuthors();
			$interval(function() {
				getAuthors();
			}, 20000);
			function getAuthors(){
				dataFactory.getAuthors().then(function(response){
					$scope.authors = response.data;
				})
			}
			$scope.author;
			$scope.author = {id:0,firstName:null,lastName:null};
			$scope.newAuthor = function(){
				console.log($scope.author)
				dataFactory.newAuthor($scope.author).then(function(response){
					$scope.status='Success!';
				}),function(error){
					$scope.status=error.message;
				}
			}
		}])