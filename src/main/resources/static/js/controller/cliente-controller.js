

appCliente.controller("clienteController", function($scope, $http) {
			$scope.cliente={};
			$scope.clientes =[];
			$scope.tela = 1;
			$scope.mensagem = false;
			
			

	$scope.carregarClientes = function() {
		
	token = localStorage.getItem("userToken");
		$http.defaults.headers.common.Authorization = "Bearer " + token;
		
		$http({
			method : 'GET',
			url : 'admin/clientes'
		}).then(function(response) {
			$scope.clientes = response.data;
			$scope.tela = 1;
			console.log(response.data);
			console.log(response.status);
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.cadrastarClientes = function(frmCliente) {
		if (frmCliente.$valid) {
			$http({
				method : 'POST',
				url : 'admin/cliente', data:$scope.cliente
			}).then(function(response) {
				console.log(response.data);
				$scope.clientes.push(response.data);
				$scope.carregarClientes();
				$scope.mensagem = false;
				$scope.cliente.nome=null;
				//frmCliente.setPrestine(true);
			}, function(response) {
				console.log(response.data);
				console.log(response.status);
			});
		}else {
			$scope.mensagem = true;
		
		}
		
	};
	
	$scope.deletarClientes = function(clienteID) {
		
		var opcao = confirm("Deseja realmente executar a operação ?");
		if (opcao == false) {
			alert("Operacao cancelada");
			return;
		}
		
		$http({
			method : 'DELETE',
			url : 'admin/cliente/'+ clienteID
		}).then(function(response) {
			console.log(response.data);
			$scope.carregarClientes();
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	
	$scope.alterarCliente = function(cliente) {
		$scope.cliente = angular.copy(cliente);
		$scope.tela = 2;
	}
	
	$scope.cancelar = function() {
		$scope.cliente={};
		$scope.tela =1;
		$scope.mensagem = false;
	}
	
	$scope.cadastrar = function() {
		$scope.cliente={};
		$scope.tela =3;
		$scope.mensagem = false;
	}
	
	
	$scope.carregarClientes();

});