(function(angular) {
	angular.module('app.UserModalCtrl', []).controller(
			'UserModalCtrl',
			[ '$scope', '$uibModalInstance', 'u',
					function($scope, $uibModalInstance, u) {
						$scope.save = function() {
							var ret = $scope.validate();
							if (ret) {
								console.log('saving...');
								console.log(ret)
								$uibModalInstance.close(ret);
							}
						}

						$scope.cancel = function() {
							console.log('cancel...');
							$uibModalInstance.dismiss('cancel');
						}

						$scope.validate = function() {
							var x = {}
							
							if ($scope.password != $scope.rpassword) {
								alert("Lozinke se razlikuju!");
								return null;
							}

							x.id = $scope.id;
							x.username = $scope.uusername;
							x.password = $scope.password;
							x.ime = $scope.ime;
							x.prezime = $scope.prezime;
							x.uloga = $scope.uloga;

							return x;
						}

						if (u) {
							$scope.id = u.id;
							$scope.uusername = u.username;
							$scope.ime = u.ime;
							$scope.prezime = u.prezime;
							$scope.uloga = u.uloga;
						}
					} ]);
}(angular));