(function (angular) {
    "use strict";
    angular.module('app', ['app.controllers', 'app.services',
    	'ngRoute', 'ngAnimate', 'ngSanitize', 'ui.bootstrap'])
        .config(function ($routeProvider, $locationProvider, $httpProvider) {
            $routeProvider
                .when('/', {
                    redirectTo: '/login'
                })
                .when('/registarMera', {
                    templateUrl: 'partials/registar.html',
                    controller: 'RegistarCtrl'
                })
                .when('/registri', {
                    templateUrl: 'partials/registri.html',
                    controller: 'RegistriCtrl'
                })
                .when('/naloziAktivnosti', {
                    templateUrl: 'partials/aktivnosti.html',
                    controller: 'AktivnostiCtrl'
                })
                .when('/login', {
                    templateUrl: 'partials/login.html',
                    controller: 'LoginCtrl'
                })
//                .when('/register', {
//                    templateUrl: 'partials/register.html',
//                    controller: 'RegisterCtrl'
//                })
                .when('/logout', {
                    template: '',
                    controller: 'LogoutCtrl'
                })
                .when('/home', {
                    templateUrl: 'partials/home.html',
                    controller: 'HomeCtrl'
                })
                .when('/users', {
                    templateUrl: 'partials/users.html',
                    controller: 'UsersCtrl'
                })
//                .when('/sessions', {
//                    templateUrl: 'partials/sessions.html',
//                    controller: 'SessionsCtrl'
//                })
//                .when('/session-result/:id',{
//                    templateUrl: 'partials/sessionResult.html',
//                    controller: 'SessionResultCtrl'
//                })
                .otherwise('/');

            //$locationProvider.html5Mode(true);
            $httpProvider.interceptors.push('authInterceptor');

        })
        .run(function ($location, $rootScope, User, $window) {
        	User.isLogged(function (isLogged) {
                if (!isLogged) {
                    $location.path('#/login');
                }
            });
        	$rootScope.$on( "$routeChangeStart", function(event, next, current) {
        		$rootScope.display = $window.localStorage.getItem('display');
        		$rootScope.username = $window.localStorage.getItem('username');
        	});

        }).factory('authInterceptor', function($location, $q, $window) {


        	return {
        	    request: function(config) {
        	      config.headers = config.headers || {};

        	      config.headers.Authorization = $window.localStorage.getItem('token');

        	      return config;
        	    }
        	  };
        	})

        	.config(function($httpProvider) {
        	  
        });
}(angular));