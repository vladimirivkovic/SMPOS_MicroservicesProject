(function (angular) {
    angular.module('app.RegistarCtrl', [])
        .controller('RegistarCtrl', ['$scope', '$rootScope', '$uibModal', 'Registar',
        	function ($scope, $rootScope, $uibModal, Registar) {
        		$scope.init = function() {
					$scope.data = Registar.get().then(
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
				      templateUrl: 'partials/modals/registarModal.html',
				      controller: 'RegistarModalCtrl',
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
				  
				  $scope.close = function (r) {
					    var modalInstance = $uibModal.open({
					      ariaLabelledBy: 'modal-title',
					      ariaDescribedBy: 'modal-body',
					      templateUrl: 'partials/modals/EditDateModal.html',
					      controller: 'EditDateModalCtrl',
					      resolve: {
					    	  date: function () {
					            return null;
					          },
					          fieldName: function () {
						            return 'Ostvareni rok:';
						          },
					          title: function () {
						            return 'Zakljucivanje mere';
						       }
					        }
					    });
					
					    modalInstance.result.then(function (d) {
					    	r.ostvarenRok = d;
					    	$scope.save(r);
					    }, function () {
					      // $log.info('Modal dismissed at: ' + new Date());
					    });
					  };
				  
				  $scope.postpone = function (r) {
					    var modalInstance = $uibModal.open({
					      ariaLabelledBy: 'modal-title',
					      ariaDescribedBy: 'modal-body',
					      templateUrl: 'partials/modals/EditDateModal.html',
					      controller: 'EditDateModalCtrl',
					      resolve: {
					    	  date: function () {
					            return r.planiranRok;
					          },
					          fieldName: function () {
						            return 'Produzeni rok:';
						          },
					          title: function () {
						            return 'Produzavanje roka';
						       }
					        }
					    });
					
					    modalInstance.result.then(function (d) {
					    	r.produzenRok = d;
					    	$scope.save(r);
					    }, function () {
					      // $log.info('Modal dismissed at: ' + new Date());
					    });
					  };
				  
				  $scope.save = function(r) {
					  if (r.id) {
						  Registar.put(r).then(
		                    function (response) {
		                    	$scope.init();
		                    },
		                    function (error) {
		                        console.log(error);
		                    }
		                );
						  
					  } else {
					    Registar.post(r).then(
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
					  Registar.delete(id).then(
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
        