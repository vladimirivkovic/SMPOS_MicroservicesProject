(function (angular) {
    'use strict';
    
    var regUrl = 'http://localhost:8765/activity/api/'
    
    angular.module('app.Aktivnost', [])
        .factory('Aktivnost', ['$http', function ($http) {
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
                delete: function (data) {
                    return $http({
                        method: 'DELETE',
                        url: regUrl,
                        data: data
                    });
                }
            };
    }]);

}(angular));