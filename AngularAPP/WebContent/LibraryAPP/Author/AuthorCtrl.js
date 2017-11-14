angular.module('LibraryAPP').controller('AuthorCtrl',['$scope','$interval','dataFactory',function($scope,$interval,dataFactory){
	$scope.authors;
	getAuthors();
	function getAuthors(){
		dataFactory.getAuthors().then(function(response){
			$scope.authors=response.data;
			console.log("ok");
		},function(error){
			console.log("error");
		});
	}
	
}]);