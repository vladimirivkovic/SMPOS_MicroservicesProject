(function (angular) {
    angular.module('app.RegistriCtrl', [])
        .controller('RegistriCtrl', ['$scope', '$rootScope', '$uibModal', 'Registri',
        	function ($scope, $rootScope, $uibModal, Registri) {
        		$scope.init = function() {
					$scope.data = Registri.get().then(
	                    function (response) {
	                        $scope.data = response.data;
	                    },
	
	                    function (error) {
	                        $scope.data = [];
	                        console.log(error);
	                    }
	                );
        		}
        		
        		$scope.init();
				
				$scope.createNew = function (r) {
				    var modalInstance = $uibModal.open({
				      ariaLabelledBy: 'modal-title',
				      ariaDescribedBy: 'modal-body',
				      templateUrl: 'partials/modals/registriModal.html',
				      controller: 'RegistriModalCtrl',
				      resolve: {
				          r: function () {
				            return r;
				          }
				        }
				    });
				
				    modalInstance.result.then(function (mera) {
				    	$scope.save(mera);
				    }, function () {
				      // $log.info('Modal dismissed at: ' + new Date());
				    });
				  };
				  
				  $scope.save = function(r) {
					  if (r.id) {
						  Registri.put(r).then(
		                    function (response) {
		                    	$scope.init();
		                    },
		                    function (error) {
		                    	$scope.init();
		                    	alert(error.data.message);
		                        console.log(error);
		                    }
		                );
						  
					  } else {
						  Registri.post(r).then(
		                    function (response) {
		                    	$scope.init();
		                    },
		                    function (error) {
		                    	$scope.init();
		                    	alert(error.data.message);
		                        console.log(error);
		                    }
		                );
					  }
				  }
				  
				  $scope.delete = function(id) {
					  Registri.delete(id).then(
	                    function (response) {
	                    	$scope.init();
	                    },
	                    function (error) {
	                        console.log(error);
	                    }
	                );
				  }
				  
				  
				  $scope.printDate = function(unix_timestamp) {
					  var date = '';
					  
				      if (unix_timestamp) {
				    	  date = new Date(unix_timestamp);
				    	  //date = date.format("DD-MM-YYYY");
				    	  date = date.getDate() + '.' + (date.getMonth()+1) + '.' + date.getFullYear();
				      }
					  
					  return date;
				  }
        	}]);
}(angular));
        