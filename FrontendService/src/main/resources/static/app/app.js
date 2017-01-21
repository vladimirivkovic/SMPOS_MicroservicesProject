(function (angular) {
    "use strict";
    angular.module('app', ['app.controllers', 'app.services',
    	'ngRoute', 'ngAnimate', 'ngSanitize', 'ui.bootstrap'])
        .config(function ($routeProvider, $locationProvider, $httpProvider) {
            $routeProvider
                .when('/', {
                    redirectTo: '/home'
                })
                .when('/registarMera', {
                    templateUrl: 'partials/registar.html',
                    controller: 'RegistarCtrl'
                })
                .when('/naloziAktivnosti', {
                    templateUrl: 'partials/aktivnosti.html',
                    controller: 'AktivnostiCtrl'
                })
//                .when('/login', {
//                    templateUrl: 'partials/login.html',
//                    controller: 'LoginCtrl'
//                })
//                .when('/register', {
//                    templateUrl: 'partials/register.html',
//                    controller: 'RegisterCtrl'
//                })
//                .when('/logout', {
//                    template: '',
//                    controller: 'LogoutCtrl'
//                })
                .when('/home', {
                    templateUrl: 'partials/home.html',
                    controller: 'HomeCtrl'
                })
//                .when('/users', {
//                    templateUrl: 'partials/users.html',
//                    controller: 'UsersCtrl'
//                })
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

        })
        .run(function ($location, $rootScope) {
//        	Auth.isLogged(function (isLogged) {
//                if (!isLogged) {
//                    $location.path('/login');
//                }
//            });

        });
}(angular));