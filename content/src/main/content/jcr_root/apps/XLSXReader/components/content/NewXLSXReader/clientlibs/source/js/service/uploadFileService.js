fupApp.service('uploadFileService', function ($http) {
	return {
		serviceUploadFile: function (path) {
            //console.info("enter uploadFileService " + path);
			return $http.get("http://localhost:4502/apps/XLSXReaderServlet", {
					params : {
						filePath : path
					}
			})
        }
    } 
});