fupApp.controller('fupController', function($scope, $http, saveFileService) {
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
});