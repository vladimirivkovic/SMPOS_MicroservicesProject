(function (angular) {
    'use strict';
    
    var regUrl = 'http://localhost:8765/registry/api/'
    
    angular.module('app.Registar', [])
        .factory('Registar', ['$http', function ($http) {
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
                }
            };
    }]);

}(angular));