appCliente.controller("clienteDetalheController", function($scope, $routeParams, $http) {
	$scope.cliente = {};
	
	console.log("cliente"+$routeParams.clienteId)
 $http.get("/admin/cliente/"+$routeParams.clienteId)
 	.then(function(response) {
		$scope.cliente = response.data;
	}, function(response) {
		console.log(response)
	});
 
});