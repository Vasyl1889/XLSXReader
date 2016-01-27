var fupApp = angular.module('fupApp', [ 'ui.grid', 'ui.grid.edit','ngRoute','ngResource']);
fupApp.config(function($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: '/apps/XLSXReader/components/content/NewXLSXReader/home.jsp',
            controllerAs: 'tc',
            controller: 'testController'
        })
        .when('/test', {
            templateUrl: '/apps/XLSXReader/components/content/NewXLSXReader/test.jsp',
            controllerAs: 'tc',
            controller: 'testController'
        })
        .otherwise({
            redirectTo: '/home'
        });
});
/*controller('fupController', function($scope, $http, saveFileService) {
	var vm = this;
	vm.gridOptions = {};
	vm.filePath = "";
	vm.reset = resetFiles;
	vm.save = saveFiles;

	// NOW RESET THE DRID.
	function resetFiles() {
		vm.gridOptions.data = [];
		vm.gridOptions.columnDefs = [];
	};

	// NOW SAVE THE FILES.
	function saveFiles() {
		saveFileService.serviceSafeFile(vm.gridOptions.data, vm.filePath);
	};
})
.service('saveFileService', function ($http) {
	var _fileData = [];
    var _filePath = "";
    return {
    	serviceSafeFile: function (data, path) {
    		_fileData = data;
            _servisePath = path;

            $http.get("http://localhost:4502/apps/XLSXWriteServlet", {
            	params : {
            		filePath : _servisePath,
            		fileData : angular.toJson(_fileData)
            	}}
            ).success(function(data, status, headers, config) {
            	console.log("Write result " + data);
            }).error(function(data, status, headers, config) {
            	console.log("request write failure");
            });
            alert("Data was successfully saved.");
        }
    }
})
.service('uploadFileService', function ($http) {
	return {
		serviceUploadFile: function (path) {
            console.info("enter uploadFileService " + path);
			return $http.get("http://localhost:4502/apps/XLSXReaderServlet", {
					params : {
						filePath : path
					}
			})
        }
    }
})
.directive("fileread", ['uploadFileService', function (uploadFileService) {
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
}]);*/