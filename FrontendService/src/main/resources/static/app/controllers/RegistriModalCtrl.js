(function (angular) {
    angular.module('app.RegistriModalCtrl', [])
        .controller('RegistriModalCtrl', ['$scope', '$uibModalInstance', 'r',
        	function ($scope, $uibModalInstance, r) {       		
        		$scope.save = function() {
        			var ret = $scope.validate();
        			console.log('saving...');
        			console.log(ret)
        			$uibModalInstance.close(ret);
        		}
        		
        		$scope.cancel = function() {
        			console.log('cancel...');
        			$uibModalInstance.dismiss('cancel');
        		}
        		
        		$scope.validate = function() {
        			var x = {}
        			
        			x.datumOtvaranja = $scope.datumOtvaranja;
        			x.broj = $scope.broj;
        			x.id = $scope.id;
        			
        			return x;
        		}
        		
        		$scope.today = function() {
        		    $scope.datumOtvaranja = new Date();
        		  };
        		  $scope.today();

        		  $scope.clear = function() {
        		    $scope.datumOtvaranja = null;
        		  };

        		  $scope.open1 = function() {
        		    $scope.popup1.opened = true;
        		  };

        		  $scope.setDate = function(year, month, day) {
        		    $scope.datumOtvaranja = new Date(year, month, day);
        		  };

        		  $scope.format = 'dd-MMMM-yyyy';
        		  $scope.altInputFormats = ['M!/d!/yyyy'];

        		  $scope.popup1 = {
        		    opened: false
        		  };
        		  
        		  if (r) {
        			  $scope.id = r.id;
        			  $scope.broj = r.broj;
        			  $scope.datumOtvaranja = r.datumOtvaranja;
        		  }
        }]);
}(angular));