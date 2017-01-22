(function (angular) {
    "use strict";

    angular.module('app.LogoutCtrl', [])
        .controller('LogoutCtrl', function ($location, $rootScope, $window) {
            (function () {
            	$rootScope.display = null;
                $rootScope.username = null;
                $window.localStorage.setItem('display', null);
                $window.localStorage.setItem('username', null);
                $window.localStorage.setItem('token', null);
                $location.path('#/login');
            })();
        });
}(angular));