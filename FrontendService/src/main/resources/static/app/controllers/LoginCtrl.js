(function (angular) {
    "use strict";

    angular.module('app.LoginCtrl', [])
        .controller('LoginCtrl', function ($scope, $location, User, $rootScope) {
            var success = function (response) {
                    console.log(response);
                    $location.path('/home');
                },
                error = function (response) {
                    console.log(response);
                    $scope.alertMessage = "Pogresni korisnicko ime i/ili lozinka";
                };

            $scope.login = function () {
                if (!$scope.username) {
                    $scope.alertMessage = 'Korisnicko ime prazno.';
                } else if (!$scope.password) {
                    $scope.alertMessage = 'Lozinka prazna';
                } else {
                    $scope.alertMessage = null;
                }

                if ($scope.alertMessage) {
                    return;
                }
                
                var u = {username : $scope.username, password : $scope.password};

                User.login(u).then(success, error);
            };

            (function () {
                $scope.user = {};
                User.isLogged(function (isLogged) {
                    if (isLogged) {
                        $location.path('/home');
                    }
                });
            })();
        });
}(angular));