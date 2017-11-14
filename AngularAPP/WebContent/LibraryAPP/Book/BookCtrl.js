angular.module('LibraryAPP').controller('BookCtrl',['$scope','$interval','dataFactory',function($scope,$interval,dataFactory){
	$scope.books;
	getBooks();
	function getBooks(){
		dataFactory.getBooks().then(function(response){
			$scope.books=response.data;
			console.log("ok");
		},function(error){
			console.log("error");
		});
	};
	$scope.authors;
	getAuthors();
	function getAuthors(){
		dataFactory.getAuthors().then(function(response){
			$scope.authors=response.data;
			console.log("ok");
		});
	};
}]);