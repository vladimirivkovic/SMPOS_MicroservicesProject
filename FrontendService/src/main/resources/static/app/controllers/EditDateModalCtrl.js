(function (angular) {
    angular.module('app.EditDateModalCtrl', [])
        .controller('EditDateModalCtrl', ['$scope', '$uibModalInstance', 'title', 'fieldName', 'date',
        	function ($scope, $uibModalInstance, title, fieldName, date) {
        		$scope.title = title;
        		$scope.fieldName = fieldName;
        		
        		$scope.save = function() {
        			console.log('saving...');
        			console.log($scope.rok)
        			$uibModalInstance.close($scope.rok);
        		}
        		
        		$scope.cancel = function() {
        			console.log('cancel...');
        			$uibModalInstance.dismiss('cancel');
        		}
        		
        		if (date)
        		    $scope.rok = date;
        		else
        			$scope.rok = new Date();

        		  $scope.clear = function() {
        		    $scope.rok = null;
        		  };

        		  $scope.open1 = function() {
        		    $scope.popup1.opened = true;
        		  };

        		  $scope.setDate = function(year, month, day) {
        		    $scope.planiranRok = new Date(year, month, day);
        		  };

        		  $scope.format = 'dd-MMMM-yyyy';
        		  $scope.altInputFormats = ['M!/d!/yyyy'];

        		  $scope.popup1 = {
        		    opened: false
        		  };
        }]);
}(angular));