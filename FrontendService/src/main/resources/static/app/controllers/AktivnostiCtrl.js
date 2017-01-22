(function (angular) {
    angular.module('app.AktivnostiCtrl', [])
        .controller('AktivnostiCtrl', ['$scope', '$rootScope', '$uibModal','Aktivnost', 
        	function ($scope, $rootScope,$uibModal, Aktivnost) {
	        	$scope.init = function() {
					$scope.data = Aktivnost.get().then(
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
	        	
	        	$scope.createNew = function (a, readonly) {
				    var modalInstance = $uibModal.open({
				      ariaLabelledBy: 'modal-title',
				      ariaDescribedBy: 'modal-body',
				      templateUrl: 'partials/modals/aktivnostModal.html',
				      controller: 'AktivnostModalCtrl',
				      resolve: {
				          a: function () {
				            return a;
				          },
				          readOnly: function () {
					            return readonly;
				          }
				        }
				    });
				
				    modalInstance.result.then(function (akt) {
				    	$scope.save(akt);
				    }, function () {
				      // $log.info('Modal dismissed at: ' + new Date());
				    });
				  };
				  
				  $scope.enterResults = function (a, readonly) {
					    var modalInstance = $uibModal.open({
					      ariaLabelledBy: 'modal-title',
					      ariaDescribedBy: 'modal-body',
					      templateUrl: 'partials/modals/resultsModal.html',
					      controller: 'ResultsModalCtrl',
					      resolve: {
					          a: function () {
					            return a;
					          },
					          readOnly: function () {
						            return readonly;
					          }
					        }
					    });
					
					    modalInstance.result.then(function (akt) {
					    	a.procenatOstvarenosti = akt.procenatOstvarenosti;
					    	a.ocenaEfekta = akt.ocenaEfekta;
					    	a.datumRealizacije = akt.datumRealizacije;
					    	$scope.save(a);
					    }, function () {
					      // $log.info('Modal dismissed at: ' + new Date());
					    });
					  };
					  
					  $scope.verify = function (a, readonly) {
						    var modalInstance = $uibModal.open({
						      ariaLabelledBy: 'modal-title',
						      ariaDescribedBy: 'modal-body',
						      templateUrl: 'partials/modals/verifyModal.html',
						      controller: 'VerifyModalCtrl',
						      resolve: {
						          a: function () {
						            return a;
						          },
						          readOnly: function () {
							            return readonly;
						          }
						        }
						    });
						
						    modalInstance.result.then(function (akt) {
						    	a.obimRealizacije = akt.obimRealizacije;
						    	a.procenatRealizacije = akt.procenatRealizacije;
						    	a.verifikacijaEfekta = akt.verifikacijaEfekta;
						    	a.datumVerifikacije = akt.datumVerifikacije;
						    	$scope.save(a);
						    }, function () {
						      // $log.info('Modal dismissed at: ' + new Date());
						    });
						  };
				  
				  $scope.save = function(a) {
					  if (a.id) {
						  Aktivnost.put(a).then(
		                    function (response) {
		                    	$scope.init();
		                    },
		                    function (error) {
		                    	alert(error.data.message);
		                        console.log(error);
		                    }
		                );
						  
					  } else {
						  Aktivnost.post(a).then(
		                    function (response) {
		                    	$scope.init();
		                    },
		                    function (error) {
		                    	alert(error.data.message);
		                        console.log(error);
		                    }
		                );
					  }
				  }
				  
				  $scope.delete = function(id) {
					  Aktivnost.delete(id).then(
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
				    	  // date = date.format("DD-MM-YYYY");
				    	  date = date.getDate() + '.' + (date.getMonth()+1) + '.' + date.getFullYear();
				      }
					  
					  return date;
				  }
        	
        }]);
}(angular));