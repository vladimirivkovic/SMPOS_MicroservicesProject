(function (angular) {
    angular.module('app.UsersCtrl', [])
        .controller('UsersCtrl', ['$scope', '$rootScope', '$uibModal','User', 
        	function ($scope, $rootScope,$uibModal, User) {
	        	$scope.init = function() {
					$scope.data = User.get().then(
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
	        	
	        	$scope.createNew = function (u) {
				    var modalInstance = $uibModal.open({
				      ariaLabelledBy: 'modal-title',
				      ariaDescribedBy: 'modal-body',
				      templateUrl: 'partials/modals/userModal.html',
				      controller: 'UserModalCtrl',
				      resolve: {
				          u: function () {
				            return u;
				          }
				        }
				    });
				
				    modalInstance.result.then(function (u) {
				    	$scope.save(u);
				    }, function () {
				      // $log.info('Modal dismissed at: ' + new Date());
				    });
				  };
				  
				  
				  
				  $scope.save = function(a) {
					  if (a.id) {
						  User.put(a).then(
		                    function (response) {
		                    	$scope.init();
		                    },
		                    function (error) {
		                        console.log(error);
		                    }
		                );
						  
					  } else {
						  User.post(a).then(
		                    function (response) {
		                    	$scope.init();
		                    },
		                    function (error) {
		                        console.log(error);
		                    }
		                );
					  }
				  }
				  
				  $scope.delete = function(id) {
					  User.delete(id).then(
	                    function (response) {
	                    	$scope.init();
	                    },
	                    function (error) {
	                        console.log(error);
	                    }
	                );
				  }
				  
				  $scope.printUloga = function(uloga) {
					  if (uloga == 'RUK_KVALITET') {
						  return 'Predstavnik rukovodstva za kvalitet';
					  } else if (uloga == 'RUK_TIMA') {
						  return 'Rukovodilac tima';
					  } else if (uloga == 'RUK_OJ') {
						  return 'Rukovodilac organizacione jedinice';
					  } else if (uloga == 'ADMIN') {
						  return 'Administrator sistema';
					  } else {
						  return '';
					  }
				  }
				  
        	
        }]);
}(angular));