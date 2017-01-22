(function(angular) {
	angular.module('app.AktivnostModalCtrl', []).controller(
			'AktivnostModalCtrl',
			[ '$scope', '$uibModalInstance', 'a', 'readOnly',
					function($scope, $uibModalInstance, a, readOnly) {
						$scope.readonly = readOnly;

						$scope.save = function() {
							var ret = $scope.validate();
							if (!ret.brojMere) {
								alert(ret);
								return;
							}
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

							if (!$scope.brojMere)
								return 'Broj mere nije unet!';
							if (!$scope.nosilacAktivnosti)
								return 'Nosilac aktivnosti nije unet!';
							if (!$scope.opis)
								return 'Opis nije unet!';
							if (!$scope.cilj)
								return 'Cilj nije unet!';
							if (!$scope.ocekivaniEfekti)
								return 'Ocekivani efekti nisu uneti!';
//							if (!$scope.rukovodilacTima)
//								return 'Rukovodilac tima nije unet!';

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
							$scope.datumPotpisa = new Date();
						};
						$scope.today();

						$scope.clear = function() {
							$scope.datumPotpisa = null;
						};

						$scope.open1 = function() {
							$scope.popup1.opened = true;
						};

						$scope.setDate = function(year, month, day) {
							$scope.datumPotpisa = new Date(year, month, day);
						};

						$scope.format = 'dd-MMMM-yyyy';
						$scope.altInputFormats = [ 'M!/d!/yyyy' ];

						$scope.popup1 = {
							opened : false
						};

						if (a) {
							$scope.id = a.id;
							$scope.brojMere = a.brojMere;
							$scope.nosilacAktivnosti = a.nosilacAktivnosti;
							$scope.opis = a.opis;
							$scope.cilj = a.cilj;
							$scope.ocekivaniEfekti = a.ocekivaniEfekti;
							$scope.napomena = a.napomena;
							$scope.rukovodilacTima = a.rukovodilacTima;
							$scope.datumPotpisa = a.datumPotpisa;
						}
					} ]);
}(angular));