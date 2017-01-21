(function (angular) {
    "use strict";

    angular.module('app.HomeCtrl', [])
        .controller('HomeCtrl', function ($scope, $location) { //, Auth) {
            (function () {
//                Auth.isLogged(function (isLogged) {
//                    if (!isLogged) {
//                        $location.path('/login');
//                    }
//                });
            })();
        });
}(angular));