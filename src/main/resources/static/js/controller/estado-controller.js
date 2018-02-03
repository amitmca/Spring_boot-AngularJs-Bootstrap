appCliente.controller("estadoController", function($scope, $http){
		
	$scope.estados=[];
	
	 $http.get("http://localhost:8080/estado")
	 	.then(function(response) {
			$scope.estados = response.data;
		}, function(response) {
			console.log(response)
		});
	 
});