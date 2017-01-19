(function (angular) {
    "use strict";
    angular.module('app', ['ngRoute'])
    		//['app.controllers', 'app.services', 'app.directives', 'app.constants',
        //'ngRoute', 'ngAnimate', 'ngSanitize', 'ui.bootstrap'])
        .config(function ($routeProvider, $locationProvider, $httpProvider) {
            $routeProvider
                .when('/', {
                    redirectTo: '/login'
                })
                .when('/login', {
                    templateUrl: 'partials/login.html',
                    controller: 'LoginCtrl'
                })
                .when('/register', {
                    templateUrl: 'partials/register.html',
                    controller: 'RegisterCtrl'
                })
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
                .when('/sessions', {
                    templateUrl: 'partials/sessions.html',
                    controller: 'SessionsCtrl'
                })
                .when('/session-result/:id',{
                    templateUrl: 'partials/sessionResult.html',
                    controller: 'SessionResultCtrl'
                })
                .otherwise('/');

            $locationProvider.html5Mode(true);

        })
        .run(function ($location, $rootScope) {

        });
}(angular));