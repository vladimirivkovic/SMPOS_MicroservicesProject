(function (angular) {
    'use strict';
    
    var regUrl = 'http://localhost:8765/user/api/'
    
    angular.module('app.User', [])
        .factory('User', ['$http', '$rootScope', '$window', function ($http, $rootScope, $window) {	
        	var storeData = function (role, username, token) {
                $rootScope.display = role;
                $rootScope.username = username;
                $window.localStorage.setItem('display', role);
                $window.localStorage.setItem('username', username);
                $window.localStorage.setItem('token', token);
            };
            
            return {
                getById: function (id) {
                    return $http({
                        method: 'GET',
                        url: regUrl + id
                    });
                },
                get: function () {
                    return $http({
                        method: 'GET',
                        url: regUrl,
                        //params: filter
                    });
                },
                post: function (data) {
                    return $http({
                        method: 'POST',
                        url: regUrl,
                        data: data
                    });
                },
                put: function (data) {
                    return $http({
                        method: 'PUT',
                        url: regUrl + data.id,
                        data: data
                    });
                },
                delete: function (id) {
                    return $http({
                        method: 'DELETE',
                        url: regUrl + id
                    });
                },
                isLogged: function (callback) {
                    return $http({
                        method: 'GET',
                        url: regUrl + 'checkUser'
                    }).then(
                        function (response) {
                        	console.log(response);
                            storeData(response.data.uloga, response.data.username, response.data.id);
                            callback(true);
                        },
                        function () {
                            storeData('login', null);
                            callback(false);
                        }
                    );
                },
                login: function (user) {
                    return $http({
                        method: 'POST',
                        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                        url: regUrl + 'login',
                        data: $.param({username: user.username, password: user.password})
                        
                    }).then(
                            function (response) {
                                storeData(response.data.uloga, response.data.username, response.data.id);
                            },
                            function () {
                                storeData('login', null, null);
                            }
                        );;
                },
            };
    }]);

}(angular));