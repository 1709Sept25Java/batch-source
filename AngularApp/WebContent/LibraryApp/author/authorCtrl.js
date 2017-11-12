angular.module('libraryApp').controller('authorCtrl',
		['$scope','dataFactory',function($scope,dataFactory){
			$scope.authors;
			getAuthors();
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