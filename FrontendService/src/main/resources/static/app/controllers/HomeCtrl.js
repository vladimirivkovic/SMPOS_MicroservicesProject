(function (angular) {
    "use strict";

    angular.module('app.HomeCtrl', [])
        .controller('HomeCtrl', function ($scope, $location, User) {
            (function () {
                User.isLogged(function (isLogged) {
                    if (!isLogged) {
                        $location.path('#/login');
                    }
                });
            })();
        });
}(angular));