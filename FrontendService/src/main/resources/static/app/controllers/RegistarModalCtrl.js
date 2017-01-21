(function (angular) {
    angular.module('app.RegistarModalCtrl', [])
        .controller('RegistarModalCtrl', ['$scope', '$uibModalInstance', 'r',
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
        			
        			x.redniBroj = $scope.redniBroj;
        			x.ppu = $scope.ppu;
        			x.neusaglasnost = $scope.neusaglasnost;
        			x.mera = $scope.mera;
        			x.rukovodilacTima = $scope.rukovodilacTima;
        			x.planiranRok = $scope.planiranRok;
        			x.produzenRok = $scope.produzenRok;
        			x.ostvarenRok = $scope.ostvarenRok;
        			x.id = $scope.id;
        			
        			return x;
        		}
        		
        		$scope.today = function() {
        		    $scope.planiranRok = new Date();
        		  };
        		  $scope.today();

        		  $scope.clear = function() {
        		    $scope.planiranRok = null;
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
        		  
        		  if (r) {
        			  $scope.id = r.id;
        			  $scope.redniBroj = r.redniBroj;
        			  $scope.ppu = r.ppu;
        			  $scope.neusaglasnost = r.neusaglasnost;
        			  $scope.mera = r.mera;
        			  $scope.rukovodilacTima = r.rukovodilacTima;
        			  $scope.planiranRok = r.planiranRok;
        		  }
        }]);
}(angular));