(function(angular) {
	angular.module('app.VerifyModalCtrl', []).controller(
			'VerifyModalCtrl',
			[ '$scope', '$uibModalInstance', 'a', 'readOnly',
					function($scope, $uibModalInstance, a, readOnly) {
						$scope.readonly = readOnly;

						$scope.save = function() {
							//var ret = $scope.validate();
							console.log('saving...');
							console.log($scope.a)
							$uibModalInstance.close($scope.a);
						}

						$scope.cancel = function() {
							console.log('cancel...');
							$uibModalInstance.dismiss('cancel');
						}

						$scope.validate = function() {
							var x = {}

							x.brojMere = $scope.brojMere;
							x.nosilacAktivnosti = $scope.nosilacAktivnosti;
							x.opis = $scope.opis;
							x.cilj = $scope.cilj;
							x.ocekivaniEfekti = $scope.ocekivaniEfekti;
							x.napomena = $scope.napomena;
							x.rukovodilacTima = $scope.rukovodilacTima;
							x.datumPotpisa = $scope.datumPotpisa;
							x.id = $scope.id;

							return x;
						}

						$scope.today = function() {
							$scope.a.datumVerifikacije = new Date();
						};
						

						$scope.clear = function() {
							$scope.a.datumVerifikacije = null;
						};

						$scope.open1 = function() {
							$scope.popup1.opened = true;
						};

						$scope.setDate = function(year, month, day) {
							$scope.a.datumVerifikacije = new Date(year, month, day);
						};

						$scope.format = 'dd-MMMM-yyyy';
						$scope.altInputFormats = [ 'M!/d!/yyyy' ];

						$scope.popup1 = {
							opened : false
						};

						if (a) {
							$scope.a = a;
						} else {
							a = {}
							
						}
						
						if (!$scope.a.datumVerifikacije) $scope.today();
					} ]);
}(angular));