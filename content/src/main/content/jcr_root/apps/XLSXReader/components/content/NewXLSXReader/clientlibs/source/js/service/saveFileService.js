fupApp.service('saveFileService', function ($http) {
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
});