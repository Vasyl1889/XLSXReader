fupApp.directive("fileread", ['uploadFileService', function (uploadFileService) {
	return {
		scope: {
			opts: '=',
			path: '='
		},
		link: function ($scope, $elm, $attrs) {
			$elm.on('change', function (changeEvent) {
				$scope.path = document.getElementById("file1").value;
                uploadFileService.serviceUploadFile($scope.path).then(function(response) {
                    $scope.opts.data = response.data;
                });;
                $elm.val(null);
			});
		}
	}
}]);