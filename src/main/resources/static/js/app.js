var appCliente = angular.module("appCliente", [ 'ngRoute' ]);
appCliente.config(function($routeProvider,$locationProvider) {
	$routeProvider.when("/clientes", {
		title : 'Cliente',
		templateUrl : 'view/cliente.html',
		controller : 'clienteController'
	}).when("/estados", {
		title : 'estados',
		templateUrl : 'view/estado.html',
		controller : 'estadoController'
	})
	.when("/clientes/:clienteId", {
		title : 'ClienteDetalhe',
		templateUrl : 'view/cliente-detalhe.html',
		controller : 'clienteDetalheController'
	}).when("/cidades", {
		title : 'cidades',
		templateUrl : 'view/cidade.html',
		controller : 'cidadeController'
	}).when("/login", {
		title : 'Login',
		templateUrl : 'view/login.html',
		controller : 'loginController'
	}).otherwise({
		rediretTo : '/'
	});
	
	
	$locationProvider.html5Mode(true);
});

appCliente.config(function($httpProvider) {
	$httpProvider.interceptors.push("tokenInterceptor");
});