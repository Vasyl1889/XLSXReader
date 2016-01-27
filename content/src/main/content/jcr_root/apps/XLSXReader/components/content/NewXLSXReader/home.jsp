<div ng-controller="fupController as vm">
	<br />
	<button type="button" class="btn btn-success" ng-disabled="!vm.gridOptions.data.length" ng-click="vm.reset()">Reset Grid</button>
	<button type="button" class="btn btn-success" ng-disabled="!vm.gridOptions.data.length" ng-click="vm.save()">Save Grid</button>
	<br />
	<br />
	<div id="grid1" ui-grid="vm.gridOptions" ui-grid-edit class="grid">
		<div class="grid-msg-overlay" ng-show="!vm.gridOptions.data.length">
			<div class="msg">
				<div class="center">
					<span class="muted">Select Spreadsheet File</span> <br />
					<input type="file" accept=".xlsx" id="file1" name="file" fileread="" opts="vm.gridOptions" path="vm.filePath" multiple="false" />
				</div>
			</div>
		</div>
	</div>
	<br /> 
	<a href="#/test"> View Country list</a>
</div>