appCliente.controller("loginController", function($scope, $http,$location) {
	
	$scope.usuario = {};
	$scope.token="";
	
	$scope.autenticar = function() {
		
		$http.post("/autenticar",$scope.usuario).then(
				function(response) {
					$scope.token = response.data.token;
					localStorage.setItem("userToken",$scope.token);
					
					$location.path("/clientes")
					
				}, function(response) {
					console.log("Erro" + response.data)
				});
	}
});